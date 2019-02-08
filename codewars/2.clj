;; https://www.codewars.com/kata/pyramid-slide-down

(partition 2 1 [8 5 9 3])

(apply + [1 2])

(defn ff [reduced-prev-lvl cur-lvl]
  (cond
    (= (count cur-lvl) 2)
    (map + cur-lvl reduced-prev-lvl)
    (= (count cur-lvl) 1)
    (+ (first cur-lvl) (apply max reduced-prev-lvl))
    :else
    (->> (map + reduced-prev-lvl cur-lvl)
         (partition 2 1)
         (map #(apply max %)))))

(ff [1 2 3] [3 2 1])
(ff [11] [3])

(defn pyramid-slide-down [xss]
  (->> (reverse xss)
       (reductions
         ff
         (take (count (last xss)) (repeat 0)))))

(defn pyramid-slide-down1 [xss]
  (take (count (last xss)) (repeat 0)))
           

(pyramid-slide-down1 [[3] [7 4]])
(pyramid-slide-down [[3] [7 4]])
(pyramid-slide-down [[3] [7 4] [2 4 6] [8 5 9 3]])
