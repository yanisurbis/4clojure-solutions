(map vector [1 2 3] [1 2 3])

(defn dot-product [xs1 xs2]
  (->> (map vector xs1 xs2)
       (reduce #(+ %1 (apply * %2)) 0)))

(dot-product [0 1 0] [1 0 0])
