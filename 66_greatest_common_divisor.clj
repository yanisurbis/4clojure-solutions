(defn greatest-common-divisor [elm1 elm2]
  (cond
    (zero? elm1)
    elm2
    (zero? elm2)
    elm1
    :else
    (recur elm2 (mod elm1 elm2))))

(greatest-common-divisor 6 15)

