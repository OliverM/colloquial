(ns colloquial.olive
  (:require [quil.core :as q]))

(defn setup [] {})

(defn draw [s]
  (q/background 200)
  (q/translate 500 500)
  (q/rotate (q/frame-count))
  (q/translate -500 -500)
  (q/ellipse 500 500 100 100)
  (q/ellipse 500 500 200 200)
  (q/ellipse 500 500 300 300)
  (q/ellipse 500 500 400 400)
  (q/ellipse 500 500 500 500)
  (q/ellipse 500 500 600 600)
  (q/ellipse 500 500 700 700)
  (q/ellipse 500 500 800 800)
  (q/ellipse 500 500 900 900)
  (q/ellipse 500 500 1000 1000)
  (q/ellipse 500 500 1100 1100)
  (q/ellipse 500 500 1200 1200)
  (q/ellipse 500 500 1300 1300)
  (q/ellipse 500 500 1400 1400)
  (q/ellipse 500 500 1500 1500)
  (q/ellipse 500 500 1600 1600)
  (q/ellipse 500 500 1700 1700)
  (q/ellipse 500 500 1800 1800)
  (q/ellipse 500 500 1900 1900)
  (q/ellipse 500 500 2000 2000)
  (q/ellipse 500 500 2100 2100)
  (q/ellipse 500 500 2200 2200)
  (q/ellipse 500 500 2300 2300)
  (q/ellipse 500 500 2400 2400)
  (q/ellipse 500 500 2500 2500)
  (q/ellipse 500 500 2600 2600)
  (q/ellipse 500 500 2700 2700)
  (q/ellipse 500 500 2800 2800)
  (q/ellipse 500 500 2900 2900)
  (q/ellipse 500 500 3000 300))

(def sketch-olive-args [:setup setup :draw draw])
