(ns colloquial.p20
  (:require [quil.core :as q]))

(defn setup2-0-2
  []
  (q/color-mode :hsb 360 100 100 100)
  ;; smooth set by :settings
  (q/no-fill)
  (q/background 360)
  {:stroke-color (q/color 0 10)})

(defn draw2-0-2
  [s]
  (when (q/mouse-pressed?)
    (let [h (q/height)
          w (q/width)
          ^int circle-resolution (q/map-range (+ (q/mouse-y) 100) 0 h 2 10)
          radius (-> (- (q/mouse-x) (/ w 2)))
          angle (/ q/TWO-PI circle-resolution)]
      (q/push-matrix)
      (q/translate (/ w 2) (/ h 2))
      (q/stroke-weight 2)
      (q/stroke (s :stroke-color))
      (q/begin-shape)
      (doseq [^int i (range circle-resolution)
              :let [^float x (+ 0  (* (q/cos (* i angle)) radius))
                    ^float y (+ 0  (* (q/sin (* i angle)) radius))]]
        (q/vertex x y))
      (q/end-shape)
      (q/pop-matrix))))

(defn key-pressed2-0-2
  [s e]
  (case (e :key)
    :1 (assoc s :stroke-color (q/color 0 10))
    :2 (assoc s :stroke-color (q/color 192 100 64 10))
    :3 (assoc s :stroke-color (q/color 52 100 71 10))
    :d (do (q/background 360) s)
    s))

(def sketch2-0-2-args
  [:setup setup2-0-2
   :draw draw2-0-2
   :key-pressed key-pressed2-0-2])

