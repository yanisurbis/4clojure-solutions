(map (fn [x y] [x y]) [1 2 3] (range))

(defn indexing-sequence [xs]
  (map vector xs (range)))

(indexing-sequence [1 2 3])

