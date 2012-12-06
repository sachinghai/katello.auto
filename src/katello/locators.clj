(ns katello.locators
  (:require [com.redhat.qe.auto.selenium.selenium :as sel]
            [clojure.xml :as xml]
            [clojure.zip :as zip]
            (katello [conf :refer [config]] 
                     [tasks :refer [capitalize-all]]) 
            [ui.navigate :as nav]
            [clojure.string :refer [capitalize ]])
  (:import [com.redhat.qe.auto.selenium Element]))

;;ui layer

(sel/template-fns
 { add-repository                  "//div[@id='products']//div[contains(.,'%s')]/..//div[normalize-space(.)='Add Repository' and contains(@class, 'button')]"
   button-div                      "//div[contains(@class,'button') and normalize-space(.)='%s']"
   changeset                       "//div[starts-with(@id,'changeset_') and normalize-space(.)='%s']"  
   editable                        "//div[contains(@class, 'editable') and descendant::text()[substring(normalize-space(),2)='%s']]"
   environment-link                "//div[contains(@class,'jbreadcrumb')]//a[normalize-space(.)='%s']"
   left-pane-field-list            "xpath=(//div[contains(@class,'left')]//div[contains(@class,'ellipsis') or @class='block tall'])[%s]"
   link                            "link=%s"
   product-schedule                "//div[normalize-space(.)='%s']/following-sibling::div[1]"
   provider-sync-checkbox          "//table[@id='products_table']//label[normalize-space(.)='%s']/..//input"
   provider-sync-checkbox2         "//table[@id='products_table']//tr[contains(.,'%s')]/following::label[normalize-space(.)='%s']/..//input"
   provider-sync-progress          "//tr[td/label[normalize-space(.)='%s']]/td[5]"
   repo-enable-checkbox            "//table[@id='products_table']//label[normalize-space(.)='%s']/..//input" 
   schedule                        "//div[normalize-space(.)='%s']"
   search-favorite                 "//span[contains(@class,'favorite') and @title='%s']"
   slide-link                      "//li[contains(@class,'slide_link') and normalize-space(.)='%s']"
   fetch-environments-in-org       "xpath=(//div[@id='path-selected']//a/div)[%s]"
   subscription-checkbox           "//a[.='%s']/../span/input[@type='checkbox']"
   tab                             "link=%s"
   template-action                 "//a[@data-name='%2$s' and .='%s']"
   template-eligible-category      "//div[@id='content_tree']//div[normalize-space()='%s']"
   template-product                "//span[contains(@class, 'custom-product-sprite')]/following-sibling::span/text()[contains(.,'%s')]"
   textbox                         "xpath=//*[self::input[(@type='text' or @type='password' or @type='file') and @name='%s'] or self::textarea[@name='%<s']]"
   user                            "//div[@id='list']//div[contains(@class,'column_1') and normalize-space(.)='%s']"
   })

(defn- tabs
  "Takes a list of keywords, and creates mapping eg: {:my-tab 'link=My Tab'}"
  [kws]
  (->> kws
     (map (comp tab
                capitalize-all
                #(.replace % "-" " ")
                name))
     (zipmap kws)))

;;
;;UI locators - mapping of names to selenium locator strings.
;;

(def common
  {:spinner                 "//img[contains(@src,'spinner.gif')]"
   :save-inplace-edit       "//button[.='Save']"
   :save-inplace-edit-inputbutton       "//input[@value='Save']"
   :confirmation-dialog     "//div[contains(@class, 'confirmation')]"
   :confirmation-yes        "//div[contains(@class, 'confirmation')]//span[.='Yes']"
   :confirmation-no         "//div[contains(@class, 'confirmation')]//span[.='No']"
   :search-bar              "search"
   :search-menu             "//form[@id='search_form']//span[@class='arrow']"
   :search-save-as-favorite "search_favorite_save"
   :search-clear-the-search "search_clear"
   :search-submit           "//button[@form='search_form']"
   ;;main banner
   :account             "//a[@class='header-widget' and contains(@href,'users')]"
   :log-out             "//a[normalize-space(.)='Log Out']"
   :org-switcher        "switcherButton"
   :active-org          "//*[@id='switcherButton']"
   :default-org         "//div[@id='orgbox']//input[@checked='checked' and @class='default_org']/../"
   ;;inside the org switcher
   :manage-organizations-link  "manage_orgs"
   })

(def all-tabs
  (tabs
   (flatten
    '[:administer
      [:users
       :roles
       :manage-organizations]
      :dashboard
      :content
      [:subscriptions
       [:red-hat-subscriptions
        :activation-keys
        :import-history]
       :repositories
       [:custom-content-repositories
        :red-hat-repositories
        :package-filters
        ;; GPG Keys is defined below, because it's all caps
        ]
       :sync-management
       [:sync-status
        :sync-plans
        :sync-schedule]
       :content-search
       :system-templates
       :changeset-management
       [:changesets
        :changeset-history]]
      :systems
      [:all
       :by-environments
       :system-groups]
      

      ;;3rd level subtabs
      :create
      :details
      :registered
      :groups
      :general
      :facts
      :packages])))
   
