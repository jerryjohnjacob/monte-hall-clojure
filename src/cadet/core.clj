(ns cadet.core
  (:gen-class))

(def results [])

(defn parse-int [n]
  (Integer/parseInt n))

(defn stay-is-best? [good-option initial-choice]
  (== good-option initial-choice))

(defn run-monte-carlo [n]
  (def results (into results (if (stay-is-best? (rand-int n)
                                   (rand-int n))
                  ["Stay"]
                  ["Change"]
                  )))
  )

(defn -main
  [& args]
  (dotimes [n (parse-int (nth args 1))] (run-monte-carlo (parse-int (first args))))
  (println (frequencies results)))
