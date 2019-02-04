(conj [] 3)
(take 3 [1 2 3])
(first [1 2 3])
(first '(1 2 3))
(last [1 2 3])
(rest [1 2 3])

(defn reverse-interleave [coll n]
  (loop [coll coll
         colls (take n (repeat []))]
    (if (empty? coll)
      (reverse colls)
      (->> (first coll)
           (conj (last colls))
           (conj colls)
           drop-last
           (recur (rest coll))))))

(reverse-interleave [1 2 3 4 5 6] 2)

