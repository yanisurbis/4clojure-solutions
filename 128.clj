(first "xy")

(#{1 2} 3)

(defn recognize-card [card]
  (let [str->suit (fn [s]
                    (cond
                      (= s "D")
                      :diamond
                      (= s "H")
                      :heart
                      (= s "C")
                      :club
                      (= s "S")
                      :spades))
        str->rank (fn [s]
                    (cond
                      (#{"2" "3" "4" "5" "6" "7" "8" "9"} s)
                      (- (Integer. s) 2)
                      (= s "T")
                      8
                      (= s "J")
                      9
                      (= s "Q")
                      10
                      (= s "K")
                      11
                      (= s "A")
                      12))]
    (->> (clojure.string/split card #"")
         ((juxt
            (comp #(assoc {} :suit %) str->suit first)
            (comp #(assoc {} :rank %) str->rank second)))
         (reduce merge))))
            
       

(recognize-card "H5")
(recognize-card "DQ")
(recognize-card "CA")

(= (range 13) (map (comp :rank recognize-card str)
                   '[S2 S3 S4 S5 S6 S7
                     S8 S9 ST SJ SQ SK SA]))

(= {:suit :diamond :rank 10} (recognize-card "DQ"))
        
                        
