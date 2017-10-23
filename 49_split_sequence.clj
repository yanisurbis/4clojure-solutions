(defn split-sequence [n seq]
  (vector
    (take n seq)
    (take-last (- (count seq) n) seq)))

(split-sequence 2 [1 2 3 4 5 6])
  
