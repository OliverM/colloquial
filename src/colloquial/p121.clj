(ns colloquial.p121
  (:require [quil.core :as q]))

(def sketch1-2-1-args [])

(defn- shake-colours
  [s]
  (assoc s :colours-left (repeatedly
                          (:tile-count-y s)
                          (q/color (q/random 0 60) (q/random 0 100) 100))
         :colours-right (repeatedly
                         (:tile-count-y s)
                         (q/color (q/random 160 190) 100 (q/random 0 100)))))

(defn setup1-2-1-01
  []
  (q/color-mode :hsb 360 100 100)
  (shake-colours {:tile-count-x 2
                  :tile-count-y 10
                  ;; :colours nil ;; used for ASE export; TODO
                  :interp-short true}))

(defn draw1-2-1-01
  "Implementing Generative Design's P1-2-1-01.pde - Colour palettes through interpolation"
  [s]
  (let [tile-count-x (q/map-range (q/mouse-x) 0 (q/width) 2 100 )
        tile-count-y (q/map-range (q/mouse-y) 0 (q/height) 2 10)
        tile-width (/ (q/width) tile-count-x)
        tile-height (/ (q/height) tile-count-y)]
    (doseq [grid-y (range 0 tile-count-y)
            grid-x (range 0 tile-count-x)
            :let [col-1 (nth (s :colours-left) grid-y)
                  col-2 (nth (s :colours-right) grid-y)
                  amount (q/map-range grid-x 0 (dec tile-count-x) 0 1)]]
      
      ) )
  )
