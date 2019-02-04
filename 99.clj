(defn product-digits [x y]
  (loop [val (* x y)
         numbers []]
    (if (= val 0)
      (reverse numbers)
      (recur
        (quot val 10)
        (conj numbers (rem val 10))))))

(product-digits 1 1)
(product-digits 10 1)
(product-digits 99 9)
(product-digits 999 99)
