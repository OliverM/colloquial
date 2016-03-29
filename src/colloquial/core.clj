(ns colloquial.core
  (:require [quil.core :as q]
            [colloquial.dynamic :as dyn]
            [quil.middleware :as m]))

(q/defsketch colloquial
  :title "Random circles everywhere"
  :settings #(q/smooth 2)
  :size [720 720]
  ; setup function called only once, during sketch initialization.
  :setup dyn/setup
  :draw dyn/draw
  :features [:keep-on-top]
  ; This sketch uses functional-mode middleware.
  ; Check quil wiki for more info about middlewares and particularly
  ; fun-mode.
  )
