(ns koans.12-sequence-comprehensions
  (:require [koan-engine.core :refer :all]))

(meditations
  "Sequence comprehensions can bind each element in turn to a symbol"
  (= '(0 1 2 3 4 5)
     (for [x (range 6)]
       x))

  "They can easily emulate mapping"
  (= '(0 1 4 9 16 25)
     (map (fn [x] (* x x)) (range 6))
     (for [x (range 6)] (* x x)))

  "And also filtering"
  (= '(1 3 5 7 9)
     (filter odd? (range 10))
     (for [x (range 10) :when (odd? x)] x))

  "Combinations of these transformations is trivial"
  (= '(1 9 25 49 81)
     (map (fn [x] (* x x)) (filter odd? (range 10)))
     (for [x (range 10) :when (odd? x)] (* x x)))

  "More complex transformations simply take multiple binding forms"
  (= [[:top    :left] [:top    :middle] [:top    :right]
      [:middle :left] [:middle :middle] [:middle :right]
      [:bottom :left] [:bottom :middle] [:bottom :right]]
     (for
       [row    [:top  :middle :bottom]
        column [:left :middle :right]]
       (vec [row column]))))


; Project Euler 1
;(reduce + (for [x (range 1000) :when (or (zero? (mod x 3))(= 0 (mod x 5)))] x))

;(def triangle [[75]
;               [95 64]
;               [17 47 82]
;               [18 35 87 10]
;               [20 4 82 47 65]
;               [19 1 23 75 3 34]
;               [88 2 77 73 7 63 67]
;               [99 65 4 28 6 16 70 92]
;               [41 41 26 56 83 40 80 70 33]
;               [41 48 72 33 47 32 37 16 94 29]
;               [53 71 44 65 25 43 91 52 97 51 14]
;               [70 11 33 28 77 73 17 78 39 68 17 57]
;               [91 71 52 38 17 14 91 43 58 50 27 29 48]
;               [63 66 4 68 89 53 67 30 73 16 69 87 40 31]
;               [4 62 98 27 23 9 70 98 73 93 38 53 60 4 23]])

;(reduce + (map #(->
;                  %
;                  sort
;                  last)
;               triangle))

