(ns colloquial.misc
  (:require [quil.core :as q]))

(defn circle-draw []
  "The default quil example"
  (q/stroke (q/random 255) )
  (q/stroke-weight (q/random 10))
  (q/fill (q/random 255))
  (let [diam (q/random 100)
        x (q/random (q/width))
        y (q/random (q/height))]
    (q/ellipse x y diam diam)))
