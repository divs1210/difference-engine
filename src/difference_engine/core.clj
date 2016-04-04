(ns difference-engine.core)

(defn ^:private diffs
  "(diffs [1 4 9]) => (3 5)"
  [coll]
  (map - (rest coll) coll))


(defn ^:private triangle
  "(triangle [1 4 9]) => ((1 4 9) (3 5) (2))"
  [pattern]
  (take (count pattern)
        (iterate diffs pattern)))


(defn infer
  "(infer [1 4 9]) => (1 4 9 16 25 ...)"
  [pattern]
  (->> (triangle pattern)
       (map last) reverse
       (drop-while zero?)
       (iterate #(reductions + %))
       (map last) rest
       (concat pattern)))


(defn infer-n
  "(infer-n 5 [1 4 9]) => (1 4 9 16 25)"
  [n pattern]
  (take n (infer pattern)))
