(ns colloquial.p111
  (:require [quil.core :as q]))

(defn draw-1-1-1-01-imp
  "Implementing Generative Design's P1-1-1-01.pde - colour spectrum in a grid"
  []
  ;; set hue and saturation range to window dimensions, brightness 0 to 100
  (q/color-mode :hsb (q/width) (q/height) 100)
  (q/no-stroke)
  (let [step-x (+ (q/mouse-x) 2)
        step-y (+ (q/mouse-y) 2)
        width (q/width)
        height (q/height)]
    (loop [grid-y 0]
      (when (< grid-y height)
        (loop [grid-x 0]
          (when (< grid-x width)
            ;; set current colour according to rect position and scale set previously
            (q/fill grid-x (- height grid-y) 100)
            (q/rect grid-x grid-y step-x step-y)
            (recur (+ grid-x step-x))))
        (recur (+ grid-y step-y))))))























(defn draw-1-1-1-01-fun
  "Re-implement the colour spectrum example in a more functional way"
  []
  ;; set hue and saturation range to window dimensions, brightness 0 to 100
  (q/color-mode :hsb (q/width)  (q/height) 100)
  (q/no-stroke)
  (let [step-x (+ (q/mouse-x) 2)
        step-y (+ (q/mouse-y) 2)
        width (q/width)
        height (q/height)]
    ;; doseq doesn't hold on to head of list
    (doseq [grid-y (range 0 height step-y)
            grid-x (range 0 width step-x)]
      ;; set current colour according to rect position and scale set previously
      (q/fill grid-x (- height grid-y) 100)
      (q/rect grid-x grid-y step-x step-y))))


