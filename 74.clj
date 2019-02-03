(defn filter-perfect-squares [str]
  (->> (clojure.string/split str #",")
       (map read-string)
       (filter #(=
                   (Math/floor (Math/sqrt %1))
                   (Math/sqrt %1)))
       (clojure.string/join ",")))
 

(map filter-perfect-squares ["4,5,6,7,8,9", "15,16,25,36,37"])
