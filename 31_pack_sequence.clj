(defn pack-sequence [seq]
  (let [[packs curr-pack] (reduce
                            (fn [[packs curr-pack] elm]
                              (if (= (first curr-pack) elm)
                                ;; current pack is not finished yet, add elm to current pack
                                [packs (concat curr-pack (list elm))]
                                ;; current pack is finished, add it to pack list, start new pack
                                [(concat packs [curr-pack]) (list elm)]))
                            [() (take 1 seq)]
                            (rest seq))]
    (concat packs [curr-pack])))

(pack-sequence [1 1 2 2 3 3])


