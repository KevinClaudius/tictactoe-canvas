(ns game
  (:use [util :only [log floor]])
  (:require-macros [jayq.macros])
  (:require [tictactoe-canvas :as canvas]
            [goog.events :as events]))
            
(defn new-game 
  "Constructs a new game state. A 3x3 matrix of :b (blank), :x or :o"
  []
  [[:b :b :b]
   [:b :x :b]
   [:b :b :b]])

; The current state of the game
(def game (atom nil))

(defn handle-game-update 
  "Handles an update to the game atom."
  [watch-key game-atom old-game new-game]
  (log (str "Game updated " new-game))
  ; TODO draw the updated game on the browser
  )

(defn handle-mousemove! [event]
  (let [x (. event -offsetX)
        y (. event -offsetY)]
    #_(log (str "x and y within canvas " x ", " y ))))

(defn detect-row [y]
  (util/floor (/ y (/ (canvas/canvas-width) 3))))

(defn handle-mouseclick! [event]
  (let [x (. event -offsetX)
        y (. event -offsetY)
        row (detect-row y)
        col (detect-row x)]
    (log (str "Clicked: " x ", " y " and found " ((@game row) col)))))


(defn enable-mouse! 
  "Connects mouse events to ClojureScript functions."
  []
  (let [c (canvas/canvas)]
    (events/listen c "mousedown" handle-mouseclick!)
    (events/listen c "mousemove" handle-mousemove!)))


(defn kickoff 
  "Initial game setup"
  []
  (log "Kickoff starting")
  (enable-mouse!)
  (canvas/draw-grid)
  
  ; Add a watch on the game atom
  (add-watch game :game-updates handle-game-update)
  
  ; Last but not least set the current state as a new game
  (swap! game new-game)
  (log "Kickoff complete"))

; Use jayq macro that 
(jayq.macros/ready (kickoff))