(drop 3 [1 2 3 4 5 6])
(last (take 2 [1 2 3 4]))

(defn infix-calculator [& elms]
  (loop [res (first elms)
         elms (rest elms)]
    (let [op (first elms)
          num (first (rest elms))]
      (if (empty? elms)
        res
        (recur
          (op res num)
          (drop 2 elms))))))

(infix-calculator 2 + 5)
(infix-calculator 38 + 48 - 2 / 2)
(infix-calculator 10 / 2 - 1 * 2)
(infix-calculator 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9)

