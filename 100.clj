(defn my-f [& nums]
  (let [gcd (fn [a b]
              (if (zero? b)
                a
                (recur b (mod a b))))
        lcm (fn [a b]
              (/ (* a b) (gcd a b)))]
    (->> (drop 2 nums)
         (reduce
           lcm
           (apply lcm (take 2 nums))))))

(my-f 2 3)
(my-f 5 3 7)
(my-f 1/3 2/5)
(my-f 3/4 1/6)
(my-f 7 5/7 2 3/5)

(= 2 2N)
