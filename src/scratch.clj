 0.2.7)
user> -(board [[5 3 0 0 7 0 0 0 0]
        [6 0 0 1 9 5 0 0 0]
        [0 9 8 0 0 0 0 6 0]
        [8 0 0 0 6 0 0 0 3]
        [4 0 0 8 0 3 0 0 1]
        [7 0 0 0 2 0 0 0 6]
        [0 6 0 0 0 0 2 8 0]
        [0 0 0 4 1 9 0 0 5]
        [0 0 0 0 8 0 0 7 9]])
#<core$_ clojure.core$_@12a52103>CompilerException java.lang.RuntimeException: Unable to resolve symbol: board in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:1:2) 
user> (def board identity)
#'user/board
user> (def all-values ${1 2 3 4 5 6 7 8 9})
RuntimeException Map literal must contain an even number of forms  clojure.lang.Util.runtimeException (Util.java:219)
RuntimeException Unmatched delimiter: )  clojure.lang.Util.runtimeException (Util.java:219)
user> (def all-values #{1 2 3 4 5 6 7 8 9})
#'user/all-values
user> (get (get [["a" "b"] ["c" "d"]] 0) 1) 
"b"
user> (get-in [["a" "b"] ["c" "d"]] [0 1])
"b"
user> (def cities {:title "The City and the City"
                   :author {:name "China Miéville"
                            :birth-year 1972}})
#'user/cities
user> (get-in cities [:author :name])
"China Miéville"
user> (def sudoku-board
  (board [[5 3 0 0 7 0 0 0 0]
          [6 0 0 1 9 5 0 0 0]
          [0 9 8 0 0 0 0 6 0]
          [8 0 0 0 6 0 0 0 3]
          [4 0 0 8 0 3 0 0 1]
          [7 0 0 0 2 0 0 0 6]
          [0 6 0 0 0 0 2 8 0]
          [0 0 0 4 1 9 0 0 5]
          [0 0 0 0 8 0 0 7 9]]))
#'user/sudoku-board
user> (def solved-board
  (board [[5 3 4 6 7 8 9 1 2]
          [6 7 2 1 9 5 3 4 8]
          [1 9 8 3 4 2 5 6 7]
          [8 5 9 7 6 1 4 2 3]
          [4 2 6 8 5 3 7 9 1]
          [7 1 3 9 2 4 8 5 6]
          [9 6 1 5 3 7 2 8 4]
          [2 8 7 4 1 9 6 3 5]
          [3 4 5 2 8 6 1 7 9]]))
#'user/solved-board
user> (defn value-at [board coord]
  (get-in board coord))
#'user/value-at
user> (value-at sudoku-board [0 1])
3
user> (value-at sudoku-board [0 0])
5
user> (if (value-at sudoku-board [55 55]) 
        "Cool"
        "Lame")
"Lame"
user> (boolean (value-at sudolu-board [55 55]))
CompilerException java.lang.RuntimeException: Unable to resolve symbol: sudolu-board in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:1:10) 
user> (boolean (value-at sudoku-board [55 55]))
false
user> (defn has-value? [board coord]
  (boolean (value-at board coord)))
#'user/has-value?
user> (has-value? sudoku-board [0 0])
true
user> (has-value? sudoku-board [0 2])
true
user> (not (zero? (get-value sudoku-board [0 2])))
CompilerException java.lang.RuntimeException: Unable to resolve symbol: get-value in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:1:13) 
user> (not (zero? (value-at sudoku-board [0 2])))
false
user> (not (zero? (value-at sudoku-board [0 0])))
true
user> (not (zero? (value-at sudoku-board [0 0])))

true
user> (defn has-value? [board coord]
  (not (zero? (value-at board coord))))
#'user/has-value?
user> (has-value? sudoku-board [0 2])
false
user> (get sudoku-board 0)
[5 3 0 0 7 0 0 0 0]
user> (defn row-values [board coord]
  (let [[row col] coord]
    (set (get board row))))
#'user/row-values
user> (row-values sudoku-board [0 2])
#{0 3 5 7}
user> (row-values sudoku-board [3 2])
#{0 3 6 8}
user> (row-values sudoku-board [4 8])
#{0 1 3 4 8}
user> (defn col-values [board coord]
  (let [[row col] coord]
    (set (get board col))))
#'user/col-values
user> (col-values sudoku-board [0 2])
#{0 6 8 9}
user> (col-values sudoku-board [4 8])
#{0 7 8 9}
user> (count sudoku-board)
9
user> (range (count sudoku-board))
(0 1 2 3 4 5 6 7 8)
user> (defn col-values [board coord]
  (let [[row col] coord
        get-col-val (fn [x] (get-in board [x col)))]
    (set (map get-col-val (range (count board))))))
RuntimeException Unmatched delimiter: )  clojure.lang.Util.runtimeException (Util.java:219)
RuntimeException Unmatched delimiter: )  clojure.lang.Util.runtimeException (Util.java:219)
RuntimeException Unmatched delimiter: )  clojure.lang.Util.runtimeException (Util.java:219)
RuntimeException Unmatched delimiter: ]  clojure.lang.Util.runtimeException (Util.java:219)
CompilerException java.lang.RuntimeException: Unable to resolve symbol: get-col-val in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:4:10) 
RuntimeException Unmatched delimiter: )  clojure.lang.Util.runtimeException (Util.java:219)
RuntimeException Unmatched delimiter: )  clojure.lang.Util.runtimeException (Util.java:219)
user> (defn col-values [board coord]
  (let [[row col] coord
        get-col-val (fn [x] (get-in board [x col]))]
    (set (map get-col-val (range (count board))))))
#'user/col-values
user> (col-values sudoku-board [0 2])
#{0 8}
user> (col-values sudoku-board [4 8])
#{0 1 3 5 6 9}
user> (for [number [1 2 3]]
        (+ number 2))
(3 4 5)
user> (for [name ["John" "Jane"]
            number [1 2 3]]
        (str name " " number))
("John 1" "John 2" "John 3" "Jane 1" "Jane 2" "Jane 3")
user> (for [my-row [0 1]
            my-col [0 1]]
        [row col])
CompilerException java.lang.RuntimeException: Unable to resolve symbol: row in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:1:1) 
user> (for [my-row [0 1]
            my-col [0 1]]
        [my-row my-col])
([0 0] [0 1] [1 0] [1 1])
user> (defn coord-pairs [coords]
  (for [row coords
        col coords]
    [row col]))
#'user/coord-pairs
user> (coord-pairs [0 1])
([0 0] [0 1] [1 0] [1 1])
user> (coord-paies [0 1 2])
CompilerException java.lang.RuntimeException: Unable to resolve symbol: coord-paies in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:1:1) 
user> (coord-pairs [0 1 2])
([0 0] [0 1] [0 2] [1 0] [1 1] [1 2] [2 0] [2 1] [2 2])
user> (defn block-values [board coord]
  (set (map (fn [x] (value-at board x)) (coord-pairs board coord))))
