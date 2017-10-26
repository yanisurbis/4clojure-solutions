(defn simmetric-difference [set1 set2]
  (clojure.set/union
    (clojure.set/difference set1 set2)
    (clojure.set/difference set2 set1)))

(simmetric-difference #{1 2 3 4 5 6} #{1 3 5 7})
