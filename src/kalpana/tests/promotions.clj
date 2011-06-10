(ns kalpana.tests.promotions
  (:require [kalpana.tasks :as tasks]
            [kalpana.api-tasks :as api]
            [clojure.contrib.set :as sets]
            [clojure.contrib.logging :as log])
  (:import [org.testng.annotations Test BeforeClass])
  (:use [kalpana.conf :only [config]]
        [kalpana.tests.setup :only [beforeclass-ensure-admin]]
        [test-clj.testng :only [gen-class-testng data-driven]]
        [com.redhat.qe.verify :only [verify]]))

(def provider-name (atom nil))
(def root-next-env (atom "Q-eh"))
(def locker "locker")
(def root "Development")
(def myorg (atom nil))

(beforeclass-ensure-admin)

(defn get-root-next-env
  "Gets the environment whose 'prior' is the root environment.  If
there is none, one will be created and its name returned."
  [org]
  (let [rootid (api/get-id-by-name :environment root org)
        matches (filter #(= (:prior %) rootid)
                        (api/all-entities :environment org))]
    (cond
     (second matches) (throw (IllegalStateException.
                              "Multiple envs have root as their prior! See bz 692592."))
     (first matches) (-> matches first :name)
     :else (let [new-env-name (tasks/timestamp "promote-test-env")]
             (api/create-environment new-env-name org
                                     (@config :admin-user)
                                     (@config :admin-password)
                                     :description "for testing content promotion"
                                     :prior-env root)
             new-env-name))))

(defn ^{BeforeClass {:groups ["promotions"]}} setup [_]
  (reset! myorg (@config :admin-org))
  (reset! provider-name (tasks/timestamp "promo-"))
  
  (api/create-provider @myorg (@config :admin-user) (@config :admin-password)
                               :name @provider-name
                               :description "test provider for promotions"
                               :type "Custom")

  (let [all-envs (map :name (api/all-entities :environment @myorg))
        ensure-env-exist (fn [env-name]
                           (tasks/ensure-by
                            (some #{env-name} all-envs)
                            (api/create-environment env-name @myorg
                                                    (@config :admin-user)
                                                    (@config :admin-password))))]
    (ensure-env-exist root)
    (ensure-env-exist @root-next-env)))

(defn verify-all-content-present [from in]
  (doseq [content-type (keys from)]
    (let [promoted (content-type from)
          current (content-type in)]
      (verify (sets/superset? current promoted)))))

(defn verify_promote_content [org envs content]
  (doseq [product-name (content :products)]
    (api/create-product product-name @provider-name :description "test product")
    (api/create-repo "mytestrepo" @myorg product-name "http://blah.com"))
  (doseq [[from-env target-env] (partition 2 1 envs)]
    (tasks/promote-content from-env content)
    (verify-all-content-present content (tasks/environment-content target-env))))

(data-driven verify_promote_content {org.testng.annotations.Test
                                     {:groups ["promotions"
                                               "blockedByBug-711144"
                                               "blockedByBug-712318"] :description
                                      "Takes content and promotes it thru more environments.
                                       VerIfies that it shows up in the new env."}}
             [[@myorg [locker root] {:products (set (tasks/timestamp "MyProduct" 3))}]
              [@myorg [locker root @root-next-env] {:products (set (tasks/timestamp "ProductMulti" 3))}]])

(defn ^{Test {:description "After content has been promoted, the change set should be empty."
              :groups ["promotions"
                       "blockedByBug-699374"
                       "blockedByBug-711144"
                       "blockedByBug-712318"]}}
  verify_change_set_cleared [_]
  (verify_promote_content @myorg
                          [locker root]
                          {:products (set (tasks/timestamp "MyProduct" 3))})
  )
(gen-class-testng)




(comment "not needed - dates are not required for api"
         (def date-fmt (java.text.SimpleDateFormat. "yyyy-MM-dd'T'HH:mm:ss.SSSZZZZ"))

         (defn formatted-date
           ([d] (.format date-fmt d))
           ([] (formatted-date (java.util.Date.)))))
