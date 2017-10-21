(defn palindrome-detector [seq]
  (if (string? seq)
    (= (clojure.string/reverse seq) seq)
    (= (reverse seq) seq)))

(palindrome-detector "racecar")

