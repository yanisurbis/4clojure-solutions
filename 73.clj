(some #{2} [2 3 4])
(keep-indexed #(if (odd? %1) %2) [1 2 3 4 5 6 7])

(def coord-to-check [[0 1 2]
                     [2 5 8]
                     [8 7 6]
                     [6 3 0]
                     [1 4 7]
                     [3 4 5]
                     [2 4 6]
                     [0 4 8]])
                     

(defn ttt-winner [board]
  (let [flat-board (apply concat board)
        array-of-coords [[0 1 2]
                         [2 5 8]
                         [8 7 6]
                         [6 3 0]
                         [1 4 7]
                         [3 4 5]
                         [2 4 6]
                         [0 4 8]]]
    (->> (map
           (fn [coords]
             (keep-indexed
               #(if (some #{%1} coords) %2)
               flat-board))
           array-of-coords)
         (reduce
           (fn [res elm]
             (cond
               res
               res
               (= elm [:x :x :x])
               :x
               (= elm [:o :o :o])
               :o
               :always
               nil))
           nil))))
           
  

(map ttt-winner [[[:e :e :e]
                  [:e :e :e]
                  [:e :e :e]]
                 [[:x :e :o]
                  [:x :e :e]
                  [:x :e :o]]
                 [[:e :x :e]
                  [:o :o :o]
                  [:x :e :x]]
                 [[:x :e :o]
                  [:x :x :e]
                  [:o :x :o]]
                 [[:x :e :e]
                  [:o :x :e]
                  [:o :e :x]]
                 [[:x :e :o]
                  [:x :o :e]
                  [:o :e :x]]
                 [[:x :o :x]
                  [:x :o :x]
                  [:o :x :o]]])
