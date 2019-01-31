(take 5 (iterate inc 5))

(fn my-iterate [f v]
  (lazy-seq (cons v (my-iterate f (f v)))))

(take 5 (my-iterate inc 5))
