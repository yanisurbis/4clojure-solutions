(defn interpose-sequence [elm seq]
   (reduce
    (fn [acc curr]
      (concat acc [elm curr]))
    (take 1 seq)
    (rest seq)))

(interpose-sequence 0 [1 2 3])
