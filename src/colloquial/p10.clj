(ns colloquial.p10
  (:require [quil.core :as q]))

(defn draw-1-0-01
  "Implementing Generative Design's P1_0_01.pde - random colour boxes"
  []
  (q/color-mode :hsb 360 100 100)
  (q/rect-mode :center)
  (q/no-stroke)
  (q/background (/ (q/mouse-y) 2) 100 100)
  (q/fill (- 360 (/ (q/mouse-y) 2)) 100 100)
  (q/rect 360 360 (inc (q/mouse-x)) (inc (q/mouse-x)))
  )

