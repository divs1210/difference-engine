(ns difference-engine.core-test
  (:require [clojure.test :refer :all]
            [difference-engine.core :refer :all]))

(deftest all-tests
  (testing "+ve ints"
    (is (= (infer 10 [1 2])
           (range 1 11))))

  (testing "-ve ints"
    (is (= (infer 10 [-1 -2])
           (range -1 -11 -1))))

  (testing "ratios"
    (is (= (infer 5 [1/8 2/8])
           [1/8 2/8 3/8 4/8 5/8])))

  (testing "doubles"
    (is (= (infer 4 [0 0.25])
           (range 0 1 0.25))))

  (testing "squares"
    (is (= (infer 10 [1 4 9])
           (map #(* % %) (range 1 11))))))
