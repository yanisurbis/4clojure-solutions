(compare "a" "b")
(compare "b" "a")
(:max-length {:max-length 4})
(last [1 2 3])
(last '(1 2 3))

(defn redf [res elm]
  (let [max-subseq (:max-subseq res)
        subseq (:subseq res)]
    (if (= 1 (compare elm (last subseq)))
      {:subseq (conj subseq elm)
       :max-subseq max-subseq}
      {:subseq [elm]
       :max-subseq (if (< (count subseq)
                          (count max-subseq))
                     max-subseq
                     subseq)})))
    

(defn longest-subseq [xs]
  (let [redf (fn [res elm]
               (let [max-subseq (:max-subseq res)
                     subseq (:subseq res)]
                 (if (= 1 (compare elm (last subseq)))
                   {:subseq (conj subseq elm)
                    :max-subseq max-subseq}
                   {:subseq [elm]
                    :max-subseq (if (<= (count subseq)
                                        (count max-subseq))
                                  max-subseq
                                  subseq)})))
        res (reduce
              redf
              {:subseq (into [] (take 1 xs)) :max-subseq []}
              (rest xs))
        cand1 (:subseq res)
        cand2 (:max-subseq res)
        res (if (> (count cand1)
                   (count cand2))
              cand1
              cand2)]
    (if (= 1 (count res))
      []
      res)))
        
    

(longest-subseq [1 2 3 4 5 1 1 2 3 4 5 6])
(longest-subseq [2 3 3 4 5])
(longest-subseq [1 0 1 2 3 0 4 5])

       
