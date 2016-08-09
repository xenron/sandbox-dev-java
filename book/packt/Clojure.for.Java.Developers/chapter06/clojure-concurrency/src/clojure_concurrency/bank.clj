(ns clojure-concurrency.bank)

(defn withdraw [account amount secured]
  (dosync 
    (let [secured-value (ensure secured)]
      (deliver started true)
      (Thread/sleep 5000)
      (println :started)
      (when-not secured-value
        (alter account - amount))
      (println :finished))))

