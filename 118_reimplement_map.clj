(first [1 2 3 4])

(defn my-map [f seq]
  (cond
    (empty? seq)
    (empty seq)
    :else
    (lazy-seq
             (cons 
               (f (first seq))
               (my-map f (rest seq))))))
               

(my-map inc [1 2 3 4])
