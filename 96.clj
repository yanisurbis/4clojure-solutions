(= [1 2] [1 2])
(= [1 2] [2 1])
(= [1 2] (reverse [2 1]))
(last [1 2 3])
(second [1 2 3])
(and 1 2 3)
(first [1 2 3])
(or (nil? 1) (nil? nil))

(defn symm?
  ([tree]
   (symm? (nth tree 1)
          (nth tree 2)))
  ([t1 t2]
   (cond
     (or (nil? t1)
         (nil? t2))
     (= t1 t2)
     :else
     (and
          (= (first t1)
             (first t2))
          (symm? (nth t1 1)
                 (nth t2 2))
          (symm? (nth t1 2)
                 (nth t2 1))))))

(symm? '(:a (:b nil nil) (:b nil nil)))
(symm? '(:a (:b nil nil) nil))
