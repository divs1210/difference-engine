# Difference Engine

Charles Babbage's [Difference Engine](https://en.wikipedia.org/wiki/Difference_engine) for Clojure.
An alternative to `range`, `infer` returns a lazy sequence of zeroes of the least degree polynomial function inferred from pattern.

[Here](http://stackoverflow.com/questions/21503344/implementing-sequence-inference-in-clojure-using-method-of-differences)'s a short history of its evolution.

## Leiningen
`[difference-engine "0.1.0-SNAPSHOT"]`


## Usage

```clojure
(require '[difference-engine.core :refer [infer]])


(infer [1 2]) ;=> (1 2 3 4 5 ...)

(infer [100 90]) ;=> (100 90 80 70 60 ...)

(infer [1 4 9]) ;=> (1 4 9 16 25 ...)


(infer 5 [20 15]) ;=> (20 15 10 5 0)
```

## License

Distributed under the Eclipse Public License.
