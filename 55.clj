(assoc {} 1 3)
(get {1 3} 1)

(defn count-occurrencies [xs]
  (loop [xs xs
         res {}]
    (if (empty? xs)
      res
      (->> (filter #(= (first xs) %) xs)
           count
           (assoc res (first xs))
           (recur (filter #(not= (first xs) %) xs))))))

(defn count-occurrencies1 [xs]
  (reduce
    (fn [res elm]
      (if (contains? res elm)
        (update-in res [elm] inc)
        (assoc res elm 1)))
    {}
    xs))

(count-occurrencies [1 1 2 3 2 1 1])
(count-occurrencies [:b :a :b :a :b])
(count-occurrencies '([1 2] [1 3] [1 3]))

    
