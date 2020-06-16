package spark_examples

import org.apache.spark.sql.types.DoubleType
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.StructField

object DFExample extends App{
  import common._
  import org.apache.log4j.Level
  import org.apache.log4j.Logger;
  

  Logger.getLogger("org").setLevel(Level.ERROR);
  Logger.getLogger("akka").setLevel(Level.ERROR);

  val spSession = SparkCommonUtils.spSession
  val spContext = SparkCommonUtils.spContext
  val datadir = SparkCommonUtils.datadir

  val schema =
    StructType(
        StructField("SPECIES", StringType, false) ::
        StructField("SEPAL_LENGTH", DoubleType, false) ::
        StructField("SEPAL_WIDTH", DoubleType, false) ::
        StructField("PETAL_LENGTH", DoubleType, false) ::
        StructField("PETAL_WIDTH", DoubleType, false) :: Nil)
  
  val data = spSession.read.option("header", true).schema(schema).csv(datadir + "iris.csv")
  data.createOrReplaceTempView("iris")
  //spSession.sql("select * from iris where Species = 'setosa' and PetalLength > 1.4").show()
  data.printSchema()
  
}