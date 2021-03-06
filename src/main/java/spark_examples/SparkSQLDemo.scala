package spark_examples

/**
 * @author bigdatageek.prakash@gmail.com
 */
object SparkSQLDemo extends App {

  import common._
  import org.apache.spark.sql.functions._
  import org.apache.log4j.Logger
  import org.apache.log4j.Level;

  Logger.getLogger("org").setLevel(Level.ERROR);
  Logger.getLogger("akka").setLevel(Level.ERROR);

  val spSession = SparkCommonUtils.spSession
  val spContext = SparkCommonUtils.spContext
  val datadir = SparkCommonUtils.datadir
  import spSession.implicits._
  
  /*-------------------------------------------------------------------
	 * Working with Data Frames
	 -------------------------------------------------------------------*/

  //Create a data frame from aData JSON file
//  val empDf = spSession.read.json(datadir + "customerData.json")
//  
//  empDf.show(10,false)
//  
//  empDf.printSchema()
//
//  //Do data frame queries
//  //SELECT example
//  empDf.select($"name", $"salary"+1000).show()
//
//  //Filter example
//  empDf.filter($"age" === 40).show()
//
//  //Group By example
//  empDf.groupBy("gender").count().show()
//
//  //Aggregate example
//  empDf.groupBy("deptid")
//    .agg(avg($"salary"), max($"age")).show()
//
//  // ----- LOAD RDD into DataFrame ------------
//    
//  //create a data frame from a list
//  val deptList = Array("{'name': 'Sales', 'id': '100'}",
//    "{ 'name':'Engineering','id':'200' }")
//
//  //Convert list to RDD
//  val deptRDD = spContext.parallelize(deptList)
//
//  //Load RDD into a data frame
//  val deptDf = spSession.read.json(deptRDD)
//  deptDf.show()
//
//  //join the data frames
//  empDf.join(deptDf, empDf("deptid") === deptDf("id")).show()
//
//  //Cascading operations
//  empDf.filter(empDf("age") > 30).join(deptDf,
//    empDf("deptid") === deptDf("id")).
//    groupBy("deptid").
//    agg(avg("salary"), max("age")).show()
//
//  //Create Data frames from a CSV
//  val autoDf = spSession.read.option("header", true).csv(datadir + "auto-data.csv")
//    
//  //autoDf.printSchema()
//
//  autoDf.show(5)

  // -------- Create Data Frame from a explicit schema -------

//  println("------------Create Data Frame from a explicit schema------------------")
  
 import org.apache.spark.sql.Row;
  import org.apache.spark.sql.types._

  val schema =
    StructType(Array(
      StructField("id", IntegerType, false),
      StructField("name", StringType, false)))

  val productList = Array((1001, "Book"),(1002, "Perfume"))

  val prodRDD = spContext.parallelize(productList)

  prodRDD.count()
  prodRDD.collect()

  def transformToRow(input: (Int, String)): Row = {

    //Filter out columns not wanted at this stage
    val values = Row(input._1, input._2)
    return values
  }

  val prodRDD2 = prodRDD.map(transformToRow)

  val prodDf = spSession.createDataFrame(prodRDD2,schema)
  prodDf.show()
  prodDf.printSchema()
  
  println("------------Create Data Frame from a explicit schema------------------")

 /* -------------------------------------------------------------------
	* Working with Temp tables
	 -------------------------------------------------------------------*/
  
  println("------------ Working with Temp tables------------------")
  
//  autoDf.createOrReplaceTempView("autos");
//  
//  
//
//  val x = spSession.sql("select * from autos where hp > 200")
//  x.show()
//
//  spSession.sql("select make, max(rpm) from autos group by make order by 2 desc").show();

  //............................................................................
  ////   Working with Databases
  //............................................................................
  //Make sure the driver files are in classpath (or included through POM)
  
  //println("------------Working with databases------------------")*/

  val demoDf = spSession.read.format("jdbc").options(
    Map("url" -> "jdbc:mysql://localhost:3306/test",
      "driver" -> "com.mysql.jdbc.Driver",
      "dbtable" -> "dummytable",
      "user" -> "root",
      "password" -> "")).load()

  demoDf.createOrReplaceTempView("dummyTable")
  spSession.sql("")

}