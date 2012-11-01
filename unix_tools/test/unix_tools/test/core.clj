(ns unix_tools.test.core
  (:require [clojure.string :as str])
  (:use [unix_tools.core])
  (:use [clojure.test]))

(deftest uniq-consecutive
  (is (= "ABCEFGHAI" (str/replace (apply str (uniq "test.txt")) #"\r" ""))))
(deftest uniq-empty
  (is (= "" (apply str (uniq "empty.txt")))))