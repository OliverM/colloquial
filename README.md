# colloquial

A series of [Quil](http://quil.info) sketches re-implementing the [Processing](https://processing.org) examples and techniques presented in [Generative Design](http://www.generative-gestaltung.de), a wonderful book by Hartmut Bohnacker, Benedikt Groß, Julia Laub, & Claudius Lazzeroni. 

I'm working through some of the examples, re-implementing them in Clojure, trying to apply a functional approach rather than the imperative one they (very successfully) deploy. The first step in doing this is to use the [Quil](http://quil.info) environment, a Clojure wrapper over Processing (and a Clojurescript wrapper over [processing.js](http://processingjs.org), the javascript implementation). [Quil offers a 'fun-mode' approach](https://github.com/quil/quil/wiki/Functional-mode-%28fun-mode%29) where shared state is threaded & updated through the setup, draw, and event-handler functions, meaning you can keep the functions themselves pure.

## Usage

I'm presenting these examples at a Clojure meetup, so to facilitate that the files are arranged slightly differently than you might expect. Most sketches are found in namespaces named after the section of the Generative Design book they're drawn from; e.g. colloquial.p121 refers to section P.1.2.1 of the text.

Some namespaces have an imperative version followed by a functional version, for my interpretation of 'functional' - I'm sure these could be improved, suggestions/pull-requests welcome!

To run the examples, there are two simple steps:

1. load the colloquial.core namespace at the REPL
2. The core namespace has a series of `(comment ...)` commands for each section and implementation; send the line to the repl to launch that example.

## License

Copyright © 2016-2023 Oliver Mooney, and the original authors.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
