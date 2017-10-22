;; solution
(defn flatten-sequence [seq]
  (loop [seq seq]
    (if (some #(or (vector? %) (list? %)) seq)
      (recur (reduce
               (fn [acc elm]
                 (if (or (vector? elm) (list? elm))
                   (concat acc elm)
                   (concat acc [elm])))
               '()
               seq))
      seq)))
    
(defn flatten-one-level [seq]
  (reduce
    (fn [acc elm]
      (if (seqable? elm)
        (concat acc elm)
        (concat acc [elm])))
    '()
    seq))

(flatten-one-level [1 2 [3 4]])

(flatten-sequence [1 [1 [1 3] [3 5 6] 2] 3 4])

(seq? [3 4])
(seqable? [3 4])
