(ns tictactoe-canvas.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as resp]))

(defroutes app-routes
  ; Returns the resources/public/index.html file.
  (GET "/" [] (resp/file-response "index.html" {:root "resources/public"}))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
