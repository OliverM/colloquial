(ns colloquial.p211
  (:require [quil.core :as q]))

(def start-state
  {:stroke-cap :round
   :colour-left-a nil
   :colour-right-a nil
   :colour-black nil
   :colour-left :colour-left-a
   :colour-right :colour-right-a
   :alpha-left 100
   :alpha-right 100})

(defn setup []
  (q/no-fill)
  (q/background 360)
  (assoc start-state
         :colour-left-a (q/color 197 0 123)
         :colour-right-a (q/color 87 35 129)
         :colour-black (q/color 0)
         :random-seed 0
         :tile-count 20))

(defn draw [s]
  (let [w (q/width)
        h (q/height)
        t (s :tile-count)
        tw (/ w t)
        th (/ h t)
        l-col (s (s :colour-left))
        r-col (s (s :colour-right))
        sc (s :stroke-cap)
        mx (q/mouse-x)
        my (q/mouse-y)]
    (q/stroke-cap sc)
    (q/color-mode :hsb 360 100 100 100)
    (q/background 360)
    (q/random-seed (s :random-seed))
    (doseq [grid-y (range 0 t)
            grid-x (range 0 t)
            :let [x (-> (/ w t) (* grid-x)) ;; orig has subtle ordering
                  y (-> (/ h t) (* grid-y))
                  toggle (int (q/random 0 2))]]
      (case toggle
        0 (do
            (q/stroke l-col (s :alpha-left))
            (q/stroke-weight (/ mx 10))
            (q/line x y (+ x tw) (+ y th)))
        1 (do
            (q/stroke r-col (s :alpha-right))
            (q/stroke-weight (/ my 10))
            (q/line x (+ y tw) (+ x th) y))))))

(defn mouse-clicked [s e]
  (assoc s :random-seed (int (q/random 100000))))

(defn- swap-val
  "Takes a map, a key and two values. Swaps the value at the key for the other value; assumes value is either a or b initially."
  [m k a b]
  (if (= (m k) a)
    (assoc m k b)
    (assoc m k a)))

(defn key-pressed [s e]
  (case (e :key)
    :1 (assoc s :stroke-cap :round)
    :2 (assoc s :stroke-cap :square)
    :3 (assoc s :stroke-cap :project)
    :4 (swap-val s :colour-left :colour-left-a :colour-black)
    :5 (swap-val s :colour-right :colour-right-a :colour-black)
    :6 (swap-val s :alpha-left 100 50)
    :7 (swap-val s :alpha-right 100 50)
    :0 (merge s start-state
              {:colour-left-a (s :colour-left-a)
               :colour-right-a (s :colour-right-a)
               :colour-black (s :colour-black)})
    s))

(def sketch2-1-1-args [:setup setup :draw draw :mouse-clicked mouse-clicked :key-pressed key-pressed])
