; https://www.codewars.com/kata/did-i-finish-my-sudoku/train/clojure

(count (set [5 3 4 6 7 8 9 1 2]))
(nth [1 2 3 4 5] 3)

(defn correct? [row]
  (= 9 (count (set row))))

(defn get-column [xss index]
  (for [row xss
        :let [col (nth row index)]]
    col))

(defn get-area [xss [x y]]
  (->> (drop (- x 1) xss)
       (take 3)
       (map #(drop (- y 1) %))
       (map #(take 3 %))))

(def coords (for [x [1 4 7]
                  y [1 4 7]]
              [x y]))

(defn done-or-not [board]
  (let [correct-rows (->> (filter correct? board)
                          count
                          (= 9))
        correct-columns (->> (take 9 (range))
                             (map #(get-column board %))
                             (filter correct?)
                             count
                             (= 9))
        correct-areas (->> (map #(get-area board %) coords)
                           (map flatten)
                           (filter correct?)
                           count
                           (= 9))]
    (if (and
             correct-rows
             correct-columns
             correct-areas) "Finished!" "Try again!")))
    

(def board [[5 3 4 6 7 8 9 1 2] 
            [6 7 2 1 9 5 3 4 8]
            [1 9 8 3 4 2 5 6 7]
            [8 5 9 7 6 1 4 2 3]
            [4 2 6 8 5 3 7 9 1]
            [7 1 3 9 2 4 8 5 6]
            [9 6 1 5 3 7 2 8 4]
            [2 8 7 4 1 9 6 3 5]
            [3 4 5 2 8 6 1 7 9]])

(done-or-not board)
(get-column board 0)
(map #(get-column board %) (take 9 (range)))
(get-area board [1 1])
(map #(get-area board %) coords)
