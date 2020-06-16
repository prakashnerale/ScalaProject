package PrakashFiles

import common.SparkCommonUtils

object RDD extends App {
   
  val sc = SparkCommonUtils.spContext
  val words = Array("cat","rat","bat","rat","rat")
  val rdd = sc.parallelize(words,1)
  
  rdd.collect.foreach(println)
  
  val rddTup = rdd.map(ele=>(ele,1))
  
  rddTup.collect.foreach(println)
  
  val result = rddTup.reduceByKey((x,y) => x+y)
  
  result.collect.foreach(println)
  
  result.sortByKey(false).collect.foreach(println)
  
  
  
   
}