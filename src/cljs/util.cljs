(ns util)

(defn log 
  "Logs the object to the browser console"
  [s]
  (.log js/console s))

(defn floor 
  "Rounds the number down to integer."
  [i]
  (.floor js/Math i))
