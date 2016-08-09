(ns shapes-clj.shapes)

(defmulti area :shape)
(defmulti perimeter :shape)

(defmethod area :square [{:keys [side]}] (* side side))
(defmethod area :circle [{:keys [radius]}] (* Math/PI radius radius))

(defmethod perimeter :square [{:keys [side]}] (* side 4))
(defmethod perimeter :circle [{:keys [radius]}] (* 2 Math/PI radius))

