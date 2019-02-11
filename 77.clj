(nil? nil)

(reduce
  (fn [res elm]
    (update res elm #(if (nil? %)
                       1
                       (inc %))))
  {}
  "abca")

(defn my-f [str]
  (reduce
    (fn [res elm]
      (update res elm #(if (nil? %)
                         1
                         (inc %))))
    {}
    str))
  
(my-f "meat")
(my-f "team")
(into #{} [1 2 3])

(defn anagram-finder [strs]
  (let [str->map (fn [s]
                   (reduce
                     (fn [res elm]
                       (update-in res [elm] #(if (nil? %)
                                               1
                                               (inc %))))
                     {}
                     s))]
    (->> (group-by str->map strs)
         vals
         (map #(into #{} %))
         (filter #(< 1 (count %)))
         (into #{}))))

(anagram-finder ["meat" "mat" "team" "mate" "eat"])
  
