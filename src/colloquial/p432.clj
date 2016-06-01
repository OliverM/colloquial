(ns colloquial.p432
  (:require [quil.core :as q]))

(def cover-text "Ihr naht euch wieder, schwankende Gestalten, Die früh sich einst dem trüben Blick gezeigt. Versuch ich wohl, euch diesmal festzuhalten? Fühl ich mein Herz noch jenem Wahn geneigt? Ihr drängt euch zu! nun gut, so mögt ihr walten, Wie ihr aus Dunst und Nebel um mich steigt; Mein Busen fühlt sich jugendlich erschüttert Vom Zauberhauch, der euren Zug umwittert. Ihr bringt mit euch die Bilder froher Tage, Und manche liebe Schatten steigen auf; Gleich einer alten, halbverklungnen Sage Kommt erste Lieb und Freundschaft mit herauf; Der Schmerz wird neu, es wiederholt die Klage.")

(def spacing 12)
(def kerning 0.5)


(defn- line-wrap?
  "Check if, *after* adding a character to a text line, the line-width is exceeded and should be wrapped. Assumes supplied char-width is a reasonable measure of the second char-width, and that kerning has been applied."
  [x char-width line-width]
  (let [new-x (+ x char-width)]
    (>= (+ new-x char-width) line-width)))

(defn setup []
  {;; :img (q/load-image "resources/blueyorange.png")
   :img (q/load-image "resources/mrt.png")
   :font (q/create-font "Times" 10)
   :font-size-static false
   :black-and-white false
   :font-size-max 20
   :font-size-min 10})

(defn draw [s]
  (q/background 255)
  (q/text-align :left)
  (let [font-size-static (s :font-size-static)
        black-and-white (s :black-and-white)
        font (s :font)
        font-size-max (s :font-size-max)
        font-size-min (s :font-size-min)
        h (q/height)
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
        (q/push-matrix)
        (q/translate x y)
        (if font-size-static
          (do (q/text-font font font-size-max)
              (if black-and-white (q/fill grey) (q/fill colour)))
          (let [font-size (q/map-range grey 0 255 font-size-max font-size-min)
                font-size (max font-size 1)]
            (q/text-font font font-size)
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

(defn key-pressed [s e]
  (case (e :key)
    :1 (assoc s :black-and-white (not (s :black-and-white)))
    :2 (assoc s :font-size-static (not (s :font-size-static)))
    :up (assoc s :font-size-max (+ (s :font-size-max) 2))
    :down (assoc s :font-size-max (- (s :font-size-max) 2))
    :left (assoc s :font-size-min (+ (s :font-size-min) 2))
    :right (assoc s :font-size-min (- (s :font-size-min) 2))
    s))

(def sketch4-3-2-args [:setup setup :draw draw :key-pressed key-pressed])
