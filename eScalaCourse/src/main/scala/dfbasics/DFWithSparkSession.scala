package dfbasics

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StringType

object DFWithSparkSession {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder()
      .appName("Creating DF with Spark Context")
      .master("local")
      .getOrCreate()

    val rdd = sparkSession.sparkContext.parallelize(Array(1, 2, 3, 4, 5))

    val schema = StructType(
      StructField("Integer as String", StringType, true) :: Nil)

    val rowRDD = rdd.map(element => Row(element.toString));

    val df = sparkSession.createDataFrame(rowRDD, schema)

    df.printSchema()

    df.show(3)

  }

}