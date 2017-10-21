(defn compress-sequence [seq]
  (reduce
    (fn [acc elm]
      (if (= (last acc) elm) acc (concat acc [elm])))
    (take 1 seq)
    seq))

(compress-sequence "Leeeeeerrroyyy")

