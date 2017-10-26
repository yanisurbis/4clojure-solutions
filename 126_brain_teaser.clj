(let [x (class (class []))]
  (and (= (class x) x) x))

