(drop 6 [1 2 3 4])

(defn partition-seq [n seq]
  (loop [res []
         seq seq]
    (if (empty? seq)
      res
      (let [seq-to-add (take n seq)]
        (if (= n (count seq-to-add))
          (recur
            (conj res seq-to-add)
            (drop n seq))
          (recur
            res
            (drop n seq)))))))

(partition-seq 2 [1 2 3 4 5])

    
  
