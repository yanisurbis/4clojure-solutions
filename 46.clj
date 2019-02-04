(defn flipping-out [f]
  (fn [& args]
    (apply f (reverse args))))

(nth [1 2 3 4] 1)
((flipping-out nth) 1 [1 2 3 4])
