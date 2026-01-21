(def i18n-version "1.0.3")

(defproject org.openvoxproject/trapperkeeper-status "1.3.3-SNAPSHOT"
  :description "A trapperkeeper service for getting the status of other trapperkeeper services."
  :url "https://github.com/openvoxproject/trapperkeeper-status"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}

  :min-lein-version "2.9.0"

  :pedantic? :abort

  ;; Generally, try to keep version pins in :managed-dependencies and the libraries
  ;; this project actually uses in :dependencies, inheriting the version from
  ;; :managed-dependencies. This prevents endless version conflicts due to deps of deps.
  ;; Renovate should keep the versions largely in sync between projects.
  :managed-dependencies [[org.clojure/clojure "1.12.4"]
                         [org.clojure/java.jmx "1.1.1"]
                         [org.clojure/tools.logging "1.3.1"]

                         [commons-codec "1.20.0"]
                         [commons-io "2.21.0"]
                         [cheshire "5.13.0"]
                         [org.apache.httpcomponents/httpasyncclient "4.1.5"]
                         [org.bouncycastle/bcpkix-jdk18on "1.83"]
                         [org.ring-clojure/ring-websocket-protocols "1.14.2"]
                         [prismatic/schema "1.4.1"]
                         [ring/ring-core "1.14.2"]
                         [ring/ring-codec "1.3.0"]
                         [slingshot "0.12.2"]
                         [trptcolin/versioneer "0.2.0"]

                         [org.openvoxproject/comidi "1.1.2"]
                         [org.openvoxproject/http-client "2.2.3"]
                         [org.openvoxproject/i18n ~i18n-version]
                         [org.openvoxproject/kitchensink "3.5.5"]
                         [org.openvoxproject/kitchensink "3.5.5" :classifier "test"]
                         [org.openvoxproject/ring-middleware "2.1.3"]
                         [org.openvoxproject/trapperkeeper "4.3.2"]
                         [org.openvoxproject/trapperkeeper "4.3.2" :classifier "test"]
                         [org.openvoxproject/trapperkeeper-authorization "2.1.5"]
                         [org.openvoxproject/trapperkeeper-scheduler "1.3.1"]
                         [org.openvoxproject/trapperkeeper-webserver-jetty10 "1.1.3"]]

  :dependencies [[org.clojure/clojure]
                 [cheshire]
                 [slingshot]
                 [prismatic/schema]
                 [trptcolin/versioneer]
                 [org.apache.httpcomponents/httpasyncclient]
                 [org.clojure/java.jmx]
                 [org.clojure/tools.logging]
                 [org.openvoxproject/kitchensink]
                 [org.openvoxproject/trapperkeeper]
                 [org.openvoxproject/trapperkeeper-scheduler]
                 [org.openvoxproject/ring-middleware]
                 [org.openvoxproject/comidi]
                 [org.openvoxproject/i18n]
                 [org.openvoxproject/trapperkeeper-authorization]]

  :deploy-repositories [["releases" {:url "https://clojars.org/repo"
                                     :username :env/CLOJARS_USERNAME
                                     :password :env/CLOJARS_PASSWORD
                                     :sign-releases false}]]

  :profiles {:dev {:dependencies [[org.bouncycastle/bcpkix-jdk18on]
                                  [org.openvoxproject/http-client]
                                  [org.openvoxproject/kitchensink :classifier "test"]
                                  [org.openvoxproject/trapperkeeper :classifier "test"]
                                  [org.openvoxproject/trapperkeeper-webserver-jetty10]]}}

  :plugins [[org.openvoxproject/i18n ~i18n-version :hooks false]])
