(ns ns-playground.hello
  (:require [clojure.java.io :as io])
  (:import [java.util Date Properties]))

(def addition +)

(defn current-date []
  "Returns the current date"
  (new Date))

(defn <3 [love & loved-ones]
  "Creates a sequence of all the {loved-ones} {loved} loves"
  (for [loved-one loved-ones]
    (str love " love " loved-one)))

(defn sum-something [something & nums]
  "Adds something to all the remaining parameters"
  (apply addition something nums))

(defn read-properties [path]
  (let [resource (io/resource path)
        is (io/input-stream resource)
        props (Properties.)]
    (.load props is)
    props))


(def sum-one (partial sum-something 1))