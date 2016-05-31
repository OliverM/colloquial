(ns colloquial.p121
  (:require [quil.core :as q]
            [thi.ng.color.core :as c]))

(defn- shake-colours
  [s]
  (let [col-count (:tile-count-y s)
        left-col-gen #(q/color (q/random 0 60) (q/random 0 100) 100)
        right-col-gen #(q/color (q/random 160 190) 100 (q/random 0 100))]
    (assoc s
           :colours-left (vec (repeatedly col-count left-col-gen))
           :colours-right (vec (repeatedly col-count right-col-gen)))))

(defn- flip-colour-model
  [s]
  (let [current (s :interp-short)]
    (assoc s :interp-short (not current))))

(defn setup1-2-1-01
  []
  (q/no-stroke)
  (q/color-mode :hsb 360 100 100)
  (shake-colours {:tile-count-x 2
                  :tile-count-y 10
                  :interp-short true}))

(defn update1-2-1-01
  [s]
  s)

(defn draw1-2-1-01
  "Implementing Generative Design's P1-2-1-01.pde - Colour palettes through interpolation"
  [s]
  (let [tile-count-x (q/map-range (q/mouse-x) 0 (q/width) 2 100 )
        tile-count-y (q/map-range (q/mouse-y) 0 (q/height) 2 10)
        tile-width (/ (q/width) tile-count-x)
        tile-height (/ (q/height) tile-count-y)]
    (doseq [grid-y (range 0 tile-count-y)
            grid-x (range 0 tile-count-x)
            :let [pos-x (* tile-width grid-x)
                  pos-y (* tile-height grid-y)
                  col-1 (nth (s :colours-left) grid-y (q/color 100 ))
                  col-2 (nth (s :colours-right) grid-y (q/color 100))
                  amount (q/map-range grid-x 0 (dec tile-count-x) 0 1)]]
     (if (s :interp-short)
        (do (q/color-mode :rgb 255 255 255 255)
            (q/fill (q/lerp-color col-1 col-2 amount))
            (q/color-mode :hsb 360 100 100 100))
           (q/fill (q/lerp-color col-1 col-2 amount)))
     (q/rect pos-x pos-y tile-width tile-height))))

(defn mouse-click1-2-1-01
  [s e]
  (if (= (:button e) :left)
    (shake-colours s)
    (flip-colour-model s)))

(def sketch1-2-1-args
  [:setup setup1-2-1-01
   :draw draw1-2-1-01
   :update update1-2-1-01
   :mouse-clicked mouse-click1-2-1-01])

;; - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
;; additional colour models stashed for now;
;; investigate further post presentation

#_(defn step-colour-model [n]
  (let [models [:hsb :rgb :hcy :cie1931a]
        model-count (count models)
        model-index (mod n model-count)]
    (nth models model-count )))
