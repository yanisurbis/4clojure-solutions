(defn my-update [xs k v]
  (if (get xs k)
    (assoc xs k (conj (get xs k) v))
    (assoc xs k [v])))

(my-update {:a [1] :b [2]} :a 3)
(my-update {} :a 4)

(defn my-group-by [f xs]
  (let [fxs (map f xs)
        my-update (fn [xs k v]
                    (do
                      (println xs k v)
                      (if (get xs k)
                        (assoc xs k (conj (get xs k) v))
                        (assoc xs k [v]))))]
    (-> (reduce
          (fn [[res k v] _] [
                             (my-update res (first k) (first v))
                             (rest k)
                             (rest v)])
          [{} fxs xs]
          xs)
        first)))

;; (println (hash-map a 2))
(my-group-by #(> % 5) [1 3 6 8])
(my-group-by #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
