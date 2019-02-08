(vector? [1 2 3])
(defn is-coll [])

(filter coll? '(:a (:b nil nil) nil))
(and true false)
(every? true? [true true true])
(nil? nil)
(nil? 4)
(count (filter nil? [4 false nil]))


(defn tree-not-tree [xs]
  (let [has3elm? (= 3 (count xs))
        nested-collections (filter coll? xs)]
    (cond
      (and
           has3elm?
           (empty? nested-collections)
           (= 2 (count (filter nil? xs))))
      true
      (and
           (not-empty nested-collections)
           has3elm?
           (every? true? (map tree-not-tree nested-collections)))
      true
      :else
      false)))

(tree-not-tree '(:a (:b nil nil) nil))
(tree-not-tree '(:a (:b nil nil)))
(tree-not-tree [1 nil [2 [3 nil nil] [4 nil nil]]])
(tree-not-tree [3 nil false])
(tree-not-tree [1 [2 [3 [4 false nil] nil] nil] nil])

(defn tree-not-tree1 [xs]
  (let [has3elm? (= 3 (count xs))
        nested-collections (filter coll? xs)]
    (if
      (and
           has3elm?
           (empty? nested-collections)
           (= 2 (count (filter nil? xs))))
      true
      false)))

(tree-not-tree1 [3 nil false])
  