#'user/block-values
user> (block-values sudoku-board [0 2])
ArityException Wrong number of args (2) passed to: user$coord-pairs  clojure.lang.AFn.throwArity (AFn.java:437)
user> (defn block-values [board coord]
  (set (map (fn [x] (value-at board x)) (coord-pairs coord))))
#'user/block-values
user> (block-values sudoku-board [0 2])
#{0 5 8}
user> (coord-paies [0 2])
CompilerException java.lang.RuntimeException: Unable to resolve symbol: coord-paies in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:1:1) 
user> (coord-pairs [0 2])
([0 0] [0 2] [2 0] [2 2])
user> (defn block-values [board coord]
  (set (map (fn [x] (value-at board x)) (coord-pairs (range coord)))))
#'user/block-values
user> (coord-pairs [0 2])
([0 0] [0 2] [2 0] [2 2])
user> (block-values sudoku-board [0 2])
ClassCastException clojure.lang.PersistentVector cannot be cast to java.lang.Number  clojure.lang.Numbers.lt (Numbers.java:219)
user> (last [5 4 98])
98
user> (defn block-values [board coord]
  (set (map (fn [x] (value-at board x)) (coord-pairs (range (first coord) (last coord))))))
#'user/block-values
user> (block-values sudoku-board [0 2])
#{0 3 5 6}
user> (range 0 2)
(0 1)
user> (defn block-values [board coord]
  (set (map (fn [x] (value-at board x)) (coord-pairs (range (first coord) (inc(last coord)))))))
#'user/block-values
user> (range 0 2)
(0 1)
user> (block-values sudoku-board [0 2])
#{0 3 5 6 8 9}
user> (block-values sudoku-board [4 5])
#{0 2 3}
user> (range 4 6)
(4 5)
user> (coord-pairs [4 5])
([4 4] [4 5] [5 4] [5 5])
user> (let (blocks [:name "top-left" :vals (coord-pairs [0 1 2])]))
IllegalArgumentException let requires a vector for its binding in user:1  clojure.core/let (core.clj:4043)
user> (let (blocks [{:name "top-left" :vals (coord-pairs [0 1 2])}]))
IllegalArgumentException let requires a vector for its binding in user:1  clojure.core/let (core.clj:4043)
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}])
nil
user> (:vals block)
CompilerException java.lang.RuntimeException: Unable to resolve symbol: block in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:1:1) 
user> (:vals blocks)
CompilerException java.lang.RuntimeException: Unable to resolve symbol: blocks in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:1:1) 
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}])
nil
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}]
        (:vals blocks))
([0 0] [0 1] [0 2] [1 0] [1 1] [1 2] [2 0] [2 1] [2 2])
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}]
        (contains? (:vals blocks) [0 1]))
IllegalArgumentException contains? not supported on type: clojure.lang.LazySeq  clojure.lang.RT.contains (RT.java:724)
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}]
        (contains? ((:vals blocks) 0) [0 1]))
ClassCastException clojure.lang.LazySeq cannot be cast to clojure.lang.IFn  user/eval7831 (form-init6817878719200816348.clj:2)
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}]
        (contains? ((:vals blocks) first) [0 1]))
ClassCastException clojure.lang.LazySeq cannot be cast to clojure.lang.IFn  user/eval7833 (form-init6817878719200816348.clj:2)
user> (coord-pairs [4 5])
([4 4] [4 5] [5 4] [5 5])
user> (coord-pairs [4 5] 0)
ArityException Wrong number of args (2) passed to: user$coord-pairs  clojure.lang.AFn.throwArity (AFn.java:437)
user> (defn coord-pairs [coords]
  (for [row coords
        col coords]
    (vec [row col])))
#'user/coord-pairs
user> (coord-pairs [4 5] 0)
ArityException Wrong number of args (2) passed to: user$coord-pairs  clojure.lang.AFn.throwArity (AFn.java:437)
user> (coord-pairs [4 5])
([4 4] [4 5] [5 4] [5 5])
user> (vec (coord-pairs [4 5]))
[[4 4] [4 5] [5 4] [5 5]]
user> (defn coord-pairs [coords]
  (vec (for [row coords
        col coords]
    [row col])))
#'user/coord-pairs
user> (coord-pairs [4 5])
[[4 4] [4 5] [5 4] [5 5]]
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}]
        (contains? ((:vals blocks) first) [0 1]))
IllegalArgumentException Key must be integer  clojure.lang.APersistentVector.invoke (APersistentVector.java:265)
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}]
        (contains? (:vals blocks) [0 1]))
false
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}])
nil
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}]
        (:vals blocks))
[[0 0] [0 1] [0 2] [1 0] [1 1] [1 2] [2 0] [2 1] [2 2]]
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}]
        (first (:vals blocks)))
[0 0]
user> (identity 1)
1
user> (contains? [1 5 8] 8)
false
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}]
        (contains? (:vals blocks) [0 0]))
false
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}]
        (first (:vals blocks)))
[0 0]
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}]
        (some [0 0] (:vals blocks)))
IllegalArgumentException Key must be integer  clojure.lang.APersistentVector.invoke (APersistentVector.java:265)
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}]
        (contains? (set (:vals blocks)) [0 0]))
true
user> (coord-pairs [[0 1 2] [3 4 5]])
[[[0 1 2] [0 1 2]] [[0 1 2] [3 4 5]] [[3 4 5] [0 1 2]] [[3 4 5] [3 4 5]]]
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}]
        (:vals blocks))
[[0 0] [0 1] [0 2] [1 0] [1 1] [1 2] [2 0] [2 1] [2 2]]
user> (let [blocks {:name "top-left" :vals (coord-pairs [0 1 2])}]
        (map 
         (fn [x] 
           (let [[my-first my-sec] x]
             [(+ 3 my-first) my-sec]))
             (:vals blocks)))
([3 0] [3 1] [3 2] [4 0] [4 1] [4 2] [5 0] [5 1] [5 2])
user> ((fn [coords1 coords2]
         (vec (for [row coords1
                    col coords2]
                [row col]))) [[0 1 2] [6 7 8]])
ArityException Wrong number of args (1) passed to: user$eval7928$fn  clojure.lang.AFn.throwArity (AFn.java:437)
user> ((fn [coords1 coords2]
         (vec (for [row coords1
                    col coords2]
                [row col]))) [0 1 2] [6 7 8])
[[0 6] [0 7] [0 8] [1 6] [1 7] [1 8] [2 6] [2 7] [2 8]]
user> (defn coord-pairs
  ([coords]
   (vec (for [row coords
         col coords]
          [row col])))
  ([coords1 coords2]
   (vec (for [row coords1
              col coords2]
          [row col]))))
