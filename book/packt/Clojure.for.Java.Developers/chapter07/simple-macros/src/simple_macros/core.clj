(ns simple-macros.core
  (:gen-class))

(defmacro my-if [test positive negative]
  (list 'if test positive negative))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (let [a 500]
    (my-if (> a 200)
           (do
             (println "Bigger than 200")
             :bigger)
           (do
             (println "Smaller than 200")
             :smaller))
    (println (macroexpand-1
               '(my-if (> a 200)
                       (do
                         (println "Bigger than 200")
                         :bigger)
                       (do
                         (println "Smaller than 200")
                         :smaller))) ) ))
