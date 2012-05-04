{:namespaces
 ({:source-url nil,
   :wiki-url "katello.api-tasks-api.html",
   :name "katello.api-tasks",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.client-api.html",
   :name "katello.client",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.conf-api.html",
   :name "katello.conf",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.locators-api.html",
   :name "katello.locators",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.rest-api.html",
   :name "katello.rest",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.tasks-api.html",
   :name "katello.tasks",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.tests.e2e-api.html",
   :name "katello.tests.e2e",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.tests.environments-api.html",
   :name "katello.tests.environments",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.tests.login-api.html",
   :name "katello.tests.login",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.tests.navigation-api.html",
   :name "katello.tests.navigation",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.tests.organizations-api.html",
   :name "katello.tests.organizations",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.tests.permissions-api.html",
   :name "katello.tests.permissions",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.tests.promotions-api.html",
   :name "katello.tests.promotions",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.tests.providers-api.html",
   :name "katello.tests.providers",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.tests.setup-api.html",
   :name "katello.tests.setup",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.tests.suite-api.html",
   :name "katello.tests.suite",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.tests.sync_management-api.html",
   :name "katello.tests.sync_management",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.tests.systems-api.html",
   :name "katello.tests.systems",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.tests.templates-api.html",
   :name "katello.tests.templates",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.tests.users-api.html",
   :name "katello.tests.users",
   :doc nil}
  {:source-url nil,
   :wiki-url "katello.validation-api.html",
   :name "katello.validation",
   :doc nil}),
 :vars
 ({:arglists ([entity-type]),
   :name "all-entities",
   :namespace "katello.api-tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.api-tasks-api.html#katello.api-tasks/all-entities",
   :doc
   "Returns a list of all the entities of the given entity-type. If\nthat entity type is part of an org, or environment or product,\nthose vars must be bound (see with-* macros)",
   :var-type "function",
   :line 93,
   :file "src/katello/api_tasks.clj"}
  {:arglists ([m newmap]),
   :name "assoc-if-set",
   :namespace "katello.api-tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.api-tasks-api.html#katello.api-tasks/assoc-if-set",
   :doc
   "Adds to map m just the entries from newmap where the value is not nil.",
   :var-type "function",
   :line 55,
   :file "src/katello/api_tasks.clj"}
  {:arglists ([name {:keys [prior]}]),
   :name "ensure-env-exist",
   :namespace "katello.api-tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.api-tasks-api.html#katello.api-tasks/ensure-env-exist",
   :doc
   "If an environment with the given name and prior environment doesn't\nexist, create it.",
   :var-type "function",
   :line 152,
   :file "src/katello/api_tasks.clj"}
  {:arglists ([content]),
   :name "promote",
   :namespace "katello.api-tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.api-tasks-api.html#katello.api-tasks/promote",
   :doc
   "Does a promotion of the given content (creates a changeset, adds\nthe content, and promotes it. Content should match the JSON format\nthat the API expects. currently like {:product_id '1234567890'}",
   :var-type "function",
   :line 284,
   :file "src/katello/api_tasks.clj"}
  {:arglists ([changeset-name]),
   :name "promote-changeset",
   :namespace "katello.api-tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.api-tasks-api.html#katello.api-tasks/promote-changeset",
   :doc
   "Promotes a changeset, polls the API until the promotion completes,\nand returns the changeset. If the timeout is hit before the\npromotion completes, throws an exception.",
   :var-type "function",
   :line 269,
   :file "src/katello/api_tasks.clj"}
  {:arglists ([]),
   :name "random-facts",
   :namespace "katello.api-tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.api-tasks-api.html#katello.api-tasks/random-facts",
   :doc
   "Generate facts about a system - used to register fake systems via\nthe api. Some facts are randomized to guarantee uniqueness.",
   :var-type "function",
   :line 183,
   :file "src/katello/api_tasks.clj"}
  {:arglists ([entity-type]),
   :name "uri-for-entity-type",
   :namespace "katello.api-tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.api-tasks-api.html#katello.api-tasks/uri-for-entity-type",
   :doc
   "Returns the proper GET uri given the katello entity type (a\nkeyword, eg. :environment). May require some vars be bound, for\nexample, to get an environment from the API an org must be set. See\nwith-* macros in this namespace.",
   :var-type "function",
   :line 65,
   :file "src/katello/api_tasks.clj"}
  {:arglists ([& body]),
   :name "with-admin",
   :namespace "katello.api-tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.api-tasks-api.html#katello.api-tasks/with-admin",
   :doc
   "Executes body and makes any included katello api calls using the\nadmin user, password, and organization.",
   :var-type "macro",
   :line 46,
   :file "src/katello/api_tasks.clj"}
  {:arglists ([& body]),
   :name "with-admin-creds",
   :namespace "katello.api-tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.api-tasks-api.html#katello.api-tasks/with-admin-creds",
   :doc
   "Executes body and makes any included katello api calls using the\nadmin user and password (which defaults to admin/admin)",
   :var-type "macro",
   :line 23,
   :file "src/katello/api_tasks.clj"}
  {:arglists ([& body]),
   :name "with-admin-org",
   :namespace "katello.api-tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.api-tasks-api.html#katello.api-tasks/with-admin-org",
   :doc
   "Executes body and makes any included katello api calls using the\nadmin organization (defaults to ACME_Corporation).",
   :var-type "macro",
   :line 39,
   :file "src/katello/api_tasks.clj"}
  {:arglists ([user password & body]),
   :name "with-creds",
   :namespace "katello.api-tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.api-tasks-api.html#katello.api-tasks/with-creds",
   :doc
   "Execute body and makes any included katello api calls with the\ngiven user and password.",
   :var-type "macro",
   :line 14,
   :file "src/katello/api_tasks.clj"}
  {:arglists ([env-name & body]),
   :name "with-env",
   :namespace "katello.api-tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.api-tasks-api.html#katello.api-tasks/with-env",
   :doc
   "Executes body and makes any included katello api calls using the\ngiven environment name (it's id will be looked up before executing\nbody).",
   :var-type "macro",
   :line 120,
   :file "src/katello/api_tasks.clj"}
  {:arglists ([org & body]),
   :name "with-org",
   :namespace "katello.api-tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.api-tasks-api.html#katello.api-tasks/with-org",
   :doc
   "Executes body and makes any included katello api calls using the\ngiven organization.",
   :var-type "macro",
   :line 31,
   :file "src/katello/api_tasks.clj"}
  {:arglists ([cmd & [optmap]]),
   :name "sm-cmd",
   :namespace "katello.client",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.client-api.html#katello.client/sm-cmd",
   :doc "Runs a subscription manager command with the given options.",
   :var-type "function",
   :line 28,
   :file "src/katello/client.clj"}
  {:arglists ([]),
   :name "init",
   :namespace "katello.conf",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.conf-api.html#katello.conf/init",
   :doc
   "Read in properties and set some defaults. This function should be\ncalled before selenium client is created or any tests are run.",
   :var-type "function",
   :line 39,
   :file "src/katello/conf.clj"}
  {:arglists ([item & [post-fn]]),
   :name "choose-left-pane",
   :namespace "katello.locators",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.locators-api.html#katello.locators/choose-left-pane",
   :doc
   "Selects an item in the left pane. If the item is not found, a\nsearch is performed and the select is attempted again. Takes an\noptional post-fn to perform afterwards.",
   :var-type "function",
   :line 328,
   :file "src/katello/locators.clj"}
  {:arglists ([m]),
   :name "define-strategies",
   :namespace "katello.locators",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.locators-api.html#katello.locators/define-strategies",
   :doc
   "Expands into a function for each locator strategy in map m (which\nmaps symbol to LocatorStrategy). Each function will be named the\nsame as the symbol, take arguments and return a new element\nconstructed with the locator strategy and args.",
   :var-type "macro",
   :line 15,
   :file "src/katello/locators.clj"}
  {:arglists ([loc]),
   :name "inactive-edit-field",
   :namespace "katello.locators",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.locators-api.html#katello.locators/inactive-edit-field",
   :doc
   "Takes a locator for an active in-place edit field, returns the inactive version",
   :var-type "function",
   :line 299,
   :file "src/katello/locators.clj"}
  {:arglists ([a-toggler associated-text on?]),
   :name "toggle",
   :namespace "katello.locators",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.locators-api.html#katello.locators/toggle",
   :doc "Toggles the item from on to off or vice versa.",
   :var-type "function",
   :line 354,
   :file "src/katello/locators.clj"}
  {:arglists ([[on-text off-text] loc-strategy]),
   :name "toggler",
   :namespace "katello.locators",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.locators-api.html#katello.locators/toggler",
   :doc
   "Returns a function that returns a locator for the given on/off text\nand locator strategy. Used for clicking things like +Add/Remove for\nitems in changesets or permission lists.",
   :var-type "function",
   :line 339,
   :file "src/katello/locators.clj"}
  {:arglists ([link & [post-fn]]),
   :name "via",
   :namespace "katello.locators",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.locators-api.html#katello.locators/via",
   :doc
   "Performs a navigation step by clicking a locator and calling\noptional post-click function.",
   :var-type "function",
   :line 312,
   :file "src/katello/locators.clj"}
  {:arglists ([url & [req]]),
   :name "get",
   :namespace "katello.rest",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.rest-api.html#katello.rest/get",
   :doc
   "Gets the url, and decodes JSON in the response body, returning a\nclojure datastructure.",
   :var-type "function",
   :line 10,
   :file "src/katello/rest.clj"}
  {:arglists ([url user pw body & [req]]),
   :name "post",
   :namespace "katello.rest",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.rest-api.html#katello.rest/post",
   :doc
   "Encodes datastructure in body to JSON, posts to url, using user and pw. ",
   :var-type "function",
   :line 17,
   :file "src/katello/rest.clj"}
  {:arglists ([url user pw parts & [req]]),
   :name "post-multipart",
   :namespace "katello.rest",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.rest-api.html#katello.rest/post-multipart",
   :doc
   "Encodes datastructure in body to JSON, posts to url, using user and pw. ",
   :var-type "function",
   :line 26,
   :file "src/katello/rest.clj"}
  {:arglists ([url user pw body & [req]]),
   :name "put",
   :namespace "katello.rest",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.rest-api.html#katello.rest/put",
   :doc
   "Encodes datastructure in body to JSON, posts to url, using user and pw. ",
   :var-type "function",
   :line 36,
   :file "src/katello/rest.clj"}
  {:arglists ([loc]),
   :name "activate-in-place",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/activate-in-place",
   :doc
   "For an in-place edit input, switch it from read-only to editing\nmode. Takes the locator of the input in editing mode as an\nargument.",
   :var-type "function",
   :line 139,
   :file "src/katello/tasks.clj"}
  {:arglists ([{:keys [provider-name name description]}]),
   :name "add-product",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/add-product",
   :doc
   "Adds a product to a provider, with the given name and description.",
   :var-type "function",
   :line 374,
   :file "src/katello/tasks.clj"}
  {:arglists ([{:keys [provider-name product-name name url]}]),
   :name "add-repo",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/add-repo",
   :doc
   "Adds a repository under the given provider and product. Requires a\nname and url be given for the repo.",
   :var-type "function",
   :line 393,
   :file "src/katello/tasks.clj"}
  {:arglists ([changeset-name from-env to-env content]),
   :name "add-to-changeset",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/add-to-changeset",
   :doc
   "Adds the given content to an existing changeset. The originating\nand target environments need to be specified to find to locate the\nchangeset.",
   :var-type "function",
   :line 168,
   :file "src/katello/tasks.clj"}
  {:arglists ([name content]),
   :name "add-to-template",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/add-to-template",
   :doc
   "Adds content to a given template.  Example:\n(add-to-template 'mytemplate' [{:product 'prod3'\n                                :packages ['rpm1' 'rpm2']}\n                               {:product 'prod6'\n                                :repositories ['x86_64']}]",
   :var-type "function",
   :line 763,
   :file "src/katello/tasks.clj"}
  {:arglists ([{:keys [user roles]}]),
   :name "assign-role",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/assign-role",
   :doc
   "Assigns the given user to the given roles. Roles should be a list\nof roles to assign.",
   :var-type "function",
   :line 537,
   :file "src/katello/tasks.clj"}
  {:arglists ([& [timeout]]),
   :name "check-for-error",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/check-for-error",
   :doc
   "Waits for a notification up to the optional timeout (in ms), throws\nan exception if timeout is hit or error notification appears.",
   :var-type "function",
   :line 115,
   :file "src/katello/tasks.clj"}
  {:arglists ([& [max-wait-ms]]),
   :name "check-for-success",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/check-for-success",
   :doc
   "Gets any notification from the UI, if there is none, or it's not a\nsuccess notification, raise an exception. Otherwise return the type\nand text of the message. Takes an optional max amount of time to\nwait, in ms.",
   :var-type "function",
   :line 100,
   :file "src/katello/tasks.clj"}
  {:arglists
   ([{:keys [name description environment system-template], :as m}]),
   :name "create-activation-key",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tasks-api.html#katello.tasks/create-activation-key",
   :doc
   "Creates an activation key with the given properties. Description\nand system-template are optional.",
   :var-type "function",
   :line 713,
   :file "src/katello/tasks.clj"}
  {:arglists ([env-name next-env-name changeset-name]),
   :name "create-changeset",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/create-changeset",
   :doc
   "Creates a changeset for promotion from env-name to next-env name.",
   :var-type "function",
   :line 158,
   :file "src/katello/tasks.clj"}
  {:arglists ([name {:keys [org-name description prior-env]}]),
   :name "create-environment",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tasks-api.html#katello.tasks/create-environment",
   :doc
   "Creates an environment with the given name, and a map containing\nthe organization name to create the environment in, the prior\nenvironment, and an optional description.",
   :var-type "function",
   :line 311,
   :file "src/katello/tasks.clj"}
  {:arglists ([name & [{:keys [description]}]]),
   :name "create-organization",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tasks-api.html#katello.tasks/create-organization",
   :doc
   "Creates an organization with the given name and optional description.",
   :var-type "function",
   :line 293,
   :file "src/katello/tasks.clj"}
  {:arglists ([{:keys [name description]}]),
   :name "create-provider",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/create-provider",
   :doc
   "Creates a custom provider with the given name and description.",
   :var-type "function",
   :line 365,
   :file "src/katello/tasks.clj"}
  {:arglists ([name & [{:keys [description]}]]),
   :name "create-role",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/create-role",
   :doc "Creates a role with the given name and optional description.",
   :var-type "function",
   :line 527,
   :file "src/katello/tasks.clj"}
  {:arglists
   ([{:keys
      [name
       description
       interval
       start-date
       start-date-literal
       start-time-literal],
      :as m}]),
   :name "create-sync-plan",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/create-sync-plan",
   :doc
   "Creates a sync plan with the given properties. Either specify a\nstart-date (as a java.util.Date object) or a separate string for\nstart-date-literal 'MM/dd/yyyy', and start-time-literal 'hh:mm aa'\nThe latter can also be used to specify invalid dates for validation\ntests.",
   :var-type "function",
   :line 659,
   :file "src/katello/tasks.clj"}
  {:arglists ([{:keys [name description]}]),
   :name "create-template",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/create-template",
   :doc
   "Creates a system template with the given name and optional\ndescription.",
   :var-type "function",
   :line 753,
   :file "src/katello/tasks.clj"}
  {:arglists
   ([username
     {:keys
      [password password-confirm email default-org default-env]}]),
   :name "create-user",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/create-user",
   :doc "Creates a user with the given name and properties.",
   :var-type "function",
   :line 472,
   :file "src/katello/tasks.clj"}
  {:arglists ([product-names]),
   :name "current-sync-plan",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/current-sync-plan",
   :doc
   "Returns a map of what sync plan a product is currently scheduled\nfor. nil if UI says 'None'",
   :var-type "function",
   :line 703,
   :file "src/katello/tasks.clj"}
  {:arglists ([]),
   :name "current-user",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/current-user",
   :doc
   "Returns the name of the currently logged in user, or nil if logged out.",
   :var-type "function",
   :line 459,
   :file "src/katello/tasks.clj"}
  {:arglists ([name]),
   :name "delete-activation-key",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tasks-api.html#katello.tasks/delete-activation-key",
   :doc "Deletes the given activation key.",
   :var-type "function",
   :line 725,
   :file "src/katello/tasks.clj"}
  {:arglists ([env-name {:keys [org-name]}]),
   :name "delete-environment",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tasks-api.html#katello.tasks/delete-environment",
   :doc "Deletes an environment from the given organization.",
   :var-type "function",
   :line 323,
   :file "src/katello/tasks.clj"}
  {:arglists ([org-name]),
   :name "delete-organization",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tasks-api.html#katello.tasks/delete-organization",
   :doc "Deletes the named organization.",
   :var-type "function",
   :line 302,
   :file "src/katello/tasks.clj"}
  {:arglists ([{:keys [name provider-name]}]),
   :name "delete-product",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/delete-product",
   :doc "Deletes a product from the given provider.",
   :var-type "function",
   :line 384,
   :file "src/katello/tasks.clj"}
  {:arglists ([name]),
   :name "delete-provider",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/delete-provider",
   :doc "Deletes the named custom provider.",
   :var-type "function",
   :line 414,
   :file "src/katello/tasks.clj"}
  {:arglists ([{:keys [name provider-name product-name]}]),
   :name "delete-repo",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/delete-repo",
   :doc "Deletes a repository from the given provider and product.",
   :var-type "function",
   :line 404,
   :file "src/katello/tasks.clj"}
  {:arglists ([username]),
   :name "delete-user",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/delete-user",
   :doc "Deletes the given user.",
   :var-type "function",
   :line 487,
   :file "src/katello/tasks.clj"}
  {:arglists
   ([env-name {:keys [org-name new-name description prior]}]),
   :name "edit-environment",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/edit-environment",
   :doc
   "Edits an environment with the given name. Also takes a map\ncontaining the name of the environment's organization, and optional\nfields: a new name, a new description, and a new prior\nenvironment.",
   :var-type "function",
   :line 342,
   :file "src/katello/tasks.clj"}
  {:arglists ([org-name & {:keys [description]}]),
   :name "edit-organization",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/edit-organization",
   :doc
   "Edits an organization. Currently the only property of an org that\ncan be edited is the org's description.",
   :var-type "function",
   :line 334,
   :file "src/katello/tasks.clj"}
  {:arglists ([{:keys [name new-name description]}]),
   :name "edit-provider",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/edit-provider",
   :doc
   "Edits the named custom provider. Takes an optional new name, and\nnew description.",
   :var-type "function",
   :line 422,
   :file "src/katello/tasks.clj"}
  {:arglists
   ([name {:keys [add-permissions remove-permissions users]}]),
   :name "edit-role",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/edit-role",
   :doc
   "Edits a role to add new permissions, remove existing permissions,\nand assign users to the role. Example:\n\n(edit-role 'myrole'\n           {:add-permissions [{:resource-type 'Organizations'\n                               :verbs ['Read Organization']\n                               :name 'newPerm1'}]\n            :remove-permissions ['existingPerm1' 'existingPerm2']\n            :users ['joe' 'bob']})",
   :var-type "function",
   :line 547,
   :file "src/katello/tasks.clj"}
  {:arglists
   ([name
     {:keys
      [new-name
       description
       interval
       start-date
       start-date-literal
       start-time-literal],
      :as m}]),
   :name "edit-sync-plan",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/edit-sync-plan",
   :doc
   "Edits the given sync plan with optional new properties. See also\ncreate-sync-plan for more details.",
   :var-type "function",
   :line 677,
   :file "src/katello/tasks.clj"}
  {:arglists ([name & {:keys [new-name description location]}]),
   :name "edit-system",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/edit-system",
   :doc
   "Edits the properties of the given system. Optionally specify a new\nname, a new description, and a new location.",
   :var-type "function",
   :line 631,
   :file "src/katello/tasks.clj"}
  {:arglists
   ([username
     {:keys
      [inline-help
       clear-disabled-helptips
       new-password
       new-password-confirm
       new-email]}]),
   :name "edit-user",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/edit-user",
   :doc
   "Edits the given user, changing any of the given properties (can\nchange more than one at once).",
   :var-type "function",
   :line 494,
   :file "src/katello/tasks.clj"}
  {:arglists ([repos]),
   :name "enable-redhat-repositories",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tasks-api.html#katello.tasks/enable-redhat-repositories",
   :doc "Enable the given list of repos in the current org.",
   :var-type "function",
   :line 791,
   :file "src/katello/tasks.clj"}
  {:arglists ([username password]),
   :name "ensure-current-user",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tasks-api.html#katello.tasks/ensure-current-user",
   :doc
   "If username is already logged in, does nothing. Otherwise logs in\nwith given username and password.",
   :var-type "function",
   :line 465,
   :file "src/katello/tasks.clj"}
  {:arglists ([env-name]),
   :name "environment-content",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tasks-api.html#katello.tasks/environment-content",
   :doc
   "Returns the content that is available to promote, in the given environment.",
   :var-type "function",
   :line 262,
   :file "src/katello/tasks.clj"}
  {:arglists ([env content]),
   :name "environment-has-content?",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tasks-api.html#katello.tasks/environment-has-content?",
   :doc
   "If all the content is present in the given environment, returns true.",
   :var-type "function",
   :line 279,
   :file "src/katello/tasks.clj"}
  {:arglists ([org-name env-name]),
   :name "environment-other-possible-priors",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tasks-api.html#katello.tasks/environment-other-possible-priors",
   :doc
   "Returns a set of priors that are selectable for the given\nenvironment (will not include the currently selected prior).",
   :var-type "function",
   :line 356,
   :file "src/katello/tasks.clj"}
  {:arglists ([selector & forms]),
   :name "expecting-error",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/expecting-error",
   :doc
   "Execute forms, if error is caught matching selector, nil is\nreturned, otherwise object to-throw is thrown.",
   :var-type "macro",
   :line 24,
   :file "src/katello/tasks.clj"}
  {:arglists ([items submit]),
   :name "fill-ajax-form",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/fill-ajax-form",
   :doc
   "Fills in a web form and clicks the submit button. Only waits for\najax calls to complete. Items should be a map, where the keys are\nlocators for form elements, and values are the values to fill in.\nSubmit should be a locator for the form submit button.",
   :var-type "function",
   :line 131,
   :file "src/katello/tasks.clj"}
  {:arglists ([items]),
   :name "in-place-edit",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/in-place-edit",
   :doc
   "Fill out a form that uses in-place editing.  Takes a map of\nlocators to values.  The locators given should be for the\nediting-mode version of the input, it will be activated from its\nread-only state automatically.",
   :var-type "function",
   :line 146,
   :file "src/katello/tasks.clj"}
  {:arglists ([]),
   :name "logged-in?",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/logged-in?",
   :doc
   "Returns true if the browser is currently showing a page where a\nuser is logged in.",
   :var-type "function",
   :line 430,
   :file "src/katello/tasks.clj"}
  {:arglists ([]),
   :name "logged-out?",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/logged-out?",
   :doc "Returns true if the login page is displayed.",
   :var-type "function",
   :line 436,
   :file "src/katello/tasks.clj"}
  {:arglists ([username password]),
   :name "login",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/login",
   :doc
   "Logs in a user to the UI with the given username and password. If\nany user is currently logged in, he will be logged out first.",
   :var-type "function",
   :line 447,
   :file "src/katello/tasks.clj"}
  {:arglists ([]),
   :name "logout",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/logout",
   :doc "Logs out the current user from the UI.",
   :var-type "function",
   :line 441,
   :file "src/katello/tasks.clj"}
  {:arglists ([]),
   :name "manifest-already-uploaded?",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tasks-api.html#katello.tasks/manifest-already-uploaded?",
   :doc
   "Returns true if the current organization already has Red Hat\ncontent uploaded.",
   :var-type "function",
   :line 746,
   :file "src/katello/tasks.clj"}
  {:arglists ([message]),
   :name "matching-error",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/matching-error",
   :doc
   "Returns a keyword of known error, if the message matches any of\nthem.  If no matches, returns :katello-error.",
   :var-type "function",
   :line 62,
   :file "src/katello/tasks.clj"}
  {:arglists ([& [max-wait-ms]]),
   :name "notification",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/notification",
   :doc
   "Gets the notification from the page, returns a map object\nrepresenting the notification (or nil if no notification is present\nwithin the optional timeout period). Default timeout is 15\nseconds.",
   :var-type "function",
   :line 83,
   :file "src/katello/tasks.clj"}
  {:arglists ([changeset-name {:keys [from-env to-env timeout-ms]}]),
   :name "promote-changeset",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/promote-changeset",
   :doc
   "Promotes the given changeset to its target environment. An optional\ntimeout-ms key will specify how long to wait for the promotion to\ncomplete successfully.",
   :var-type "function",
   :line 190,
   :file "src/katello/tasks.clj"}
  {:arglists ([from-env to-env content]),
   :name "promote-content",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/promote-content",
   :doc
   "Promotes the given content from one environment to another. Example\ncontent:\n   {:products ['Product1' 'Product2']} ",
   :var-type "function",
   :line 224,
   :file "src/katello/tasks.clj"}
  {:arglists ([name]),
   :name "remove-role",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/remove-role",
   :doc "Deletes the given role.",
   :var-type "function",
   :line 593,
   :file "src/katello/tasks.clj"}
  {:arglists ([entity-type & [{:keys [criteria scope]}]]),
   :name "search",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/search",
   :doc
   "Search for criteria in entity-type, scope not yet implemented.\ncheck for error with a 2s timeout.  In this case error is a \nerror jnotify object.",
   :var-type "function",
   :line 516,
   :file "src/katello/tasks.clj"}
  {:arglists ([{:keys [system-name products]}]),
   :name "subscribe-system",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/subscribe-system",
   :doc
   "Subscribes the given system to the products. (products should be a list).",
   :var-type "function",
   :line 641,
   :file "src/katello/tasks.clj"}
  {:arglists ([notif]),
   :name "success?",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/success?",
   :doc
   "Returns true if the given notification is a 'success' type\nnotification (aka green notification in the UI).",
   :var-type "function",
   :line 77,
   :file "src/katello/tasks.clj"}
  {:arglists ([org-name]),
   :name "switch-org",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/switch-org",
   :doc "Switch to the given organization in the UI.",
   :var-type "function",
   :line 786,
   :file "src/katello/tasks.clj"}
  {:arglists ([product]),
   :name "sync-complete-status",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tasks-api.html#katello.tasks/sync-complete-status",
   :doc
   "Returns final status if complete.  If sync is still in progress or queued, returns nil.",
   :var-type "function",
   :line 604,
   :file "src/katello/tasks.clj"}
  {:arglists ([repos & [{:keys [timeout]}]]),
   :name "sync-repos",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/sync-repos",
   :doc
   "Syncs the given list of repositories. Also takes an optional\ntimeout (in ms) of how long to wait for the sync to complete before\nthrowing an error.  Default timeout is 2 minutes.",
   :var-type "function",
   :line 615,
   :file "src/katello/tasks.clj"}
  {:arglists ([{:keys [products plan-name]}]),
   :name "sync-schedule",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/sync-schedule",
   :doc
   "Schedules the given list of products to be synced using the given\nsync plan name.",
   :var-type "function",
   :line 692,
   :file "src/katello/tasks.clj"}
  {:arglists ([res]),
   :name "sync-success?",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/sync-success?",
   :doc "Returns true if given sync result is a success.",
   :var-type "function",
   :line 610,
   :file "src/katello/tasks.clj"}
  {:arglists ([]),
   :name "timestamps",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/timestamps",
   :doc
   "Infinite lazy sequence of timestamps in ms, starting with the current time.",
   :var-type "function",
   :line 33,
   :file "src/katello/tasks.clj"}
  {:arglists ([s]),
   :name "unique-names",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/unique-names",
   :doc
   "Infinite lazy sequence of timestamped strings, uses s as the base string.",
   :var-type "function",
   :line 38,
   :file "src/katello/tasks.clj"}
  {:arglists ([s]),
   :name "uniqueify",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/uniqueify",
   :doc "Get one unique name using s as the base string.",
   :var-type "function",
   :line 43,
   :file "src/katello/tasks.clj"}
  {:arglists ([file-path & [{:keys [repository-url]}]]),
   :name "upload-subscription-manifest",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tasks-api.html#katello.tasks/upload-subscription-manifest",
   :doc
   "Uploads a subscription manifest from the filesystem local to the\nselenium browser. Optionally specify a new repository url for Red\nHat content- if not specified, the default url is kept.",
   :var-type "function",
   :line 733,
   :file "src/katello/tasks.clj"}
  {:arglists ([task-fn]),
   :name "verify-success",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/verify-success",
   :doc
   "Calls task-fn and checks for a success message afterwards. If none\nis found, or an error notification appears, throws an exception.",
   :var-type "function",
   :line 122,
   :file "src/katello/tasks.clj"}
  {:arglists ([bindings & forms]),
   :name "with-unique",
   :namespace "katello.tasks",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url "/katello.tasks-api.html#katello.tasks/with-unique",
   :doc
   "Binds variables to unique strings. Example:\n(with-unique [x 'foo' y 'bar'] [x y]) will give something like:\n  ['foo-12346748964356' 'bar-12346748964357']",
   :var-type "macro",
   :line 47,
   :file "src/katello/tasks.clj"}
  {:arglists ([org-name target-env products packages-to-install]),
   :name "test-client-access",
   :namespace "katello.tests.e2e",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tests.e2e-api.html#katello.tests.e2e/test-client-access",
   :doc
   "content like [ {:name 'myprod' :poolName 'myprod 24/7' :repos ['myrepoa' 'myrepob']} ]",
   :var-type "function",
   :line 13,
   :file "src/katello/tests/e2e.clj"}
  {:arglists ([username password]),
   :name "verify-invalid-login-rejected",
   :namespace "katello.tests.login",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tests.login-api.html#katello.tests.login/verify-invalid-login-rejected",
   :doc
   "Try to login with the given credentials, verify that a proper error\nmessage appears in the UI.",
   :var-type "function",
   :line 11,
   :file "src/katello/tests/login.clj"}
  {:arglists ([tab]),
   :name "verify-navigation",
   :namespace "katello.tests.navigation",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tests.navigation-api.html#katello.tests.navigation/verify-navigation",
   :doc "Navigates to a tab",
   :var-type "function",
   :line 8,
   :file "src/katello/tests/navigation.clj"}
  {:arglists
   ([{:keys [permissions allowed-actions disallowed-actions setup]}]),
   :name "verify-access",
   :namespace "katello.tests.permissions",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tests.permissions-api.html#katello.tests.permissions/verify-access",
   :doc
   "First tries all actions with a user with no permissions, to make sure they all fail.  Then gives a new user the permissions, and retries the actions to ensure they all succeed, finally tries out-of-bounds actions to make sure they still fail.",
   :var-type "function",
   :line 59,
   :file "src/katello/tests/permissions.clj"}
  {:arglists ([envs f]),
   :name "chain-envs",
   :namespace "katello.tests.promotions",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tests.promotions-api.html#katello.tests.promotions/chain-envs",
   :doc
   "Given a list of environments, and a function of two neighboring\nenvironments in the chain, invoke f on each successive pair (eg:\nenvs ['a' 'b' 'c'] -> (f 'a' 'b'), (f 'b' 'c')",
   :var-type "function",
   :line 16,
   :file "src/katello/tests/promotions.clj"}
  {:arglists ([f]),
   :name "with-two-orgs",
   :namespace "katello.tests.providers",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tests.providers-api.html#katello.tests.providers/with-two-orgs",
   :doc
   "Create two orgs with unique names, and call f with a unique entity\nname, and the org names. Used for verifying (for instance) that\nenvs or providers with the same name can be created in 2 different\norgs.  Switches back to admin org after f is called.",
   :var-type "function",
   :line 18,
   :file "src/katello/tests/providers.clj"}
  {:arglists ([f]),
   :name "with-two-providers",
   :namespace "katello.tests.providers",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tests.providers-api.html#katello.tests.providers/with-two-providers",
   :doc
   "Create two providers with unique names, and call f with a unique\nentity name, and the provider names. Used for verifying (for\ninstance) that products with the same name can be created in 2\ndifferent providers.",
   :var-type "function",
   :line 33,
   :file "src/katello/tests/providers.clj"}
  {:arglists ([browser-string & [single-thread]]),
   :name "new-selenium",
   :namespace "katello.tests.setup",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tests.setup-api.html#katello.tests.setup/new-selenium",
   :doc
   "Returns a new selenium client. If running in a REPL or other\nsingle-session environment, set single-thread to true.",
   :var-type "function",
   :line 14,
   :file "src/katello/tests/setup.clj"}
  {:arglists ([user pw]),
   :name "switch-new-admin-user",
   :namespace "katello.tests.setup",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tests.setup-api.html#katello.tests.setup/switch-new-admin-user",
   :doc
   "Creates a new user with a unique name, assigns him admin\npermissions and logs in as that user.",
   :var-type "function",
   :line 27,
   :file "src/katello/tests/setup.clj"}
  {:arglists ([consume-fn]),
   :name "thread-runner",
   :namespace "katello.tests.setup",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.tests.setup-api.html#katello.tests.setup/thread-runner",
   :doc
   "A test.tree thread runner function that binds some variables for\neach thread. Starts selenium client for each thread before kicking\noff tests, and stops it after all tests are done.",
   :var-type "function",
   :line 42,
   :file "src/katello/tests/setup.clj"}
  {:arglists ([coll]),
   :name "cant-be-blank-errors",
   :namespace "katello.validation",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.validation-api.html#katello.validation/cant-be-blank-errors",
   :doc
   "Takes collection of keywords like :name and produces map entry like\n:name-cant-be-blank #\"Name can't be blank",
   :var-type "function",
   :line 10,
   :file "src/katello/validation.clj"}
  {:arglists ([create-fn args & [pred]]),
   :name "duplicate-disallowed",
   :namespace "katello.validation",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.validation-api.html#katello.validation/duplicate-disallowed",
   :doc
   "Calls create-fn with the given args, twice, and verifies that the\nsecond call results in a 'Name taken' validation error.",
   :var-type "function",
   :line 67,
   :file "src/katello/validation.clj"}
  {:arglists ([expected-validation-err]),
   :name "expect-error",
   :namespace "katello.validation",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.validation-api.html#katello.validation/expect-error",
   :doc
   "Returns a predicate that will return true when one of the expected\nerrors actually appears in the validation result.",
   :var-type "function",
   :line 50,
   :file "src/katello/validation.clj"}
  {:arglists ([pred create-fn & args]),
   :name "expect-error-on-action",
   :namespace "katello.validation",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.validation-api.html#katello.validation/expect-error-on-action",
   :doc
   "Calls create-fn, which should create some katello entity with the\ngiven args. Verifies that the results match the given pred. The\npredicate can be a keyword for a matching error, or any predicate\nfunction.",
   :var-type "function",
   :line 82,
   :file "src/katello/validation.clj"}
  {:arglists ([create-fn args pred]),
   :name "field-validation",
   :namespace "katello.validation",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.validation-api.html#katello.validation/field-validation",
   :doc
   "Calls create-fn, which should create some katello entity with the\ngiven args. Verifies that the results match the given pred.",
   :var-type "function",
   :line 57,
   :file "src/katello/validation.clj"}
  {:arglists ([m]),
   :name "matching-validation-errors",
   :namespace "katello.validation",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.validation-api.html#katello.validation/matching-validation-errors",
   :doc "Returns a set of matching known validation errors",
   :var-type "function",
   :line 45,
   :file "src/katello/validation.clj"}
  {:arglists ([orig f vars]),
   :name "variations",
   :namespace "katello.validation",
   :source-url nil,
   :raw-source-url nil,
   :wiki-url
   "/katello.validation-api.html#katello.validation/variations",
   :doc
   "Produces variations of a set of test data. For each\nitem in vars, insert it into the original test data\nusing function f, to produce a new set of\ndata. ",
   :var-type "function",
   :line 38,
   :file "src/katello/validation.clj"})}
