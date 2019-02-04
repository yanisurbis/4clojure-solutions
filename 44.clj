
(drop 2 (into [1 2 3 4] [1 2]))
(merge '(1 2 3) '(4 5 6))
(concat '(1 2 3) '(4 5 6))
(concat [1 2 3] [4 5 6])

(defn inspect [data]
  (do
    (println data)
    data))

(defn rotate-sequence [n1 xs]
  (let [n (rem n1 (count xs))]
    (cond 
      (> n 0)
      (->> xs
           (take n)
           (concat xs)
           (drop n))
      (< n 0)
      (->> xs
           (take (+ (count xs) n))
           (concat xs)
           (drop (+ (count xs) n)))
      :always
      xs)))

(defn rotate-sequence1 [n1 xs]
  (let [n (mod n1 (count xs))]
    n))
    
    
(rem -4 3)  

(rotate-sequence 2 [1 2 3 4 5])
(rotate-sequence -2 [1 2 3 4 5])
(rotate-sequence -4 '(:a :b :c))
  
