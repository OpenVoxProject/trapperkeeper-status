(def kitchensink-version "3.5.5")
(def trapperkeeper-version "4.3.2")
(def i18n-version "1.0.3")

(defproject org.openvoxproject/trapperkeeper-status "1.3.1-SNAPSHOT"
  :description "A trapperkeeper service for getting the status of other trapperkeeper services."
  :url "https://github.com/openvoxproject/trapperkeeper-status"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}

  :min-lein-version "2.9.0"

  :pedantic? :abort

  ;; These are to enforce consistent versions across dependencies of dependencies,
  ;; and to avoid having to define versions in multiple places. If a component
  ;; defined under :dependencies ends up causing an error due to :pedantic? :abort,
  ;; because it is a dep of a dep with a different version, move it here.
  :managed-dependencies [[org.clojure/clojure "1.12.4"]

                         [ring/ring-codec "1.3.0"]
                         [commons-codec "1.20.0"]

                         [org.bouncycastle/bcpkix-jdk18on "1.83"]
  
                         [org.openvoxproject/kitchensink ~kitchensink-version]
                         [org.openvoxproject/kitchensink ~kitchensink-version :classifier "test"]
                         [org.openvoxproject/trapperkeeper ~trapperkeeper-version]
                         [org.openvoxproject/trapperkeeper ~trapperkeeper-version :classifier "test"]]

  :dependencies [[org.clojure/clojure]
                 [cheshire "5.13.0"]
                 [slingshot "0.12.2"]
                 [prismatic/schema "1.4.1"]
                 [trptcolin/versioneer "0.2.0"]
                 [org.apache.httpcomponents/httpasyncclient "4.1.5"]
                 [org.clojure/java.jmx "1.1.1"]
                 [org.clojure/tools.logging "1.3.1"]
                 [org.openvoxproject/kitchensink]
                 [org.openvoxproject/trapperkeeper]
                 [org.openvoxproject/trapperkeeper-scheduler "1.3.0"]
                 [org.openvoxproject/ring-middleware "2.1.2"]
                 [org.openvoxproject/comidi "1.1.2"]
                 [org.openvoxproject/i18n ~i18n-version]
                 [org.openvoxproject/trapperkeeper-authorization "2.1.4"]]

  :deploy-repositories [["releases" {:url "https://clojars.org/repo"
                                     :username :env/CLOJARS_USERNAME
                                     :password :env/CLOJARS_PASSWORD
                                     :sign-releases false}]]

  :profiles {:dev {:dependencies [[org.bouncycastle/bcpkix-jdk18on]
                                  [org.openvoxproject/http-client "2.2.2"]
                                  [org.openvoxproject/trapperkeeper :classifier "test"]
                                  [org.openvoxproject/trapperkeeper-webserver-jetty10 "1.1.0"]
                                  [org.openvoxproject/kitchensink :classifier "test"]]}}

  :plugins [[org.openvoxproject/i18n ~i18n-version :hooks false]])
