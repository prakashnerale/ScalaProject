package spark_examples

import org.apache.spark._
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
import org.apache.spark.sql._
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.storage.StorageLevel
import scala.io.Source
import scala.collection.mutable.HashMap
import java.io.File
import org.apache.spark.sql.Row
import scala.collection.mutable.ListBuffer
import org.apache.spark.util.IntParam
import org.apache.spark.util.StatCounter
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd._

import common._

// customer pick-up points
object KMeansExample extends App {
  val spSession = SparkCommonUtils.spSession
  val spContext = SparkCommonUtils.spContext
  val datadir = SparkCommonUtils.datadir

  import spSession.implicits._

  val schema = StructType(Array(
    StructField("dt", StringType, true),
    StructField("lat", DoubleType, true),
    StructField("lon", DoubleType, true),
    StructField("base", StringType, true)))

  val df = spSession.read.option("header", "true").schema(schema).csv(datadir + "uber-raw-data-apr14.csv")
  df.show(5)
  df.printSchema()

  val featureCols = Array("lat", "lon")

  //VectorAssembler is a transformer that combines a given list of columns into a single vector column.
  //It is useful for combining raw features and features generated by different feature transformers into a single
  //feature vector, in order to train ML models like logistic regression and decision trees.

  val assembler = new VectorAssembler().setInputCols(featureCols).setOutputCol("features")
  val df2 = assembler.transform(df)
  df2.show(5)

  val kmeans = new KMeans().setK(10).setFeaturesCol("features")
  val model = kmeans.fit(df2)

  println("Final Centers: ")
  model.clusterCenters.foreach(println)

}