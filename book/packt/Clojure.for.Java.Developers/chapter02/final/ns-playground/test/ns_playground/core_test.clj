(ns ns-playground.core-test
  (:import [java.util Date])
  (:require [clojure.test :refer :all]
            [ns-playground.hello :as hello :refer [<3]]
            [ns-playground.core :refer :all]))

(defn- lazy-contains? [col element]
  (not (empty? (filter #(= element %) col))))

(deftest a-test
  (testing "DONT FIXME, I don't fail."
    (is (= 42 42))))

(deftest current-date-is-date
  (testing "Test that the current date is a date"
    (is (instance? Date (hello/current-date)))))

(deftest check-loving-collection
  (testing "Check that I love clojure and you"
    (let [loving-seq (<3 "I" "Clojure" "you" "doggies" "chocolate")]
      (is (not (lazy-contains? loving-seq "I love Vogons")))
      (is (lazy-contains? loving-seq "I love Clojure"))
      (is (lazy-contains? loving-seq "I love doggies"))
      (is (lazy-contains? loving-seq "I love chocolate"))
      (is (lazy-contains? loving-seq "I love you")))))

