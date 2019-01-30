(zipmap [:a :b :c] [1 2 3])

(rest [1 2 3])

(defn my-zipmap [k v]
  (-> (reduce
        (fn [[res k v] _] [(assoc res (first k) (first v)) (rest k) (rest v)])
        [{} k v]
        (if
          (< (count k) (count v))
          k
          v))
      first))

(my-zipmap [1 2 3 4] ["one" "two" "three"])


(reduce 
  (fn [[res k v] _] [(assoc res (first k) (first v)) (rest k) (rest v)])
  [{} [:x :y :z] [:4 :5 :6]]
  [:a :b :c])
       
  
