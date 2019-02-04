(class :a)

(vals {:a 1 :b 2})

(defn split-by-type [coll]
  (->> (group-by class coll)
       vals
       (into #{})))
       
(split-by-type [1 :a 2 :b 3 :c])
(split-by-type [:a "foo"  "bar" :b])
(split-by-type [[1 2] :a [3 4] 5 6 :b])
