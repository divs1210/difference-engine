# Difference Engine

Charles Babbage's [Difference Engine](https://en.wikipedia.org/wiki/Difference_engine) for Clojure.

## Usage

```clojure
(require '[difference-engine :refer :all])


(infer [1 2]) ;=> (1 2 3 4 5 ...)

(infer [100 90]) ;=> (100 90 80 70 60 ...)

(infer [1 4 9]) ;=> (1 4 9 16 25 ...)


(infer-n 5 [20 15]) ;=> (20 15 10 5 0)
```

## License

Distributed under the Eclipse Public License.
