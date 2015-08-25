(ns cadet.core
  (:gen-class))

(defn parse-int [n]
  (Integer. (re-find  #"\d+" n )))

(defn stay-is-best? [good-option initial-choice]
  (== good-option initial-choice))

(defn run-monte-carlo [n]
  (if (stay-is-best? (rand-int n) (rand-int n))
    (println "fail")
    (println "pass")
    )
  )

(defn -main
  [& args]
  (dotimes [n (parse-int (nth args 1))] (run-monte-carlo (parse-int (first args)))))
