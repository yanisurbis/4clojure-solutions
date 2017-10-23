(defn advanced-destructuring [elm]
  (let [[a b & c :as d] elm]
    [a b c d]))

;; (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] elm] [a b c d]))

(advanced-destructuring [1 2 3 4 5])
