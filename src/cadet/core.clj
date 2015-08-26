(ns cadet.core
  (:gen-class))

(defn parse-int [n]
  (Integer/parseInt n))

(defn stay-is-best? [good-option initial-choice]
  (== good-option initial-choice))

(defn run-monte-carlo [number-of-options iterations current-results]
  (if (== iterations 0)
    current-results
    (run-monte-carlo number-of-options
                     (- iterations 1)
                     (into current-results (if (stay-is-best? (rand-int number-of-options)
                                                              (rand-int number-of-options))
                                             ["Stay"]
                                             ["Change"]
                                             ))))
  )

(defn -main
  [& args]
  (println (frequencies (run-monte-carlo (parse-int (first args))
                                         (parse-int (nth args 1))
                                         []))))
