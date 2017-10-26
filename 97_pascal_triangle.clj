(defn pascal-triangle [level]
  (last (take
          level
          (iterate
            (fn [& level]
              (concat
                (first
                  (reduce
                    (fn [[next-level prev-elm] curr-elm]
                      [(concat next-level [(+ prev-elm curr-elm)]) curr-elm])
                    [[] 0]
                    (first level)))
                [1]))
            [1]))))

(pascal-triangle 4)

(defn generate-next-level [& level]
  (concat
    (first
      (reduce
        (fn [[next-level prev-elm] curr-elm]
          [(concat next-level [(+ prev-elm curr-elm)]) curr-elm])
        [[] 0]
        (first level)))
    [1]))
  

(generate-next-level [1 3 3 1])

