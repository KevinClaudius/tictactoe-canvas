(ns game
  (:use [util :only [log]])
  (:require-macros [jayq.macros])
  (:require [tictactoe-canvas :as canvas]
            [goog.events :as events]))
            
(defn new-game 
  "Constructs a new game state. A 3x3 matrix of :b (blank), :x or :o"
  []
  [[:b :b :b]
   [:b :b :b]
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

(defn handle-mouseclick! [event]
  (let [x (. event -offsetX)
        y (. event -offsetY)]
    (log (str "Clicked: " x ", " y ))))

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