(defn sum-digits [n]
  (->> (clojure.string/split (str n) #"")
       (map #(Integer. %))
       (map #(* % %))
       (apply +)))

(sum-digits 4)
(sum-digits 10)
(sum-digits 15)

(take 5 (iterate #(quot % 10) 123456))

(defn my-f [xs]
  (let [sum-of-square-digits (fn [n]
                               (->> (clojure.string/split (str n) #"")
                                    (remove #(= "" %))
                                    (map #(Integer/parseInt %))
                                    (map #(* % %))
                                    (apply +)))]
    (count (filter #(< % (sum-of-square-digits %)) xs))))

(my-f (range 10))
  
