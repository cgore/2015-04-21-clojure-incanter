(ns code.core
  "Howdy Incanter!"
  (:require [incanter.core :as i
                           :refer [$ dim view]]
            [incanter.stats :as is]
            [incanter.charts :as ic
                             :refer [histogram]]
            [incanter.io :as iio
                         :refer [read-dataset]]))

(view (ic/function-plot #(Math/sin %) -4 4
                        :y-label "sin(x)"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
