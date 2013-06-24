# tictactoe-canvas

This project is a starting off point for building a game of tic tac toe in ClojureScript. 

## Running

To start a web server for the application, run:

    lein ring server

To automatically compile ClojureScript files as they are saved run this in another terminal:

    lein cljsbuild auto

To start a REPL that let's you interact with the browser:

    lein trampoline cljsbuild repl-listen

You'll need to refresh the web browser after starting the repl. The REPL listens on port 9000. When the browser loads the page it connects to the REPL. 

## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen
