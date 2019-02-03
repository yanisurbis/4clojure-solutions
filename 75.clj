(defn gcd [a b]
        (if (zero? b)
          a
          (recur b (mod a b))))

(defn cooprime [x y]
  (=  1 (gcd x y)))

(defn totient-f [x]
  (let [gcd (fn gcd [a b]
              (if (zero? b)
                a
                (recur b (mod a b))))]
    (if (= x 1)
      1
      (->> (take
             (- x 1)
             (iterate inc 1))
           (filter #(= 1 (gcd %1 x)))
           count))))


(totient-f 10)