#'user/coord-pairs
user> (coord-pairs [0 1])
[[0 0] [0 1] [1 0] [1 1]]
user> (coord-pairs [0 1 2] [6 7 8])
[[0 6] [0 7] [0 8] [1 6] [1 7] [1 8] [2 6] [2 7] [2 8]]
user> (set (coord-pairs [0 1 2] [6 7 8]))
#{[2 6] [2 7] [1 6] [2 8] [0 6] [1 7] [0 7] [1 8] [0 8]}
user>   (coord-pairs [[0 1 2] [3 4 5] [6 7 8]])
[[[0 1 2] [0 1 2]] [[0 1 2] [3 4 5]] [[0 1 2] [6 7 8]] [[3 4 5] [0 1 2]] [[3 4 5] [3 4 5]] [[3 4 5] [6 7 8]] [[6 7 8] [0 1 2]] [[6 7 8] [3 4 5]] [[6 7 8] [6 7 8]]]
user> (let [first [0 1 2]
        mid [3 4 5]
        last [6 7 8]]
            (vec (for [rowvals [first mid last]
                       colvals [first mid last]]
                       [rowvals colvals])))
[[[0 1 2] [0 1 2]] [[0 1 2] [3 4 5]] [[0 1 2] [6 7 8]] [[3 4 5] [0 1 2]] [[3 4 5] [3 4 5]] [[3 4 5] [6 7 8]] [[6 7 8] [0 1 2]] [[6 7 8] [3 4 5]] [[6 7 8] [6 7 8]]]
user> (def my-val-combos (let [first [0 1 2]
        mid [3 4 5]
        last [6 7 8]]
            (vec (for [rowvals [first mid last]
                       colvals [first mid last]]
                       [rowvals colvals]))))
#'user/my-val-combos
user> (map coord-pairs my-val-combos)
([[[0 1 2] [0 1 2]] [[0 1 2] [0 1 2]] [[0 1 2] [0 1 2]] [[0 1 2] [0 1 2]]] [[[0 1 2] [0 1 2]] [[0 1 2] [3 4 5]] [[3 4 5] [0 1 2]] [[3 4 5] [3 4 5]]] [[[0 1 2] [0 1 2]] [[0 1 2] [6 7 8]] [[6 7 8] [0 1 2]] [[6 7 8] [6 7 8]]] [[[3 4 5] [3 4 5]] [[3 4 5] [0 1 2]] [[0 1 2] [3 4 5]] [[0 1 2] [0 1 2]]] [[[3 4 5] [3 4 5]] [[3 4 5] [3 4 5]] [[3 4 5] [3 4 5]] [[3 4 5] [3 4 5]]] [[[3 4 5] [3 4 5]] [[3 4 5] [6 7 8]] [[6 7 8] [3 4 5]] [[6 7 8] [6 7 8]]] [[[6 7 8] [6 7 8]] [[6 7 8] [0 1 2]] [[0 1 2] [6 7 8]] [[0 1 2] [0 1 2]]] [[[6 7 8] [6 7 8]] [[6 7 8] [3 4 5]] [[3 4 5] [6 7 8]] [[3 4 5] [3 4 5]]] [[[6 7 8] [6 7 8]] [[6 7 8] [6 7 8]] [[6 7 8] [6 7 8]] [[6 7 8] [6 7 8]]])
user> (first my-val-combos)
[[0 1 2] [0 1 2]]
user> (def my-val-combos (let [first [0 1 2]
        mid [3 4 5]
        last [6 7 8]]
            (vec (for [rowvals [first mid last]
                       colvals [first mid last]]
                       rowvals colvals))))
