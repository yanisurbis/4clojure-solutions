(mod 10 5)
(Math/sqrt 6)
(Math/sqrt 10)

(defn is-perfect? [n]
  (let [perf-nums (fn perf-nums
                    ([x] (perf-nums x 1))
                    ([x n] (cond
                             (= 0 (mod x n))
                             (cons n (lazy-seq (perf-nums x (inc n))))
                             :else
                             (perf-nums x (inc n)))))]
    (->> (take-while
           #(< % (+ 1 (/ n 2)))
           (perf-nums n))
         (reduce +)
         (= n))))

(is-perfect? 8128)
