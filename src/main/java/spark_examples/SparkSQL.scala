package spark_examples
import common._
import org.apache.spark.sql.functions._
import org.apache.log4j.Logger
import org.apache.log4j.Level;

object SparkSQL extends App {
  val spSession = SparkCommonUtils.spSession
  val spContext = SparkCommonUtils.spContext
  val datadir = SparkCommonUtils.datadir
  import spSession.implicits._

  /*-------------------------------------------------------------------
	 * Working with Data Frames
	 -------------------------------------------------------------------*/

  //Create a data frame from aData JSON file
  /*  val empDf = spSession.read.json(datadir + "test_data1.json")
  empDf.show(false)
  empDf.collect().foreach(println)

  empDf.createOrReplaceTempView("emp")
  empDf.printSchema()
  spSession.sql("select * from emp").show(false)
  spSession.sql("select sales.firstName from emp").show(false)
*/
  //Create a data frame from aData JSON file
  /*val df1 = spSession.read.json(datadir + "json_file_1")
  df1.show(false)
  df1.collect().foreach(println)
  df1.printSchema()*/

  val df2 = spSession.read.json(datadir + "json_file_2")
  df2.printSchema()
  df2.createOrReplaceTempView("emp1")
  spSession.sql("select * from emp1").show(false)
}