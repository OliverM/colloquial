(ns colloquial.p432
  (:require [quil.core :as q]))

(def cover-text "Ihr naht euch wieder, schwankende Gestalten, Die früh sich einst dem trüben Blick gezeigt. Versuch ich wohl, euch diesmal festzuhalten? Fühl ich mein Herz noch jenem Wahn geneigt? Ihr drängt euch zu! nun gut, so mögt ihr walten, Wie ihr aus Dunst und Nebel um mich steigt; Mein Busen fühlt sich jugendlich erschüttert Vom Zauberhauch, der euren Zug umwittert. Ihr bringt mit euch die Bilder froher Tage, Und manche liebe Schatten steigen auf; Gleich einer alten, halbverklungnen Sage Kommt erste Lieb und Freundschaft mit herauf; Der Schmerz wird neu, es wiederholt die Klage.")

(def font-size-max 20)
(def font-size-min 10)
(def spacing 12)
(def kerning 0.5)
(def font-size-static false)
(def black-and-white false)

(defn- line-wrap?
  "Check if, *after* adding a character to a text line, the line-width is exceeded and should be wrapped. Assumes supplied char-width is a reasonable measure of the second char-width, and that kerning has been applied."
  [x char-width line-width]
  (let [new-x (+ x char-width)]
    (>= (+ new-x char-width) line-width)))

(defn setup []
  {:img (q/load-image "resources/leprachaun.png")
   :font (q/create-font "Times" 10)
   })

(defn draw [s]
  (q/background 255)
  (q/text-align :left)
  (let [h (q/height)
        w (q/width)
        i (s :img)
        ih (. i height)
        iw (. i width)
        text-len (count cover-text)]
    (loop [x 0
           y 10
           counter 0]
      (let [ix (q/map-range x 0 w 0 iw)
            iy (q/map-range y 0 h 0 ih)
            letter (str (nth cover-text counter))
            colour (q/get-pixel (s :img) ix iy)
            grey (q/round
                  (+ (* (q/red colour) 0.222)
                     (* (q/green colour) 0.707)
                     (* (q/blue colour) 0.071)))]
        ;; (println (str "Image DEBUG: image width " iw ". image height " ih ". image x " ix ". image y " iy  ))
        (q/push-matrix)
        (q/translate x y)
        (if font-size-static
          (do (q/text-font (s :font) font-size-max)
              (if black-and-white (q/fill grey) (q/fill colour)))
          (let [font-size (q/map-range grey 0 255 font-size-max font-size-min)
                font-size (max font-size 1)]
            (q/text-font (s :font font-size))
            (if black-and-white (q/fill grey) (q/fill colour))))
        (q/text letter 0 0)
        (q/pop-matrix)
        (let [letter-width (+ (q/text-width letter) kerning)
              line-wrap (line-wrap? x letter-width w)
              counter (inc counter)
              counter (if (> counter (dec text-len)) 0 counter)
              ]
          ;; (println (str "Text DEBUG: length " text-len ". counter " counter))
          (when (< y h)
            (if line-wrap
              (recur 0 (+ y spacing) counter)
              (recur (+ x letter-width) y counter))))))))

(def sketch4-3-2-args [:setup setup :draw draw])
