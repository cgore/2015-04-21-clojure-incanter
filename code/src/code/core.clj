(ns code.core
  "Howdy Incanter!"
  (:require [incanter.core :as i
             :refer [$ conj-cols conj-rows dataset
                     dim to-dataset view]]
            [incanter.stats :as is]
            [incanter.charts :as ic
                             :refer [histogram]]
            [incanter.io :as iio
                         :refer [read-dataset]]))

;;; Simple plot of a sine wave.
(view (ic/function-plot #(Math/sin %) -4 4
                        :y-label "sin(x)"))

;;; A small data set can be inlined.
(def small-data (dataset ["x" "y" "theta"]
                           [[1   2   3]
                            [4   5   6]
                            [7   8   9]]))


;;; Two larger data sets in CSV files.
(def pass-data (read-dataset "../Pass.csv"
                             :header true))
(def fail-data (read-dataset "../Pass.csv"
                             :header true))

;;; Another way to make a dataset.
(def data-from-hashmaps (to-dataset [{:x 1 :y 2}
                                     {:x 3 :y 4}
                                     {:x 5 :y 6}]))

;;; Or just from a vector of vectors.
(def data-from-vecs (to-dataset [[1 2 3]
                                 [4 5 6]
                                 [7 8 9]]))

;;; Building a dataset from columns.
(def data-cols (conj-cols [1 4 7]
                          [2 5 8]
                          [3 6 9]))

;;; Building a dataset from rows.
(def data-rows (conj-rows [1 2 3]
                          [4 5 6]
                          [7 8 9]))

(def air-passengers
  (read-dataset
   (str "http://vincentarelbundock.github.io"
        "/Rdatasets/csv/datasets/AirPassengers.csv")
   :header true))

;;; The $ operator is a shortcut to get that column of data out of a dataset.
(defn x [dataset]
  ($ :x dataset))
(defn y [dataset]
  ($ :y dataset))
(defn theta [dataset]
  ($ :theta dataset))

;;; Often datasets will have multiple words in the name: use the keyword
;;; operator to make a keyword like that.
(defn mpi [dataset]
  ($ (keyword "Monthly Personal Income") dataset))

(let [mpi-filtered (filter #(< 0 %) (mpi pass-data))
      mpi-log10 (map #(Math/log10 %) mpi-filtered)]
  (view (histogram mpi-log10
                   :x-label "Monthly Personal Income"
                   :nbins 50)))

(defn -main
  [& args])