;;merge all the preceeding maps together, plus a few more items.
(defonce ^{:doc "All the selenium locators for the Katello UI. Maps a
  keyword to the selenium locator. You can pass the keyword to
  selenium just the same as you would the locator string. See also
  SeleniumLocatable protocol."}
  uimap
  (atom (merge all-tabs common
               { ;; login page
                :username-text     "username"
                :password-text     "password"
                :log-in            "//input[@value='Log In' or @value='Login']"

              
                ;;tabs with special chars in name
                :sub-organizations (tab "Sub-Organizations")
                   

                ;;Sync Management subtab
                :synchronize-now   "sync_button"})))

;;Tells the clojure selenium client where to look up keywords to get
;;real selenium locators (in uimap in this namespace).
(extend-protocol sel/SeleniumLocatable
  clojure.lang.Keyword
  (sel/sel-locator [k] (@uimap k))
  String
  (sel/sel-locator [x] x))

(defn promotion-env-breadcrumb
  "Locates a link in the environment breadcrumb UI widget. If there
  are multiple environment paths, and you wish to select Library,
  'next' is required."
  [name & [next]]
  (let [prefix "//a[normalize-space(.)='%s' and contains(@class, 'path_link')"]
    (format 
     (str prefix (if next " and ../../..//a[normalize-space(.)='%s']" "") "]")
     name next)))

(defn inactive-edit-field
  "Takes a locator for an active in-place edit field, returns the
  inactive version"
  [loc]
  (format "//div[@name='%1s']" (sel/sel-locator loc)))

(defn left-pane-item
  "Returns a selenium locator for an item in a left
   pane list (by the name of the item)"
  [name]
  ((sel/template "//div[@id='list']//div[starts-with(normalize-space(.),'%s')]")
   (let [l (.length name)]
     (if (> l 32)
       (.substring name 0 32) ;workaround for bz 737678
       name))))


(defn content-search-expand-strategy
  "Returns a locator strategy function for the expansion of the
  current row. The function returned will get any cell by index
  number."
  [current-loc n]
  (sel/template (format "%s/../ul[%s]/li[$1]" current-loc n)))

;;nav tricks
(defn select-environment-widget [env-name & [{:keys [next-env-name wait]}]]
  (do (when (sel/browser isElementPresent :expand-path)
        (sel/browser click :expand-path))
      (sel/browser click (promotion-env-breadcrumb env-name next-env-name))
      (when wait (sel/browser waitForPageToLoad))))

(defn search [search-term]
  (sel/fill-form {:search-bar search-term}
             :search-submit (constantly nil)))

(defn choose-left-pane
  "Selects an item in the left pane. If the item is not found, a
   search is performed and the select is attempted again. Takes an
   optional post-fn to perform afterwards."
  [templ item]
  (let [loc (templ item)]
    (try (sel/browser click loc)
         (catch com.thoughtworks.selenium.SeleniumException se
           (do (search item)
               (sel/browser click loc))))))

(defn toggler
  "Returns a function that returns a locator for the given on/off text
   and locator strategy. Used for clicking things like +Add/Remove for
   items in changesets or permission lists."
  [[on-text off-text] loc-strategy]
  (fn [associated-text on?]
    (loc-strategy (if on? on-text off-text) associated-text)))

(def add-remove ["+ Add" "Remove"])


(def template-toggler (toggler add-remove template-action))


(defn toggle "Toggles the item from on to off or vice versa."
  [a-toggler associated-text on?]
  (sel/browser click (a-toggler associated-text on?)))

;;
;;Navigation tree - shows all the navigation paths through the ui.
;;this data is used by the katello.tasks/navigate function to get to
;;the given page.
(def
  ^{:doc "The navigation layout of the UI. Each item in the tree is
  a new page or tab, that you can drill down into from its parent
  item. Each item contains a keyword to refer to the location in the
  UI, a list of any arguments needed to navigate there (for example,
  to navigate to a provider details page, you need the name of the
  provider). Finally some code to navigate to the location from its
  parent location. See also katello.tasks/navigate."}
  page-tree
  (atom
   (nav/nav-tree
    [:top-level [] (if (or (not (sel/browser isElementPresent :log-out))
                           (sel/browser isElementPresent :confirmation-dialog))
                     (sel/browser open (@config :server-url)))
   
     [:content-tab [] (sel/browser mouseOver :content)
      [:subscriptions-tab [] (sel/browser mouseOver :subscriptions)
       [:redhat-subscriptions-page [] (sel/browser clickAndWait :red-hat-subscriptions)]
       [:activation-keys-page [] (sel/browser clickAndWait :activation-keys)
        [:named-activation-key-page [activation-key-name]
         (choose-left-pane left-pane-item activation-key-name)]
        [:new-activation-key-page [] (sel/browser click :new-activation-key)]]]
      [:repositories-tab [] (sel/browser mouseOver :repositories)
       [:custom-content-repositories-page [] (sel/browser clickAndWait :custom-content-repositories)
        [:new-provider-page [] (sel/browser click :new-provider)]
        [:named-provider-page [provider-name] (choose-left-pane left-pane-item provider-name)
         [:provider-products-repos-page [] (sel/->browser (click :products-and-repositories)
                                                          (sleep 2000))
          [:named-product-page [product-name] (sel/browser click (editable product-name))]
          [:named-repo-page [product-name repo-name] (sel/browser click (editable repo-name))]]
         [:provider-details-page [] (sel/browser click :details)]
         [:provider-subscriptions-page [] (sel/browser click :subscriptions)]]]
       [:redhat-repositories-page [] (sel/browser clickAndWait :red-hat-repositories)]
       [:gpg-keys-page [] (sel/browser clickAndWait :gpg-keys)
        [:new-gpg-key-page [] (sel/browser click :new-gpg-key)]
        [:named-gpgkey-page [gpg-key-name] (choose-left-pane left-pane-item gpg-key-name)]]
       [:package-filters-page [] (sel/browser clickAndWait :package-filters)
        [:new-package-filter-page [] (sel/browser click :create-new-package-filter)]
        [:named-package-filter-page [package-filter-name] (choose-left-pane left-pane-item package-filter-name)]]]
      [:sync-management-page [] (sel/browser mouseOver :sync-management)
       [:sync-status-page [] (sel/browser clickAndWait :sync-status)]
       [:sync-plans-page [] (sel/browser clickAndWait :sync-plans)
        [:named-sync-plan-page [sync-plan-name]
         (choose-left-pane left-pane-item sync-plan-name)]
        [:new-sync-plan-page [] (sel/browser click :new-sync-plan)]]
       [:sync-schedule-page [] (sel/browser clickAndWait :sync-schedule)]]
      [:changeset-promotion-history-page [] (sel/browser clickAndWait :changeset-history)]
      [:changeset-promotions-tab [] (sel/browser mouseOver :changeset-management)
       [:changesets-page [] (sel/browser clickAndWait :changesets)
        [:named-environment-changesets-page [env-name next-env-name]
         (select-environment-widget env-name {:next-env-name next-env-name :wait true})
         [:named-changeset-page [changeset-name changeset-type]
          (do
            (if (= changeset-type "deletion") (sel/browser click :select-deletion-changeset))
            (sel/browser click (changeset changeset-name)))]]]]
      [:content-search-page [] (sel/browser clickAndWait :content-search)]
      [:system-templates-page [] (sel/browser clickAndWait :system-templates)
       [:named-system-template-page [template-name] (sel/browser click (slide-link template-name))]
       [:new-system-template-page [] (sel/browser click :new-template)]]]
     
     [:organizations-page-via-org-switcher [] (sel/browser click :org-switcher)
      [:organizations-link-via-org-switcher [] (sel/browser clickAndWait :manage-organizations-link)
       [:new-organization-page-via-org-switcher [] (sel/browser click :new-organization)]]]
     [:administer-tab [] (sel/browser mouseOver :administer)
      [:users-page [] (sel/browser clickAndWait :users)
       [:named-user-page [username] (choose-left-pane user username)
        [:user-environments-page [] (sel/browser click :environments-subsubtab)]
        [:user-roles-permissions-page [] (sel/browser click :roles-subsubtab)]]]
      [:roles-page [] (sel/browser clickAndWait :roles)
       [:named-role-page [role-name] (choose-left-pane left-pane-item role-name)
        [:named-role-users-page [] (sel/browser click :role-users)]
        [:named-role-permissions-page [] (sel/browser click :role-permissions)]]]
      [:manage-organizations-page [] (sel/browser clickAndWait :manage-organizations)
       [:new-organization-page [] (sel/browser click :new-organization)]
       [:named-organization-page [org-name] (choose-left-pane left-pane-item org-name) 
        [:new-environment-page [] (sel/browser click :new-environment)]
        [:named-environment-page [env-name] (sel/browser click (environment-link env-name))]]]]])))


(def tab-list '(:roles-page
                :users-page 
                :systems-all-page
                :activation-keys-page
                :systems-by-environment-page))

(def ^{:doc "Tabs that don't exist in headpin"}
  katello-only-tabs
  '(:redhat-repositories-page))

