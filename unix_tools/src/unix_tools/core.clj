(ns unix_tools.core
  (:require [clojure.string]))

(defn cat [file] (slurp file))

(defn wc
  "print the number of newlines, words, and bytes in files"
  [file & files] 
  (map 
	  #(let [s (cat %)
	        newlines (count (re-seq #"\n" s))
	        words (count (re-seq #"\w+" s))
	        bytes (.length (clojure.java.io/file %))]
      [newlines words bytes]) 
   (cons file files)))

(defn uniq
  "Discard	all but one of successive identical lines from file"
  [file]
  (let [lines (clojure.string/split (cat file) #"\n")]
	  (reduce 
		  (fn[res-col b] (if (= (last res-col) b) res-col (conj res-col b))) 
		  [(first lines)] 
		  lines)))