CompilerException clojure.lang.ArityException: Wrong number of args (3) passed to: core$for, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:4:18) 
user> (set (map coord-pairs my-val-combos))
#{[[[3 4 5] [3 4 5]] [[3 4 5] [3 4 5]] [[3 4 5] [3 4 5]] [[3 4 5] [3 4 5]]] [[[6 7 8] [6 7 8]] [[6 7 8] [6 7 8]] [[6 7 8] [6 7 8]] [[6 7 8] [6 7 8]]] [[[0 1 2] [0 1 2]] [[0 1 2] [0 1 2]] [[0 1 2] [0 1 2]] [[0 1 2] [0 1 2]]] [[[0 1 2] [0 1 2]] [[0 1 2] [3 4 5]] [[3 4 5] [0 1 2]] [[3 4 5] [3 4 5]]] [[[3 4 5] [3 4 5]] [[3 4 5] [6 7 8]] [[6 7 8] [3 4 5]] [[6 7 8] [6 7 8]]] [[[0 1 2] [0 1 2]] [[0 1 2] [6 7 8]] [[6 7 8] [0 1 2]] [[6 7 8] [6 7 8]]] [[[6 7 8] [6 7 8]] [[6 7 8] [0 1 2]] [[0 1 2] [6 7 8]] [[0 1 2] [0 1 2]]] [[[3 4 5] [3 4 5]] [[3 4 5] [0 1 2]] [[0 1 2] [3 4 5]] [[0 1 2] [0 1 2]]] [[[6 7 8] [6 7 8]] [[6 7 8] [3 4 5]] [[3 4 5] [6 7 8]] [[3 4 5] [3 4 5]]]}
user> (first (first my-val-combos))
[0 1 2]
user> (map first my-val-combos)
([0 1 2] [0 1 2] [0 1 2] [3 4 5] [3 4 5] [3 4 5] [6 7 8] [6 7 8] [6 7 8])
user> (get (first my-val-combos) 0)
[0 1 2]
user> (coord-pairs (get (first my-val-combos) 0) (get (first-my-val combos) 1))
CompilerException java.lang.RuntimeException: Unable to resolve symbol: first-my-val in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:1:49) 
user> (coord-pairs (get (first my-val-combos) 0) (get (first my-val combos) 1))
CompilerException java.lang.RuntimeException: Unable to resolve symbol: my-val in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:1:49) 
user> (coord-pairs (get (first my-val-combos) 0) (get (first my-val-combos) 1))
[[0 0] [0 1] [0 2] [1 0] [1 1] [1 2] [2 0] [2 1] [2 2]]
user> (map (fn [x] (coord-pairs (get x 0) (get x 1))) my-val-combos)
([[0 0] [0 1] [0 2] [1 0] [1 1] [1 2] [2 0] [2 1] [2 2]] [[0 3] [0 4] [0 5] [1 3] [1 4] [1 5] [2 3] [2 4] [2 5]] [[0 6] [0 7] [0 8] [1 6] [1 7] [1 8] [2 6] [2 7] [2 8]] [[3 0] [3 1] [3 2] [4 0] [4 1] [4 2] [5 0] [5 1] [5 2]] [[3 3] [3 4] [3 5] [4 3] [4 4] [4 5] [5 3] [5 4] [5 5]] [[3 6] [3 7] [3 8] [4 6] [4 7] [4 8] [5 6] [5 7] [5 8]] [[6 0] [6 1] [6 2] [7 0] [7 1] [7 2] [8 0] [8 1] [8 2]] [[6 3] [6 4] [6 5] [7 3] [7 4] [7 5] [8 3] [8 4] [8 5]] [[6 6] [6 7] [6 8] [7 6] [7 7] [7 8] [8 6] [8 7] [8 8]])
user> (first (map (fn [x] (coord-pairs (get x 0) (get x 1))) my-val-combos))
[[0 0] [0 1] [0 2] [1 0] [1 1] [1 2] [2 0] [2 1] [2 2]]
user> (map (fn [x] (set(coord-pairs (get x 0) (get x 1)))) my-val-combos)
(#{[2 1] [1 0] [2 2] [0 0] [1 1] [0 1] [1 2] [0 2] [2 0]} #{[2 3] [2 4] [1 3] [2 5] [0 3] [1 4] [0 4] [1 5] [0 5]} #{[2 6] [2 7] [1 6] [2 8] [0 6] [1 7] [0 7] [1 8] [0 8]} #{[3 2] [5 0] [4 0] [5 1] [3 0] [4 1] [5 2] [3 1] [4 2]} #{[4 3] [5 4] [3 3] [4 4] [5 5] [3 4] [4 5] [3 5] [5 3]} #{[5 6] [4 6] [5 7] [3 6] [4 7] [5 8] [3 7] [4 8] [3 8]} #{[8 0] [7 0] [8 1] [6 0] [7 1] [8 2] [6 1] [7 2] [6 2]} #{[6 5] [8 3] [7 3] [8 4] [6 3] [7 4] [8 5] [6 4] [7 5]} #{[7 6] [8 7] [6 6] [7 7] [8 8] [6 7] [7 8] [6 8] [8 6]})
user> (def my-block-vals (map (fn [x] (set(coord-pairs (get x 0) (get x 1)))) my-val-combos))
#'user/my-block-vals
user> (filter (fn [x] (contains? x [0 1])) my-block-vals)
(#{[2 1] [1 0] [2 2] [0 0] [1 1] [0 1] [1 2] [0 2] [2 0]})
user> (map value-at (filter (fn [x] (contains? x [0 1])) my-block-vals))
ArityException Wrong number of args (1) passed to: user$value-at  clojure.lang.AFn.throwArity (AFn.java:437)
user> (map (fn [y] (value-at (vec y))) (filter (fn [x] (contains? x [0 1])) my-block-vals))
ArityException Wrong number of args (1) passed to: user$value-at  clojure.lang.AFn.throwArity (AFn.java:437)
user> (map (fn [y] (value-at sudoku-board (vec y))) (filter (fn [x] (contains? x [0 1])) my-block-vals))
(nil)
user> (map value-at sudoku-board (filter (fn [x] (contains? x [0 1])) my-block-vals))
(nil)
user> (map (fn [y] (value-at sudoku-board y)) (filter (fn [x] (contains? x [0 1])) my-block-vals))
(nil)
user> my-block-vals
(#{[2 1] [1 0] [2 2] [0 0] [1 1] [0 1] [1 2] [0 2] [2 0]} #{[2 3] [2 4] [1 3] [2 5] [0 3] [1 4] [0 4] [1 5] [0 5]} #{[2 6] [2 7] [1 6] [2 8] [0 6] [1 7] [0 7] [1 8] [0 8]} #{[3 2] [5 0] [4 0] [5 1] [3 0] [4 1] [5 2] [3 1] [4 2]} #{[4 3] [5 4] [3 3] [4 4] [5 5] [3 4] [4 5] [3 5] [5 3]} #{[5 6] [4 6] [5 7] [3 6] [4 7] [5 8] [3 7] [4 8] [3 8]} #{[8 0] [7 0] [8 1] [6 0] [7 1] [8 2] [6 1] [7 2] [6 2]} #{[6 5] [8 3] [7 3] [8 4] [6 3] [7 4] [8 5] [6 4] [7 5]} #{[7 6] [8 7] [6 6] [7 7] [8 8] [6 7] [7 8] [6 8] [8 6]})
user> (def contains-0-0 (filter (fn [x] (contains? x [0 0])) my-block-vals))
#'user/contains-0-0
user> contains-0-0
(#{[2 1] [1 0] [2 2] [0 0] [1 1] [0 1] [1 2] [0 2] [2 0]})
user> (map (fn [x] (value-at sudoku-board x)) contains-0-0)
(nil)
user> (map first contains-0-0)
([2 1])
user> (apply first contains-0-0)
[2 1]
user> (apply first (first contains-0-0))
ArityException Wrong number of args (9) passed to: core$first  clojure.lang.AFn.throwArity (AFn.java:437)
user> (first (first contains-0-0))
[2 1]
user> (first contains-0-0)
#{[2 1] [1 0] [2 2] [0 0] [1 1] [0 1] [1 2] [0 2] [2 0]}
user> (map first (first contains-0-0))
(2 1 2 0 1 0 1 0 2)
user> (map (fn [x] (value-at sudoku-board x)) (first contains-0-0))
(9 6 8 5 0 3 0 0 0)
user> (set (map (fn [x] (value-at sudoku-board x)) (first contains-0-0)))
#{0 3 5 6 8 9}
user> (defn block-values [board coord]
  (let [first [0 1 2]
        mid [3 4 5]
        last [6 7 8]
        my-combos  (vec (for [rowvals [first mid last]
                        colvals [first mid last]]
                          [rowvals colvals]))
        my-blocks (map
                   (fn [x]
                         (set(coord-pairs (get x 0) (get x 1))))
                   my-combos)
        contains-my-coords (filter (fn [x] (contains? x coord)) my-blocks)]
    (set (map ((fn [x] (value-at board x)) (first contains-my-coords))))))
#'user/block-values
user> (block-values sudoku-board [0 2])
IllegalArgumentException Key must be integer  clojure.lang.APersistentVector.invoke (APersistentVector.java:265)
user> (defn block-values [board coord]
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
    (set (map ((fn [x] (value-at board x)) (first contains-my-coords))))))
#'user/block-values
user> (block-values sudoku-board [0 2])
IllegalArgumentException Key must be integer  clojure.lang.APersistentVector.invoke (APersistentVector.java:265)
user> (defn block-values [board coord]
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
    ;;(set (map ((fn [x] (value-at board x)) (first contains-my-coords))))
   (inc 1)))
#'user/block-values
user> (block-values sudoku-board [0 2])
2
user> (defn block-values [board coord]
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
    ;;(set (map ((fn [x] (value-at board x)) (first contains-my-coords))))
   my-comboa))
CompilerException java.lang.RuntimeException: Unable to resolve symbol: my-comboa in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:2:3) 
user> (defn block-values [board coord]
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
    ;;(set (map ((fn [x] (value-at board x)) (first contains-my-coords))))
   my-combos))
#'user/block-values
user> (block-values sudoku-board [0 2])
[[[0 1 2] [0 1 2]] [[0 1 2] [3 4 5]] [[0 1 2] [6 7 8]] [[3 4 5] [0 1 2]] [[3 4 5] [3 4 5]] [[3 4 5] [6 7 8]] [[6 7 8] [0 1 2]] [[6 7 8] [3 4 5]] [[6 7 8] [6 7 8]]]
user> (defn block-values [board coord]
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
    ;;(set (map ((fn [x] (value-at board x)) (first contains-my-coords))))
   my-blocks))
