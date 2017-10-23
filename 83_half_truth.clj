(defn half-truth [& booleans]
  (and 
       (not-every? identity booleans)
       (or (some identity booleans) false)))

(half-truth false false)
