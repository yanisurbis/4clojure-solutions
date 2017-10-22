(defn factorial-fun [steps]
  (loop [res 1
         curr-mult 1]
    (if (= curr-mult steps)
      (* res curr-mult)
      (recur (* res curr-mult) (+ curr-mult 1)))))

(factorial-fun 5)