#'user/block-values
user> (block-values sudoku-board [0 2])
(#{[2 1] [1 0] [2 2] [0 0] [1 1] [0 1] [1 2] [0 2] [2 0]} #{[2 3] [2 4] [1 3] [2 5] [0 3] [1 4] [0 4] [1 5] [0 5]} #{[2 6] [2 7] [1 6] [2 8] [0 6] [1 7] [0 7] [1 8] [0 8]} #{[3 2] [5 0] [4 0] [5 1] [3 0] [4 1] [5 2] [3 1] [4 2]} #{[4 3] [5 4] [3 3] [4 4] [5 5] [3 4] [4 5] [3 5] [5 3]} #{[5 6] [4 6] [5 7] [3 6] [4 7] [5 8] [3 7] [4 8] [3 8]} #{[8 0] [7 0] [8 1] [6 0] [7 1] [8 2] [6 1] [7 2] [6 2]} #{[6 5] [8 3] [7 3] [8 4] [6 3] [7 4] [8 5] [6 4] [7 5]} #{[7 6] [8 7] [6 6] [7 7] [8 8] [6 7] [7 8] [6 8] [8 6]})
user> (defn block-values [board coord]
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
    ;;(set (map ((fn [x] (value-at board x)) (first contains-my-coords))))
   contains-my-coords))
#'user/block-values
user> (block-values sudoku-board [0 2])
(#{[2 1] [1 0] [2 2] [0 0] [1 1] [0 1] [1 2] [0 2] [2 0]})
user> (defn block-values [board coord]
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
  (map ((fn [x] (value-at board x)) (first contains-my-coords)))))
#'user/block-values
user> (block-values sudoku-board [0 2])
IllegalArgumentException Key must be integer  clojure.lang.APersistentVector.invoke (APersistentVector.java:265)
user> (defn block-values [board coord]
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
  (first contains-my-coords)))
#'user/block-values
user> (block-values sudoku-board [0 2])
IllegalArgumentException Key must be integer  clojure.lang.APersistentVector.invoke (APersistentVector.java:265)
user> (defn block-values [board coord]
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
    (set (map ((fn [x] (value-at board x)) contains-my-coords)))))
#'user/block-values
user> (block-values sudoku-board [0 2])
ArityException Wrong number of args (1) passed to: core$map  clojure.lang.AFn.throwArity (AFn.java:437)
user> (defn block-values [board coord]
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
    (set (map ((fn [x] (value-at board x))) contains-my-coords)))))
#'user/block-valuesRuntimeException Unmatched delimiter: )  clojure.lang.Util.runtimeException (Util.java:219)
user> (defn block-values [board coord]
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
    (set (map ((fn [x] (value-at board x))) contains-my-coords))))
#'user/block-values
user> (block-values sudoku-board [0 2])
ArityException Wrong number of args (0) passed to: user$block-values$fn  clojure.lang.AFn.throwArity (AFn.java:437)
user> (defn block-values [board coord]
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
    (set (map ((fn [x] (value-at board x))) (first contains-my-coords)))))
#'user/block-values
user> (block-values sudoku-board [0 2])
ArityException Wrong number of args (0) passed to: user$block-values$fn  clojure.lang.AFn.throwArity (AFn.java:437)
user> (defn block-values [board coord]
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
    (set board coord)))
#'user/block-values
user> (block-values sudoku-board [0 2])
ArityException Wrong number of args (2) passed to: core$set  clojure.lang.AFn.throwArity (AFn.java:437)
user> (defn block-values [board coord]
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
    (set [board coord])))
#'user/block-values
user> (block-values sudoku-board [0 2])
#{[0 2] [[5 3 0 0 7 0 0 0 0] [6 0 0 1 9 5 0 0 0] [0 9 8 0 0 0 0 6 0] [8 0 0 0 6 0 0 0 3] [4 0 0 8 0 3 0 0 1] [7 0 0 0 2 0 0 0 6] [0 6 0 0 0 0 2 8 0] [0 0 0 4 1 9 0 0 5] [0 0 0 0 8 0 0 7 9]]}
user> (defn block-values [board coord]
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
    (first contains-my-coords)))
#'user/block-values
user> (block-values sudoku-board [0 2])
IllegalArgumentException Key must be integer  clojure.lang.APersistentVector.invoke (APersistentVector.java:265)
user> (defn block-values [board coord]
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
    first contains-my-coords))
#'user/block-values
user> (block-values sudoku-board [0 2])
(#{[2 1] [1 0] [2 2] [0 0] [1 1] [0 1] [1 2] [0 2] [2 0]})
user> (defn block-values [board coord]
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
    contains-my-coords))
#'user/block-values
user> (block-values sudoku-board [0 2])
(#{[2 1] [1 0] [2 2] [0 0] [1 1] [0 1] [1 2] [0 2] [2 0]})
user> (defn block-values [board coord]
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
    (first contains-my-coords)))
#'user/block-values
user> (block-values sudoku-board [0 2])
IllegalArgumentException Key must be integer  clojure.lang.APersistentVector.invoke (APersistentVector.java:265)
user> (defn block-values [board coord]
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
    (get contains-my-coords 0)))
#'user/block-values
user> (block-values sudoku-board [0 2])
nil
user> (type [3 56 8])
clojure.lang.PersistentVector
user> (defn block-values [board coord]
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
    (type contains-my-coords)))
#'user/block-values
user> (type [3 56 8])
clojure.lang.PersistentVector
user> (block-values sudoku-board [0 2])
clojure.lang.LazySeq
user> (defn block-values [board coord]
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
    (take 1 contains-my-coords)))
#'user/block-values
user> (block-values sudoku-board [0 2])
(#{[2 1] [1 0] [2 2] [0 0] [1 1] [0 1] [1 2] [0 2] [2 0]})
user> (defn block-values [board coord]
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
    (vec contains-my-coords)))
#'user/block-values
user> (block-values sudoku-board [0 2])
[#{[2 1] [1 0] [2 2] [0 0] [1 1] [0 1] [1 2] [0 2] [2 0]}]
user> (defn block-values [board coord]
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
    (first (vec contains-my-coords))))
#'user/block-values
user> (block-values sudoku-board [0 2])
IllegalArgumentException Key must be integer  clojure.lang.APersistentVector.invoke (APersistentVector.java:265)
user> (defn block-values [board coord]
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
    (get (vec contains-my-coords) 0)))
#'user/block-values
user> (block-values sudoku-board [0 2])
#{[2 1] [1 0] [2 2] [0 0] [1 1] [0 1] [1 2] [0 2] [2 0]}
user> (defn block-values [board coord]
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
    (set (map ((fn [x] (value-at board x))) (get (vec contains-my-coords) 0)))))
#'user/block-values
user> (block-values sudoku-board [0 2])
ArityException Wrong number of args (0) passed to: user$block-values$fn  clojure.lang.AFn.throwArity (AFn.java:437)
user> (defn block-values [board coord]
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
    (map ((fn [x] (value-at board x))) (get (vec contains-my-coords) 0)))))
#'user/block-valuesRuntimeException Unmatched delimiter: )  clojure.lang.Util.runtimeException (Util.java:219)
user> (defn block-values [board coord]
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
    (map ((fn [x] (value-at board x))) (get (vec contains-my-coords) 0))))
#'user/block-values
user> (block-values sudoku-board [0 2])
ArityException Wrong number of args (0) passed to: user$block-values$fn  clojure.lang.AFn.throwArity (AFn.java:437)
user> (defn block-values [board coord]
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
    (map (fn [x] (get-in board x)) (get (vec contains-my-coords) 0))))
