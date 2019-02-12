;; https://www.codewars.com/kata/recover-a-secret-string-from-random-triplets/train/clojure

(partition 2 1 (clojure.string/split "tup" #""))
(concat (list 1 2) (list 3 4))
(remove #{1 2 3} '(1 2 3 4 5))

(defn recover-secret1 [triplets]
  (->> (clojure.string/join "" triplets)
       distinct
       (clojure.string/join "")))

(comment
  (->> (clojure.string/split all-triplets #""
         (sort by-sort-coll)
         reverse
         (clojure.string/join))))

(defn nodes-connected?
  ([n1 n2 graph] (nodes-connected? n1 n2 graph #{}))
  ([n1 n2 graph visited-nodes]
   (cond
     (visited-nodes n1)
     false
     (get-in graph [n1 n2])
     true
     :else
     (loop [candidates (->> (get graph n1)
                            (keys)
                            (remove visited-nodes))]
       (cond
         (empty? candidates)
         false
         (nodes-connected?
           (first candidates)
           n2
           graph
           (conj visited-nodes n1))
         true
         :else
         (recur (rest candidates)))))))

(defn my-expand [xs]
  (conj
    (partition 2 1 xs)
    (list (first xs) (last xs))))

(defn recover-secret [triplets]
  (let [graph (->> (mapcat my-expand triplets)
                   (reduce (fn [coll elm]
                             (assoc-in coll elm true))
                     {}))
        all-triplets (->> (clojure.string/join "" triplets)
                          distinct)
        by-sort-coll (fn [a b]
                       (cond
                         (nodes-connected? a b graph)
                         -1
                         :else
                         1))]
    (->> (sort by-sort-coll all-triplets)
         (clojure.string/join))))


(get #{1 2 3} 3)
(conj #{1 2 3} 4)
(get-in {:a {:b true}} [:a :b])
(keys (get {:a {:b true}} :a))

(->> (recover-secret ["tup" "whi" "tsu" "ats" "hap" "tis" "whs"])
     (nodes-connected? "s" "p"))

(recover-secret ["tup" "whi" "tsu" "ats" "hap" "tis" "whs"])

(def triplets ["tup" "whi" "tsu" "ats" "hap" "tis" "whs"])
(mapcat my-expand triplets)


