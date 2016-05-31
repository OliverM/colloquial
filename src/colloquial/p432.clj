(ns colloquial.p432
  (:require [quil.core :as q]))

(def cover-text "Ihr naht euch wieder, schwankende Gestalten, Die früh sich einst dem trüben Blick gezeigt. Versuch ich wohl, euch diesmal festzuhalten? Fühl ich mein Herz noch jenem Wahn geneigt? Ihr drängt euch zu! nun gut, so mögt ihr walten, Wie ihr aus Dunst und Nebel um mich steigt; Mein Busen fühlt sich jugendlich erschüttert Vom Zauberhauch, der euren Zug umwittert. Ihr bringt mit euch die Bilder froher Tage, Und manche liebe Schatten steigen auf; Gleich einer alten, halbverklungnen Sage Kommt erste Lieb und Freundschaft mit herauf; Der Schmerz wird neu, es wiederholt die Klage.")

(def font-size-max 20)
(def font-size-min 10)
(def spacing 12)
(def kerning 0.5)
(def font-size-static false)
(def black-and-white false)

(defn setup []
  {:img (q/load-image "resources/leprachaun.png")
   :font (q/create-font "Times" 10)
   })

(defn draw [s]
  (q/background 255)
  (q/text-align :left)
  (let [x 0 y 10 counter 0
        h (q/height) w (q/width)
        ih (. (s :img) height)
        iw (. (s :img) width)]
    (loop [y y]
      )))
