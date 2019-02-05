(Math/pow 2 5)
(Integer. "3")

(defn read-binary-number [str]
  (->> (reverse str)
       (reduce
         (fn [[res n] elm]
           (cond
             (= elm \0)
             [res (inc n)]
             (= elm \1)
             [(+ res (Math/pow 2 n))
              (inc n)]))
         [0 0])
       first
       int))

(defn read-binary-number1 [str]
  (reduce
    (fn [res elm]
      (conj res elm))
    []
    str))

(read-binary-number1 "0123")
(read-binary-number "1000")
