(ns logging.core
  (:gen-class))


(defn logging-odd? [number]
  (do
    (println number) ;; This is terrible, it is a side effect and a source for problems
    ;; Clojure encourages you to avoid side effects, but it is pragmatic
    ;; and relies on you knowing what you are doing
    (odd? number)))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (do
    (def r (range))
    (def odd-numbers (filter odd? r))
    (def logged-odd-numbers (filter logging-odd? r))
    (println "Hello, World!") 
    (println (take 10 odd-numbers))
    (println (take 10 logged-odd-numbers))
    (println (take 10 logged-odd-numbers))
    ))

