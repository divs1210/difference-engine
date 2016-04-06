(ns difference-engine.core)

(defn ^:private diffs
  "Returns a lazy sequence of partial differences of coll.

   (diffs [1 4 9]) => (3 5)"
  [coll]
  (map - (rest coll) coll))


(defn ^:private triangle
  "Returns a lazy sequence of subsequent partial
   differences of pattern.

   (triangle [1 4 9]) => ((1 4 9) (3 5) (2))"
  [pattern]
  (take (count pattern)
        (iterate diffs pattern)))


(defn infer
  "Returns a lazy sequence of zeroes of the least
   degree polynomial function inferred from pattern.
   To infinity by default, n if supplied.

   (infer [1 4 9]) => (1 4 9 16 25 ...)
   (infer 5 [1 4 9]) => (1 4 9 16 25)"
  ([pattern]
   (->> (triangle pattern)
        (map last) reverse
        (drop-while zero?)
        (iterate #(reductions + %))
        (map last) rest
        (concat pattern)))
  ([n pattern]
   (take n (infer pattern))))
