(def arr [1 2 3 4])

(nth arr 2)

(defn my-nth [arr idx]
  (-> (reduce-kv
        (fn [arr i elm] (if (<= i idx) (conj arr elm) arr))
        []
        arr)
      last))

(my-nth arr 2)

(defn my-nth [arr idx]
  (-> (reduce-kv
        (fn [arr i elm] (if (<= i idx) (conj arr elm) arr))
        []
        arr)
      last))

;; #(last (take (+ %2 1) %1))


