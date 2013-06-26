(ns tictactoe-canvas
  (:use [jayq.core :only [$]]
        [util :only [log floor]]))

(defn canvas
  "Returns the canvas to draw on"
  []
  (first ($ :#canvas)))

(defn context
  "Returns the drawing context"
  []
  (.getContext (canvas) "2d"))

(defn canvas-width []
  (.-width (canvas)))

(defn canvas-height []
  (.-height (canvas)))

(defn firstthird)

(defn draw-line 
  "Draws a line from x1,y1 to x2,y2. 
  Supports options: color and line width"
  [x1 y1 x2 y2 & {:keys [color line-width]
                  :or {color "black" 
                       line-width 1}}] 
  (let [c (context)]
    (log (format "Drawing %s %d line from %d,%d to %d,%d " color line-width x1 y1 x2 y2))
    (set! (.-strokeStyle (context)) color)
    (set! (.-lineWidth c) line-width)
    (.beginPath c)
    (.moveTo c x1 y1)
    (.lineTo c x2 y2)
    (.closePath c)
    (.stroke c)))

(defn draw-grid
  "Draws the tic tac toe grid"
  []
  (log "TODO I should draw a grid")
  ; Draws a diagonal line to demonstrate it works
  (draw-line (/ (canvas-width) 3) 0 (/ (canvas-width) 3) (canvas-width))
  (draw-line (* (canvas-width) .66) 0 (* (canvas-width) .66) (canvas-width))
  (draw-line 0 (/ (canvas-width) 3) (canvas-width) (/ (canvas-width) 3))
  (draw-line 0 (* (canvas-width) .66) (canvas-width) (* (canvas-width) .66))
  )
