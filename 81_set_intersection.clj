(defn set-intersection [set1 set2]
  (into #{} (filter #(contains? set2 %) set1)))

(set-intersection #{0 1 2 3} #{2 3 4})
