(ns katello.system-templates
  (:require (katello [navigation :as nav]
                     [ui-common :as ui]
                     [notifications :as notification] 
                     [tasks :refer [capitalize-all]])
            [com.redhat.qe.auto.selenium.selenium :as sel]))

;; Locators

(sel/template-fns
 {action            "//a[@data-name='%2$s' and .='%s']"
  eligible-category "//div[@id='content_tree']//div[normalize-space()='%s']"
  product           "//span[contains(@class, 'custom-product-sprite')]/following-sibling::span/text()[contains(.,'%s')]"})

(swap! ui/uimap merge
       {::new                     "new"
        ::name-text               "system_template[name]"
        ::description-text        "system_template[description]"
        ::save-new                "template_save" ;;when creating
        ::eligible-package-groups (eligible-category "Package Groups")
        ::eligible-packages       (eligible-category "Packages")
        ::eligible-repositories   (eligible-category "Repositories")
        ::package-groups          (ui/slide-link "Package Groups")
        ::eligible-home           "//div[@id='content_tree']//span[contains(@class,'home_img_inactive')]"
        ::save                    "save_template"}) ;;when editing

;; Nav

(nav/add-subnavigation
 ::menu/content-tab
 [::page [] (sel/browser clickAndWait :system-templates)
  [::named-page [template-name] (sel/browser click (ui/slide-link template-name))]
  [::new-page [] (sel/browser click ::new)]])

;; Tasks

(def template-toggler (ui/toggler ui/add-remove action))

(defn create
  "Creates a system template with the given name and optional
  description."
  [{:keys [name description]}]
  (nav/go-to ::new-page)
  (sel/fill-ajax-form {::name-text name
                       ::description-text description}
                      ::save-new)
  (notification/check-for-success))

(defn add-to
  "Adds content to a given template.  Example:
   (add-toe 'mytemplate' [{:product 'prod3'
                           :packages ['rpm1' 'rpm2']}
                          {:product 'prod6'
                           :repositories ['x86_64']}]"
  [template content]
  (nav/go-to ::named-page {:template-name template})
  (let [add-item (fn [item] (ui/toggle template-toggler item true))]
    (doseq [group content]
      (let [category-keyword (-> group (dissoc :product) keys first)
            category-name (-> category-keyword
                             name
                             (.replace "-" " ")
                             capitalize-all)]
        (sel/->browser
         (getEval "window.onbeforeunload = function(){};") ;circumvent popup
         (sleep 2000)
         (click (product (:product group)))
         (sleep 2000)
         (click (eligible-category category-name)))
        (doall (map add-item (group category-keyword)))
        (sel/browser click ::eligible-home)))
    (sel/browser click ::save)
    (notification/check-for-success)))