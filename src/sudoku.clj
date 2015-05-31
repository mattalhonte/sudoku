(ns sudoku
  (:require [clojure.set :as set]))

(def board identity)

(def all-values #{1 2 3 4 5 6 7 8 9})

(defn value-at [board coord]
  (get-in board coord))

(defn has-value? [board coord]
  (not (zero? (value-at board coord))))

(defn row-values [board coord]
  (let [[row col] coord]
    (set (get board row))))

(defn col-values [board coord]
  (let [[row col] coord
        get-col-val (fn [x] (get-in board [x col]))]
    (set (map get-col-val (range (count board))))))

(defn coord-pairs
  ([coords]
   (vec (for [row coords
         col coords]
          [row col])))
  ([coords1 coords2]
   (vec (for [row coords1
              col coords2]
          [row col]))))

(defn block-values [board coord]
  (let [first [0 1 2]
        mid [3 4 5]
        last [6 7 8]
        my-combos  (vec (for [rowvals [first mid last]
                        colvals [first mid last]]
                          [rowvals colvals]))
        my-blocks (map
                   (fn [x]
                         (set (coord-pairs (get x 0) (get x 1))))
                   my-combos)
        contains-my-coords (filter (fn [x] (contains? x coord)) my-blocks)]
    (set (map (fn [x] (value-at board x)) (get (vec contains-my-coords) 0)))))


(defn valid-values-for [board coord]
  (if (zero? (value-at board coord))
    (set/difference all-values
                    (set/union (row-values board coord)
                               (col-values board coord)
                               (block-values board coord)))
    #{}))

(defn filled? [board]
  (let [board-seq (apply concat board)
        board-set (set board-seq)]
    (not (contains? board-set 0))))

(defn rows [board]
  (let [my-coords (for [my-val (range 9)]
                    [my-val 0])]
    (vec (map (fn [x] (row-values board x)) my-coords))))

(defn valid-rows? [board]
  (not
   (contains?
    (set (map (fn [x] (= all-values x)) (rows board)))
    false)))

(defn cols [board]
   (let [my-coords (for [my-val (range 9)]
                    [0 my-val])]
    (vec (map (fn [x] (col-values board x)) my-coords))))

(defn valid-cols? [board]
  (not
   (contains?
    (set (map (fn [x] (= all-values x)) (cols board)))
    false)))

(defn blocks [board]
  (let [my-coords (coord-pairs [0 3 6])]
    (map (fn [x] (block-values board x)) my-coords)))

(defn valid-blocks? [board]
  (not
   (contains?
    (set (map (fn [x] (= all-values x)) (blocks board)))
    false)))

(defn valid-solution? [board]
  (and
   (valid-rows? board)
   (valid-cols? board)
   (valid-blocks? board)))

(defn set-value-at [board coord new-value]
 (assoc-in board coord new-value))

(defn find-empty-point [board]
  (if (not (filled? board))
    (let [my-coords (coord-pairs (range 9))]
      (first (filter (fn [x] (= (value-at board x) 0)) my-coords)))))

(defn sudoku-solve-helper [board]
  (if (filled? board)
   (if (valid-solution? board)
     [board]
     nil)
     (let [empty-point (find-empty-point board)]
       (for [possible-val (valid-values-for board empty-point)
             new-board (set-value-at board empty-point possible-val)
             solution (remove empty? (sudoku-solve-helper new-board))]
        solution))))

  
(defn solve [board]
  (first (sudoku-solve-helper board)))

          
(defn sudoku-solve-helper [board]
  (if (filled? board)
   (if (valid-solution? board)
     [board]
     nil)
     (let [empty-point (find-empty-point board)]
       (for [possible-val (valid-values-for board empty-point)
             solution (remove empty?
                              (sudoku-solve-helper (set-value-at board empty-point possible-val)))]
        solution))))

  
(defn solve [board]
  (first (sudoku-solve-helper board)))

