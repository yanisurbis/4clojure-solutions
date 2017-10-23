(defn drop-every-nth [seq n]
  (first (reduce
           (fn [[acc counter] elm]
             (if (= counter 0)
               [acc (- n 1)]
               [(concat acc [elm]) (- counter 1)]))
           [() (- n 1)]
           seq)))

(drop-every-nth [1 2 3 4 5 6 7 8 9 10] 2)
