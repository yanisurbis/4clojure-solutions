(defn function-composition [& fs]
  (fn [x]))
    

(defn function-composition1 [& fs]
  (fn [& xs]
    (if (< 1 (count xs))
     (reduce
      (fn [res f] (f res))
      (apply (last fs) xs)
      (reverse (butlast fs)))
     (reduce
       (fn [res f] (f res))
       (first xs)
       (reverse fs)))))
      
    

((function-composition1 rest reverse) [1 2 3 4])

((function-composition1 zero? #(mod % 8) +) 3 5 7 9)
