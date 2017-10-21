(defn duplicate-sequence [seq]
  (mapcat (fn [a b] [a b]) seq seq))

(duplicate-sequence [1 2 3])


