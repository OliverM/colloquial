(ns colloquial.colour
  (:require [quil.core :as q])
  (:import [processing.pdf PGraphicsPDF]))

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

(defn draw-1-1-1-01-imp
  "Implementing Generative Design's P1-1-1-01.pde - colour spectrum in a grid"
  []
  (q/color-mode :hsb (q/width) (q/height) 100) ;; set hue and saturation range to window dimensions, brightness 0 to 100
  (q/no-stroke)
  (let [step-x (+ (q/mouse-x) 2)
        step-y (+ (q/mouse-y) 2)
        width (q/width)
        height (q/height)]
    (loop [grid-y 0]
      (when (< grid-y height)
        (loop [grid-x 0]
          (when (< grid-x width)
            (q/fill grid-x (- height grid-y) 100) ;; set current colour according to rect position and scale set previously
            (q/rect grid-x grid-y step-x step-y)
            (recur (+ grid-x step-x))))
        (recur (+ grid-y step-y))))))

(defn draw-1-1-1-01-fun
   "Re-implement the colour spectrum example in a more functional way"
   []
  (q/color-mode :hsb (q/width)  (q/height) 100) ;; set hue and saturation range to window dimensions, brightness 0 to 100
  (q/no-stroke)
  (let [step-x (+ (q/mouse-x) 2)
        step-y (+ (q/mouse-y) 2)
        width (q/width)
        height (q/height)]
    (doseq [grid-y (range 0 height step-y) ;; doseq doesn't hold on to head of list
            grid-x (range 0 width step-x)]
      (q/fill grid-x (- height grid-y) 100) ;; set current colour according to rect position and scale set previously
      (q/rect grid-x grid-y step-x step-y))))
