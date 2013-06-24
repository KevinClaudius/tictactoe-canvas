(defproject tictactoe-canvas "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 ; A jquery wrapper for clojurescript
                 [jayq "2.3.0"]]
  
  :plugins [[lein-cljsbuild "0.3.2"]
            [lein-ring "0.8.5"]]
  
  :ring {:handler tictactoe-canvas.handler/app}
  
  :source-paths ["src/clj"]
  
  ; Adds a hook to compile the clojurescript
  :hooks [leiningen.cljsbuild]
  
  :cljsbuild {:builds {:main {:source-paths ["src/cljs"]
                              :compiler {:output-to "resources/public/js/tictactoe.js"
                                         :optimizations :whitespace
                                         :pretty-print true}
                              :jar true}}})
