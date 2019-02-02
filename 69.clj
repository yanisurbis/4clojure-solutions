(defn my-merge-with [f & colls]
  (let [all-keys
        (->> (reduce #(into %1 (keys %2)) #{} colls)
             (into [])
             (sort))
        use-f
        (fn [coll]
          (if (= (count coll) 1)
            (first coll)
            (apply f coll)))]
    (reduce
      (fn [res key]
        (->> (map #(get % key) colls)
             (filter (complement nil?))
             (use-f)
             (assoc res key)))
      {}
      all-keys)))
    

(keys {:a 1 :b 2})
(into #{:z :y :x} (keys {:a 1 :b 2}))

(assoc {} :a 4)

(defn foo [f & colls]
  (let [all-keys (into [] (reduce #(into %1 (keys %2)) #{} colls))]
    all-keys))

(defn foo1 [all-keys f & colls]
  (reduce
    (fn [res key]
      (->> (map key colls)
           (filter (complement nil?))
           (apply f)
           (assoc res key)))
    {}
    all-keys))


(my-merge-with + {:a 1} {:b 2} {:c 123 :d 444})
(my-merge-with concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
(my-merge-with - {1 10, 2 20} {1 3, 2 10, 3 15})

(foo1 [:c :b :d :a] + {:a 1 :d 222 :b 1} {:b 2} {:c 123 :d 444})

(foo println {:a 1} {:b 2} {:c 123 :d 444})
((apply juxt #{:a :b}) {:a "aaaaaa" :b "bbbbb" :c "cccc" :d "ddddd"})
