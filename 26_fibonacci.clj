(defn fibonacci [steps]
  (take steps
    (map
      second
      (iterate
          (fn [[a b]] [b (+ a b)])
          [0 1]))))

(fibonacci 8)
    

