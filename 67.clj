(defn is-prime [n]
  (cond
    (<= n 1) false
    (<= n 3) true
    (or (= (mod n 2) 0)
        (= (mod n 3) 0))
    false
    :always
    (loop [i 5]
      (cond
        (> (* i i) n)
        true
        (or
            (= 0 (mod n i))
            (= 0 (mod n (+ i 2))))
        false
        :always
        (recur (+ i 6))))))

(defn prime-numbers
  ([] (prime-numbers 2))
  ([n] (lazy-seq (if
                   (is-prime n)
                   (cons n (prime-numbers (inc n)))
                   (prime-numbers (inc n))))))

(take 1 (prime-numbers))

(defn get-prime-numbers [n]
  (let [is-prime
        (fn [n]
          (cond
            (<= n 1) false
            (<= n 3) true
            (or (= (mod n 2) 0)
                (= (mod n 3) 0))
            false
            :always
            (loop [i 5]
              (cond
                (> (* i i) n)
                true
                (or
                    (= 0 (mod n i))
                    (= 0 (mod n (+ i 2))))
                false
                :always
                (recur (+ i 6))))))
        prime-numbers
        (fn prime-numbers
          ([] (prime-numbers 2))
          ([n] (lazy-seq (if
                           (is-prime n)
                           (cons n (prime-numbers (inc n)))
                           (prime-numbers (inc n))))))]
    (take n (prime-numbers))))

(get-prime-numbers 4)
        

                
