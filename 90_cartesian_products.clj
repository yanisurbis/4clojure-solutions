(defn cartesian-product [set1 set2]
  (into
    #{} (for [a set1
              b set2]
             [a b])))

(cartesian-product #{1 2 3} #{2 3 4})
