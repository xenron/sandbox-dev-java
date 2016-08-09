(ns clojure-concurrency.core
  (:use co.paralleluniverse.pulsar.core))

(defn start-thread [func]
  (.start (Thread. func)))

(defn test-promise []
  (def p (promise))
  (start-thread
    #(do
       (deref p)
       (println "Hello world")))
  (deliver p 5))

(defn test-light-threads []
  (def p1 (promise))
  (def p2 (promise))
  (def p3 (promise))
  (spawn-fiber #(clojure.core/deliver p2 (clojure.core/+ @p1 5)))
  (spawn-fiber #(clojure.core/deliver p3 (clojure.core/+ @p1 @p2)))
  (spawn-thread #(println @p3))
  (clojure.core/deliver p1 99))

(defn test-futures []
  (def f (future (Thread/sleep 20000) "Hello world"))
  (println @f))

(defn test-transactional-memory []
  (def account (ref 20000))

  (defn test []
    (println "Transaction started")
    (dotimes [n 5]
      (println n @account)
      (Thread/sleep 2000))
    (ref-set account 90))

  (future (dosync (test)))
  (future (dosync (Thread/sleep 4000) (ref-set account 5))) )


(defn test-atoms []
  (def events (atom []))
  (defn log-events [count event-id]
    (dotimes [_ count]
      (swap! events conj event-id)))
  (dotimes [n 5]
    (spawn-fiber #(log-events 500 n))) 
  (println (count (filter #(= 0 %) @events)))
  (println (count (filter #(= 1 %) @events)))
  (println (count (filter #(= 2 %) @events)))
  (println (count (filter #(= 3 %) @events)))
  (println (count (filter #(= 4 %) @events))))


(defn test-agent []
  (def agt (agent 0))
  (defn sum [& nums]
    (Thread/sleep 5000)
    (println :done)
    (apply + nums))
  (send agt sum 10)
  (while (not= 10 @agt)
    (println @agt))
  (println @agt))

(defn test-validator []
  (def v (agent 0))
  (set-validator! v #(< % 5))
  (swap! v + 10))

(defn test-watcher []
  (def v (atom 0))
  (add-watch v :sample (fn [k i old-value new-value] (println (= i v) k old-value new-value)))
  (reset! v 5))

