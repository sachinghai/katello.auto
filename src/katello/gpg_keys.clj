(ns katello.gpg-keys
  (:require (katello [navigation :as nav]
                     [ui-common :as ui]
                     [notifications :as notification])
            [com.redhat.qe.auto.selenium.selenium :as sel]))

;; Locators

(swap! ui/uimap merge
       {::name-text        "gpg_key_name"
        ::file-upload-text "gpg_key_content_upload"
        ::upload-button    "upload_gpg_key"
        ::content-text     "gpg_key_content"
        ::link             "//a[.='GPG Keys']"
        ::save             "save_gpg_key"
        ::new              "new"
        ::remove           (ui/link "Remove GPG Key")})

;; Nav

(nav/add-subnavigation
 :repositories-tab
 [::page [] (sel/browser clickAndWait ::link)
  [::new-page [] (sel/browser click ::new)]
  [::named-page [gpg-key-name] (nav/choose-left-pane  gpg-key-name)]])


;;Tasks

(defn create [name & [{:keys [filename contents]}]]
  (assert (not (and filename contents))
          "Must specify one one of :filename or :contents.")
  (assert (string? name))
  (nav/go-to ::new-page)
  (if filename
    (sel/fill-ajax-form {::name-text name
                         ::file-upload-text filename}
                        ::upload-button)
    (sel/fill-ajax-form {::name-text name
                         ::content-text contents}
                        ::save))
  (notification/check-for-success))


(defn remove 
  "Deletes existing GPG keys"
  [gpg-key-name]
  (nav/go-to ::named-page {:gpg-key-name gpg-key-name})
  (sel/browser click ::remove )
  (sel/browser click ::ui/confirmation-yes)
  (notification/check-for-success))