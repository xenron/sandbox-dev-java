(ns shapes-clj.walkers)

(defmulti walk :type)

(defmethod walk ::animal [_] "Just walk")
(defmethod walk ::primate [_] "Primate walk")

(derive ::hominid ::primate)

(println ::hominid)

