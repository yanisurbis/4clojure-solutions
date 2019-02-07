

(defn juxtaposition [& fs]
  (fn [& args]
    (if (> (count args) 0)
      (map
        (fn [f] (apply f args))
        fs)
      (map
        #(% (first args))
        fs))))

((juxtaposition + max min) 2 3 5 1 6 4)
((juxtaposition #(.toUpperCase %) count) "hello")
((juxtaposition :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10})
