;; https://www.codewars.com/kata/weight-for-weight

(BigInteger. "56")
(mod 10 3)

(defn sum-all-numbers1 [num]
  (loop [num num
         res 0]
    (if (= 0 num)
      res
      (recur
        (quot num 10)
        (+ res (mod num 10))))))

(map sum-all-numbers1 [1 12 321 333 30])

(defn sum-all-numbers [num]
  (->> (clojure.string/split num #"")
       (reduce #(+ %1 (Integer. %2)) 0)))

(map sum-all-numbers ["111"])

(defn order-weight [str]
  (if (= (count str) 0)
    str
    (->> (clojure.string/split str #" ")
         (map (fn [num]
                [num
                 (sum-all-numbers num)]))
         (sort (fn [x y]
                 (let [c (compare
                           (second x)
                           (second y))]
                   (if (not= c 0)
                     c
                     (compare
                       (first x)
                       (first y))))))
         (map first)
         (clojure.string/join " "))))

(order-weight "56 65 74 100 99 68 86 180 90")
(order-weight "")
