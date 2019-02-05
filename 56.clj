(defn find-distinct-items [xs]
  (first (reduce
           (fn [[coll kv] elm]
             (if (contains? kv elm)
               [coll kv]
               [(conj coll elm)
                (assoc kv elm :present)]))
           [[] {}]
           xs)))

(find-distinct-items [1 2 1 3 1 2 3 4])
(find-distinct-items '([2 4] [1 2] [1 3] [1 3]))
