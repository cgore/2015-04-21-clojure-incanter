(defproject code "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [incanter "1.5.6"]]
  :main ^:skip-aot code.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
