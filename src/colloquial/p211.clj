(ns colloquial.p211
  (:require [quil.core :as q]))

(def colour-left (q/color 197 0 123))
(def colour-right (q/color 87 35 129))
(def colour-black (q/color 0))

(def start-state
  {:stroke-cap :round
   :colour-left colour-left
   :colour-right colour-right
   :alpha-left 100
   :alpha-right 100})

(defn setup []
  (q/color-mode :hsb 360 100 100 100)
  (q/nofill)
  (q/background 360)
  (assoc start-state
         :random-seed 0
         :tile-count 20))

(defn draw [s]
  (let [w (q/width)
        h (q/height)
        t (s :tile-count)
        tw (/ w t)
        th (/ h t)
        sc (s :stroke-cap)
        mx (q/mouse-x)
        my (q/mouse-y)]
    (q/random-seed (s :random-seed))
    (doseq [grid-y (range 0 t)
            grid-x (range 0 t)
            :let [x (-> w (/ (* t grid-x)))
                  y (-> h (/ (* t grid-y)))
                  toggle (int (q/random 0 2))]]
      (case toggle
        1 (do
            (q/stroke (s :colour-left) (s :alpha-left))
            (q/stroke-weight (/ mx 10))
            (q/line x y (+ x tw) (+ y th)))
        2 (do
            (q/stroke (s :colour-right) (s :alpha-right))
            (q/stroke-weight (/ my 10))
            (q/line x (+ y tw) (+ x th) y))))))

(defn mouse-clicked [s]
  (assoc s :random-seed (int (q/random 100000))))

(defn- swap-val
  "Takes a map, a key and two values. Swaps the value at the key for the other value; assumes value is either a or b initially."
  [m k a b]
  (if (= (m k) a)
    (assoc m k b)
    (assoc m k a))

(defn key-pressed [s e]
  (case (e :key)
    :1 (assoc s :stroke-cap :round)
    :2 (assoc s :stroke-cap :square)
    :3 (assoc s :stroke-cap :project)
    :4 (swap-val s :colour-left colour-left colour-black)
    :5 (swap-val s :colour-right colour-right colour-black)
    :6 (swap-val s :alpha-left 100 50)
    :7 (swap-val s :alpha-right 100 50)
    :0 (merge s start-state)))
