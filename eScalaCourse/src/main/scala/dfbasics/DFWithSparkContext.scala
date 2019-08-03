package dfbasics

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.Row

/**
 * In Spark 1.x DF is created using Spark Context
 * and SqlContext is created using Spark Context
 */

object DFWithSparkContext {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf();
    sparkConf.setMaster("local")
    sparkConf.setAppName("Creating DF with Spark Context");

    val sc = new SparkContext(sparkConf)

    val sqlContext = new SQLContext(sc)

    val rdd = sc.parallelize(Array(1, 2, 3, 4, 5))

    val schema = StructType(
      StructField("Numbers", IntegerType, false) :: Nil)

    val rowRDD = rdd.map(line => Row(line));

    val df = sqlContext.createDataFrame(rowRDD, schema)

    df.printSchema()

    df show

  }

}