#'user/block-values
user> (defn block-values [board coord]
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
    (map (fn [x] (get-in board x)) (get (vec contains-my-coords) 0))))

#'user/block-values
user> (block-values sudoku-board [0 2])
(9 6 8 5 0 3 0 0 0)
user> (defn block-values [board coord]
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
#'user/block-values
user> (block-values sudoku-board [0 2])
#{0 3 5 6 8 9}
user> (clojure.set/union #{1 2} #{2 3} #{7})
#{1 2 3 7}
user> (clojure.set/difference all-values (clojure.set/union (row-values sudoku-board [0 0]) (col-values sudoku-board [0 0]) (block-values sudoku-board [0 0])))
#{1 2}
user> (ns sudoku
  (:require [clojure.set :as set]))
nil
sudoku> (defn valid-values-for [board coord]
  (if (zero? (value-at board coord))
    (set/difference all-values
                    (set/union (row-values board coord)
                               (col-values board coord)
                               (block-values board coord)))
    #{}))
CompilerException java.lang.RuntimeException: Unable to resolve symbol: value-at in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:2:14) 
sudoku> (def board identity)

(def all-values #{1 2 3 4 5 6 7 8 9})

(defn value-at [board coord]
  (get-in board coord))
#'sudoku/board
#'sudoku/all-values
#'sudoku/value-at
sudoku> (defn value-at [board coord]
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
#'sudoku/value-at
#'sudoku/has-value?
#'sudoku/row-values
#'sudoku/col-values
#'sudoku/coord-pairs
#'sudoku/block-values
#'sudoku/valid-values-for
sudoku> (valid-values-for sudoku-board [0 0])
CompilerException java.lang.RuntimeException: Unable to resolve symbol: sudoku-board in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:1:1) 
sudoku> (def sudoku-board
  (board [[5 3 0 0 7 0 0 0 0]
          [6 0 0 1 9 5 0 0 0]
          [0 9 8 0 0 0 0 6 0]
          [8 0 0 0 6 0 0 0 3]
          [4 0 0 8 0 3 0 0 1]
          [7 0 0 0 2 0 0 0 6]
          [0 6 0 0 0 0 2 8 0]
          [0 0 0 4 1 9 0 0 5]
          [0 0 0 0 8 0 0 7 9]]))

#'sudoku/sudoku-board
sudoku> (valid-values-for sudoku-board [0 0])
#{}
sudoku> (valid-values-for sudoku-board [0 2])
#{1 2 4}
sudoku> board
#<core$identity clojure.core$identity@39cfc0cf>
sudoku> (get board 0)
nil
sudoku> (get sudoku-board 0)
[5 3 0 0 7 0 0 0 0]
sudoku> (apply concat sudoku-board)
(5 3 0 0 7 0 0 0 0 6 0 0 1 9 5 0 0 0 0 9 8 0 0 0 0 6 0 8 0 0 0 6 0 0 0 3 4 0 0 8 0 3 0 0 1 7 0 0 0 2 0 0 0 6 0 6 0 0 0 0 2 8 0 0 0 0 4 1 9 0 0 5 0 0 0 0 8 0 0 7 9)
sudoku> (defn filled? [board]
  (let [board-seq (apply concat board)
        board-set (set board-seq)]
    (contains? board-set 0)))
#'sudoku/filled?
sudoku> (filled? sudoku-board)
true
sudoku> (defn filled? [board]
  (let [board-seq (apply concat board)
        board-set (set board-seq)]
    (not (contains? board-set 0))))
#'sudoku/filled?
sudoku> (filled? sudoku-board)
false
sudoku> (def solved-board
  (board [[5 3 4 6 7 8 9 1 2]
          [6 7 2 1 9 5 3 4 8]
          [1 9 8 3 4 2 5 6 7]
          [8 5 9 7 6 1 4 2 3]
          [4 2 6 8 5 3 7 9 1]
          [7 1 3 9 2 4 8 5 6]
          [9 6 1 5 3 7 2 8 4]
          [2 8 7 4 1 9 6 3 5]
          [3 4 5 2 8 6 1 7 9]]))
#'sudoku/solved-board
sudoku> (filled? solved-board)
true
sudoku> (for [my-val (range 9)]
                  [my-val 0])
([0 0] [1 0] [2 0] [3 0] [4 0] [5 0] [6 0] [7 0] [8 0])
sudoku> (map (fn [x] (row-vals sudoku-board x)) (for [my-val (range 9)]
                                                  [my-val 0]))
CompilerException java.lang.RuntimeException: Unable to resolve symbol: row-vals in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:1:14) 
sudoku> (map (fn [x] (row-values sudoku-board x)) (for [my-val (range 9)]
                                                  [my-val 0]))
(#{0 3 5 7} #{0 1 5 6 9} #{0 6 8 9} #{0 3 6 8} #{0 1 3 4 8} #{0 2 6 7} #{0 2 6 8} #{0 1 4 5 9} #{0 7 8 9})
sudoku> (vec (map (fn [x] (row-values sudoku-board x)) (for [my-val (range 9)]
                                                  [my-val 0])))
[#{0 3 5 7} #{0 1 5 6 9} #{0 6 8 9} #{0 3 6 8} #{0 1 3 4 8} #{0 2 6 7} #{0 2 6 8} #{0 1 4 5 9} #{0 7 8 9}]
sudoku> (defn rows [board]
  (let [my-coords (for [my-vals (range 9)]
                    [my-val 0])]
    (vec (map (fn [x] (row-values board x)) my-coords))))
CompilerException java.lang.RuntimeException: Unable to resolve symbol: my-val in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:2:19) 
sudoku> (defn rows [board]
  (let [my-coords (for [my-val (range 9)]
                    [my-val 0])]
    (vec (map (fn [x] (row-values board x)) my-coords))))
#'sudoku/rows
sudoku> 
(rows sudoku-board)
[#{0 3 5 7} #{0 1 5 6 9} #{0 6 8 9} #{0 3 6 8} #{0 1 3 4 8} #{0 2 6 7} #{0 2 6 8} #{0 1 4 5 9} #{0 7 8 9}]
sudoku> (defn valid-rows? [board]
  (let [my-coords (for [my-val (range 9)]
                    [0 my-val])]
    (vec (map (fn [x] (col-values board x)) my-coords))))
#'sudoku/valid-rows?
sudoku> (cols sudoku-board)
CompilerException java.lang.RuntimeException: Unable to resolve symbol: cols in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:1:1) 
sudoku> (defn cols [board]
   (let [my-coords (for [my-val (range 9)]
                    [0 my-val])]
    (vec (map (fn [x] (col-values board x)) my-coords))))
#'sudoku/cols
sudoku> (cols sudoku-board)
[#{0 4 5 6 7 8} #{0 3 6 9} #{0 8} #{0 1 4 8} #{0 1 2 6 7 8 9} #{0 3 5 9} #{0 2} #{0 6 7 8} #{0 1 3 5 6 9}]
sudoku> (coord-pairs [0 3 6])
[[0 0] [0 3] [0 6] [3 0] [3 3] [3 6] [6 0] [6 3] [6 6]]
sudoku> (map (fn [x] (block-values sudoku-board x)) (coord-pairs [0 3 6]))
(#{0 3 5 6 8 9} #{0 1 5 7 9} #{0 6} #{0 4 7 8} #{0 2 3 6 8} #{0 1 3 6} #{0 6} #{0 1 4 8 9} #{0 2 5 7 8 9})
sudoku> (defn valid-cols? [board]
  (let [my-coords (coord-pairs [0 3 6])]
    (map (fn [x] (block-values board x)) my-coords)))
#'sudoku/valid-cols?
sudoku> (defn blocks [board]
  (let [my-coords (coord-pairs [0 3 6])]
    (map (fn [x] (block-values board x)) my-coords)))
#'sudoku/blocks
sudoku> (map (fn [x] (= all-values x)) (rows sudoku-board))
(false false false false false false false false false)
sudoku> (and (map (fn [x] (= all-values x)) (rows sudoku-board)))
(false false false false false false false false false)
sudoku> (and (vec (map (fn [x] (= all-values x)) (rows sudoku-board))))
[false false false false false false false false false]
sudoku> (set (map (fn [x] (= all-values x)) (rows sudoku-board)))
#{false}
sudoku> (contains? (set (map (fn [x] (= all-values x)) (rows sudoku-board))) false)
true
sudoku> (defn valid-rows? [board]
  (not
   (contains?
    (set (map (fn [x] (= all-values x)) (rows board)))
    false)))

#'sudoku/valid-rows?
sudoku> (valid-rows? invalid-board)
CompilerException java.lang.RuntimeException: Unable to resolve symbol: invalid-board in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:1:1) 
sudoku> (valid-rows? solved-board)
true
sudoku> (defn valid-blocks? [board]
  (not
   (contains?
    (set (map (fn [x] (= all-values x)) (blocks board)))
    false)))
#'sudoku/valid-blocks?
sudoku> (valid-cols? solved-board
                     )
(#{1 2 3 4 5 6 7 8 9} #{1 2 3 4 5 6 7 8 9} #{1 2 3 4 5 6 7 8 9} #{1 2 3 4 5 6 7 8 9} #{1 2 3 4 5 6 7 8 9} #{1 2 3 4 5 6 7 8 9} #{1 2 3 4 5 6 7 8 9} #{1 2 3 4 5 6 7 8 9} #{1 2 3 4 5 6 7 8 9})
sudoku> (defn valid-cols? [board]
  (not
   (contains?
    (set (map (fn [x] (= all-values x)) (cols board)))
    false)))
#'sudoku/valid-cols?
sudoku> (valid-cols? solved-board
                     )
true
sudoku> (valid-blocks? solved-board)
true
sudoku> (and true true true)
true
sudoku> (defn valid-solution? [board]
  (and
   (valid-rows? board)
   (valid-cols? board)
   (valid-blocks? board)))
#'sudoku/valid-solution?
sudoku> (valid-solution? solved-board) 
true
sudoku> (defn set-value-at [board coord new-value]
 (assoc-in board coord new-value))
#'sudoku/set-value-at
sudoku> (def before-change
  (board [[5 3 0 0 7 0 0 0 0]
          [6 0 0 1 9 5 0 0 0]
          [0 9 8 0 0 0 0 6 0]
          [8 0 0 0 6 0 0 0 3]
          [4 0 0 8 0 3 0 0 1]
          [7 0 0 0 2 0 0 0 6]
          [0 6 0 0 0 0 2 8 0]
          [0 0 0 4 1 9 0 0 5]
          [0 0 0 0 8 0 0 7 9]]))
#'sudoku/before-change
sudoku> (set-value-at before-change [2 1] 4)
[[5 3 0 0 7 0 0 0 0] [6 0 0 1 9 5 0 0 0] [0 4 8 0 0 0 0 6 0] [8 0 0 0 6 0 0 0 3] [4 0 0 8 0 3 0 0 1] [7 0 0 0 2 0 0 0 6] [0 6 0 0 0 0 2 8 0] [0 0 0 4 1 9 0 0 5] [0 0 0 0 8 0 0 7 9]]
sudoku> (defn find-empty-point [board]
  (if (not (filled? board))
    (let [my-coords (coord-pairs (range 9))]
      (first (filter (= (value-at board x) 0) my-coords)))))
CompilerException java.lang.RuntimeException: Unable to resolve symbol: x in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:4:25) 
sudoku> (defn find-empty-point [board]
  (if (not (filled? board))
    (let [my-coords (coord-pairs (range 9))]
      (first (filter (fn [x] (= (value-at board x) 0)) my-coords)))))
#'sudoku/find-empty-point
sudoku> (find-empty-point sudoku-board)
[0 2]
sudoku> (sum [1 5 9])
CompilerException java.lang.RuntimeException: Unable to resolve symbol: sum in this context, compiling:(C:\Users\Matt\AppData\Local\Temp\form-init6817878719200816348.clj:1:1) 
sudoku> (defn sum [a-seq]
          (reduce + a-seq))
#'sudoku/sum
sudoku> (defn subset-sum-helper [a-set current-set target]
          (if (= (sum current-set) target)
            [current-set]
            (let [remaining (clojure.set/difference a-set current-set)]
              (for [elem remaining
                    solution (subset-sum-helper a-set
                                                (conj current-set elem)
                                                target)]
                solution))))
#'sudoku/subset-sum-helper
sudoku> (defn subset-sum [a-set target]
          (subset-sum-helper a-set #{} target))
#'sudoku/subset-sum
sudoku> (subset-sum #{1 3 4 10 9 23} 20)
(#{1 9 10} #{1 9 10} #{1 9 10} #{1 9 10} #{1 9 10} #{1 9 10})
sudoku> (defn subset-sum [a-set target]
          (first (subset-sum-helper a-set #{} target)))
#'sudoku/subset-sum
sudoku> (subset-sum #{1 3 4 10 9 23} 20)
#{1 9 10}
sudoku> (defn solve [board]
  (if (valid-solution? board)
    board
    (let [empty-point (find-empty-point board)
          valid-vals (vec (valid-values-for board empty-point))]
      (for [possible-val valid-vals
            new-board (set-value-at board empty-point possible-val)]
        (solve new-board)))))
          
#'sudoku/solve
sudoku> (solve sudoku-board)
IllegalArgumentException Don't know how to create ISeq from: java.lang.Long  clojure.lang.RT.seqFrom (RT.java:505)
sudoku> (defn solve [board]
  (if (filled? board)
   (if (valid-solution? board)
     board
     [])
     (let [empty-point (find-empty-point board)
           valid-vals (vec (valid-values-for board empty-point))]
       (for [possible-val valid-vals
             new-board (set-value-at board empty-point possible-val)]
         (solve new-board)))))
#'sudoku/solve
sudoku> (solve sudoku-board)
IllegalArgumentException Don't know how to create ISeq from: java.lang.Long  clojure.lang.RT.seqFrom (RT.java:505)
sudoku> (defn sudoku-solve-helper [board]
  (if (filled? board)
   (if (valid-solution? board)
     board
     [])
     (let [empty-point (find-empty-point board)
           valid-vals (vec (valid-values-for board empty-point))]
       (for [possible-val valid-vals
             new-board (set-value-at board empty-point possible-val)]
         (sudoku-solve-helper new-board)))))

  
(defn solve [board]
  (sudoku-solve-helper board))
#'sudoku/sudoku-solve-helper
#'sudoku/solve
sudoku> (solve sudoku-board)
IllegalArgumentException Don't know how to create ISeq from: java.lang.Long  clojure.lang.RT.seqFrom (RT.java:505)
sudoku> (defn sudoku-solve-helper [board]
  (if (filled? board)
   (if (valid-solution? board)
     board
     nil)
     (let [empty-point (find-empty-point board)
           valid-vals (vec (valid-values-for board empty-point))]
       (for [possible-val valid-vals
             new-board (set-value-at board empty-point possible-val)]
         (sudoku-solve-helper new-board)))))

  
(defn solve [board]
  (sudoku-solve-helper board))
#'sudoku/sudoku-solve-helper
#'sudoku/solve
sudoku> (solve sudoku-board)
IllegalArgumentException Don't know how to create ISeq from: java.lang.Long  clojure.lang.RT.seqFrom (RT.java:505)
sudoku> (defn sudoku-solve-helper [board]
  (let [empty-point (find-empty-point board)]
    (if (not empty-point)
      (if (valid-solution? board)
        [board]
        nil)
      (for [value (valid-values-for board empty-point)
            solution (remove empty? 
                             (sudoku-solve-helper (set-value-at board empty-point value)))]
        solution))))

(defn solve [board]
  (first (sudoku-solve-helper board)))
#'sudoku/sudoku-solve-helper
#'sudoku/solve
sudoku> (solve sudoku-board)
[[5 3 4 6 7 8 9 1 2] [6 7 2 1 9 5 3 4 8] [1 9 8 3 4 2 5 6 7] [8 5 9 7 6 1 4 2 3] [4 2 6 8 5 3 7 9 1] [7 1 3 9 2 4 8 5 6] [9 6 1 5 3 7 2 8 4] [2 8 7 4 1 9 6 3 5] [3 4 5 2 8 6 1 7 9]]
sudoku> (defn sudoku-solve-helper [board]
  (if (filled? board)
   (if (valid-solution? board)
     [board]
     nil)
     (let [empty-point (find-empty-point board)
           valid-vals (vec (valid-values-for board empty-point))]
       (for [possible-val valid-vals
             new-board (set-value-at board empty-point possible-val)]
         (sudoku-solve-helper new-board)))))

  
(defn solve [board]
  (sudoku-solve-helper board))
#'sudoku/sudoku-solve-helper
#'sudoku/solve
sudoku> (solve sudoku-board)
IllegalArgumentException Don't know how to create ISeq from: java.lang.Long  clojure.lang.RT.seqFrom (RT.java:505)
sudoku> (defn sudoku-solve-helper [board]
  (if (filled? board)
   (if (valid-solution? board)
     [board]
     nil)
     (let [empty-point (find-empty-point board)
           valid-vals (valid-values-for board empty-point)]
       (for [possible-val valid-vals
             new-board (set-value-at board empty-point possible-val)]
         (sudoku-solve-helper new-board)))))

  
(defn solve [board]
  (sudoku-solve-helper board))
#'sudoku/sudoku-solve-helper
#'sudoku/solve
sudoku> (solve sudoku-board)
IllegalArgumentException Don't know how to create ISeq from: java.lang.Long  clojure.lang.RT.seqFrom (RT.java:505)
sudoku> (defn sudoku-solve-helper [board]
  (if (filled? board)
   (if (valid-solution? board)
     [board]
     nil)
     (let [empty-point (find-empty-point board)]
       (for [possible-val (valid-values-for board empty-point)
             new-board (set-value-at board empty-point possible-val)
             solution (sudoku-solve-helper new-board)]
        solution ))))

  
(defn solve [board]
  (sudoku-solve-helper board))
#'sudoku/sudoku-solve-helper
#'sudoku/solve
sudoku> (solve sudoku-board)
IllegalArgumentException Don't know how to create ISeq from: java.lang.Long  clojure.lang.RT.seqFrom (RT.java:505)
sudoku> (defn sudoku-solve-helper [board]
  (if (filled? board)
   (if (valid-solution? board)
     [board]
     nil)
     (let [empty-point (find-empty-point board)]
       (for [possible-val (valid-values-for board empty-point)
             new-board (set-value-at board empty-point possible-val)
             solution (sudoku-solve-helper new-board)]
       (remove empty? solution)))))

  
(defn solve [board]
  (sudoku-solve-helper board))

#'sudoku/sudoku-solve-helper
#'sudoku/solve
sudoku> (solve sudoku-board)
IllegalArgumentException Don't know how to create ISeq from: java.lang.Long  clojure.lang.RT.seqFrom (RT.java:505)
sudoku> (defn sudoku-solve-helper [board]
  (if (filled? board)
   (if (valid-solution? board)
     [board]
     nil)
     (let [empty-point (find-empty-point board)]
       (for [possible-val (valid-values-for board empty-point)
             new-board (set-value-at board empty-point possible-val)
             solution (sudoku-solve-helper new-board)]
       (remove empty? solution)))))

  
(defn solve [board]
  (first (sudoku-solve-helper board)))
#'sudoku/sudoku-solve-helper
#'sudoku/solve
sudoku> (solve sudoku-board)
IllegalArgumentException Don't know how to create ISeq from: java.lang.Long  clojure.lang.RT.seqFrom (RT.java:505)
sudoku> (defn sudoku-solve-helper [board]
  (if (filled? board)
   (if (valid-solution? board)
     [board]
     nil)
     (let [empty-point (find-empty-point board)]
       (for [possible-val (valid-values-for board empty-point)
             new-board (set-value-at board empty-point possible-val)
             solution (remove empty? (sudoku-solve-helper new-board))]
        solution))))
#'sudoku/sudoku-solve-helper
sudoku> (defn solve [board]
  (first (sudoku-solve-helper board)))
#'sudoku/solve
sudoku> (solve sudoku-board)
IllegalArgumentException Don't know how to create ISeq from: java.lang.Long  clojure.lang.RT.seqFrom (RT.java:505)
sudoku> (filled? sudoku-board)
false
sudoku> (filled? solved-board)
true
sudoku> (defn sudoku-solve-helper [board]
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
#'sudoku/sudoku-solve-helper
#'sudoku/solve
sudoku> (solve sudoku-board)
[[5 3 4 6 7 8 9 1 2] [6 7 2 1 9 5 3 4 8] [1 9 8 3 4 2 5 6 7] [8 5 9 7 6 1 4 2 3] [4 2 6 8 5 3 7 9 1] [7 1 3 9 2 4 8 5 6] [9 6 1 5 3 7 2 8 4] [2 8 7 4 1 9 6 3 5] [3 4 5 2 8 6 1 7 9]]
sudoku> 
