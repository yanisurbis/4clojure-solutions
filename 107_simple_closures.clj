(defn simple-clojure [degree]
  (fn [number]
    (if (= degree 0)
      1
      (last (take degree (iterate #(* number %) number))))))

(def three-to-degree (simple-clojure 3))

(three-to-degree 5)

(map #((simple-clojure %) 2) [0 1 2 3 4])
