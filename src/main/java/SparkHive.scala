
import org.apache.spark.sql.hive._
import common._
object SparkHive extends App{
  val sc = SparkCommonUtils.spContext
  val hc = new HiveContext(sc)
  hc.sql("show databases")
}