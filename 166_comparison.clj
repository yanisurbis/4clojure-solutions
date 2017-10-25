(defn comparison [less-fn elm1 elm2]
  (cond
    (true? (less-fn elm1 elm2))
    :lt
    (true? (less-fn elm2 elm1))
    :gt
    :else
    :eq))

(comparison < 5 1)
