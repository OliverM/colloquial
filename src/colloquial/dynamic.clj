(ns colloquial.dynamic
  (:require [quil.core :as q]
            [colloquial.colour]))

(defn setup []
  ; Set frame rate to 30 frames per second.
  (q/frame-rate 30)
  (q/background 200)
  )

(defn circle-draw []
  "The default quil example"
  (q/stroke (q/random 255) )
  (q/stroke-weight (q/random 10))
  (q/fill (q/random 255))
  (let [diam (q/random 100)
        x (q/random (q/width))
        y (q/random (q/height))]
    (q/ellipse x y diam diam)))

;; (def draw circle-draw)
;; (def draw colloquial.colour/draw-1-0-01)
;; (def draw colloquial.colour/draw-1-1-1-01-imp)
(def draw colloquial.colour/draw-1-1-1-01-fun)
