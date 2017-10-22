(defn replicate-sequence [seq times]
  (reduce
    (fn [acc elm]
      (concat acc (take times (repeat elm))))
    '()
    seq))

(replicate-sequence [1 2 3] 4)
