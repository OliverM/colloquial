(ns colloquial.core
  (:require [quil.middleware :as m]
            [quil.core :as q]
            [colloquial.misc :as misc]
            [colloquial.p10 :as p10]
            [colloquial.p111 :as p111]
            [colloquial.p121 :as p121]
            [colloquial.p20 :as p20]
            [colloquial.p211 :as p211]
            [colloquial.p432 :as p432]
            ))

(defn no-state-setup []
  ;; Set frame rate to 30 frames per second.
  (q/frame-rate 30)
  ;; set the background to a light gray
  (q/background 200))

(def no-state
  [:title "Pure draw demonstrator"
   :settings #(q/smooth 2)
   :size [720 720]
   :setup no-state-setup ;; called once during init
   :features [:keep-on-top]])

(def threaded-state
  [:title "Threaded state demonstrator"
   :settings #(q/smooth 2)
   :size [720 720]
   :features [:keep-on-top]
   :middleware [m/fun-mode]] ;; lifecycle & event functions accept extra state argument
  )

(defn run-sketch
  [base & opts]
  (apply q/sketch (concat base opts)))

;; (run-sketch no-state :draw misc/circle-draw)
;; (run-sketch no-state :draw p10/draw-1-0-01)
;; (run-sketch no-state :draw p111/draw-1-1-1-01-imp)
;; (run-sketch no-state :draw p111/draw-1-1-1-01-fun)
;; (run-sketch (concat threaded-state p121/sketch1-2-1-args))
;; (run-sketch (concat threaded-state p20/sketch2-0-2-args))
;; (run-sketch (concat threaded-state p211/sketch2-1-1-args))
;; (run-sketch (concat threaded-state p432/sketch4-3-2-args))
