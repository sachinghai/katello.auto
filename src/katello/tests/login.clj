(ns katello.tests.login
  (:refer-clojure :exclude [fn])
  (:use [serializable.fn :only [fn]]
        [katello.conf :only [config *session-user* *session-password*]]
        [slingshot.slingshot]
        katello.tasks))

(def invalid-credential-rejected
  (fn [user pw]
    (try+
     (logout)
     (login user pw)
     (when (-> (notification) :type (= :success))
       (throw (RuntimeException. "Login succeeded with bad credentials.")))
     (catch [:type :katello.tasks/invalid-credentials] _)
     (finally
      (login *session-user* *session-password*)))))
