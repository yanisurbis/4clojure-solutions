(defn word-sorting [str]
  (let [words 
        (-> (clojure.string/replace str #"[^a-zA-Z\s]" "")
            (clojure.string/split #" "))
        lowercase-words->words
        (reduce
          (fn [res word]
            (assoc
              res
              (clojure.string/lower-case word)
              word))
          {}
          words)]
    (->> (sort lowercase-words->words)
         (map second))))
         

(map word-sorting ["Have a nice day.", "Clojure is a fun language!", "Fools fall for foolish follies."])

