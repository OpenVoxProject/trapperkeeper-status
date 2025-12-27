(defproject org.openvoxproject/trapperkeeper-status "1.2.1-SNAPSHOT"
  :description "A trapperkeeper service for getting the status of other trapperkeeper services."
  :url "https://github.com/openvoxproject/trapperkeeper-status"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}

  :min-lein-version "2.9.0"

  :parent-project {:coords [org.openvoxproject/clj-parent "7.4.1-SNAPSHOT"]
                   :inherit [:managed-dependencies]}

  :pedantic? :abort

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

  :deploy-repositories [["clojars" {:url "https://clojars.org/repo"
                                     :username :env/CLOJARS_USERNAME
                                     :password :env/CLOJARS_PASSWORD
                                     :sign-releases false}]]

  :profiles {:dev {:dependencies [[org.bouncycastle/bcpkix-jdk18on]
                                  [org.openvoxproject/http-client]
                                  [org.openvoxproject/trapperkeeper :classifier "test"]
                                  [org.openvoxproject/trapperkeeper-webserver-jetty10]
                                  [org.openvoxproject/kitchensink :classifier "test"]]}}

  :plugins [[lein-parent "0.3.9"]
            [org.openvoxproject/i18n "0.9.3-SNAPSHOT" :hooks false]])
