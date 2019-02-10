;; https://www.codewars.com/kata/scramblies

(into [] "abcdef")
(sort (clojure.string/split "ghhgasdgab" #""))

(defn scramble [s1 s2]
  (let [ss1 (sort (clojure.string/split s1 #""))
        ss2 (sort (clojure.string/split s2 #""))]
    (->> (reduce
           (fn [res elm]
             (if (= (first res)
                    elm)
               (rest res)
               res))
           ss2
           ss1)
         count
         (= 0))))

(scramble "rkqodlw" "world")
(scramble "cedewaraaossoqqyt" "codewars")
(scramble "katas" "steak")

