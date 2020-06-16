package spark_examples
import common._
object Test {
  val sc = SparkCommonUtils.spContext
  val spark = SparkCommonUtils.spSession
  import spark.implicits._
  val log = sc.textFile("/user/edureka_353264/prakash/access.log")
  val df = log.map(_.split(" ")).map(att => Log(att(0).trim(),att(3).substring(1).trim(),att(5).trim(),att(8).trim())).toDF()
}


case class Log(ip:String,requestType:String,date:String,status:String)