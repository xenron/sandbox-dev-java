(ns shapes-clj.core
  (:require [shapes-clj.shapes :as s]
            [shapes-clj.walkers :as w])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println (s/area {:shape :square :side 5}))
  (let [shapes [{:shape :square :side 3}
                {:shape :circle :radius 5}
                {:shape :circle :radius 4.5}]
        areas (map s/area shapes) ]
    (println (str "Total area " (apply + areas))))

  (println (w/walk {:type :shapes-clj.walkers/hominid})))
