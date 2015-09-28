(ns cadet.core
  (:gen-class))

(defn parse-int [n]
  (Integer/parseInt n))

(defn stay-is-best? [good-option initial-choice]
  (= good-option initial-choice))

(defn run-monte-hall
  [number-of-options iterations]
  (for [_ (range iterations)
        :let [good-option (rand-int number-of-options)
              choice (rand-int number-of-options)]]
    (if (stay-is-best? good-option choice)
      "Stay"
      "Change")))

(defn -main
  [& args]
  (println (frequencies (run-monte-hall (parse-int (first args))
                                        (parse-int (nth args 1))))))
