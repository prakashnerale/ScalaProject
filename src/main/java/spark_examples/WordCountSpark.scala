package spark_examples

object WordCountSpark extends App {

  import common._

  val spContext = SparkCommonUtils.spContext

  val file = spContext.textFile("D:\\TRAININGS\\EDUREKA APACHE SPARK TRAINING LATEST\\spark-edureka-examples\\data-files\\Server_log_Sample\\server_log_words")


  val x = file.flatMap(line => line.split("\t"))
  .map(ele => (ele,1))
  .reduceByKey((x,y) => x+y)
  .map(ele => ele.swap)
  .sortByKey(false)
 
  val y = x.map(ele => ele.swap)
  println(y.toDebugString)
  
  val z = x.collect()
  .foreach(println)
  

  
  
//  file.flatMap(r => r.split("\t"))
//    .map { r => (r, 1) }
//    .reduceByKey((x, y) => x + y)
//    .collect()
//    .foreach(println)

}