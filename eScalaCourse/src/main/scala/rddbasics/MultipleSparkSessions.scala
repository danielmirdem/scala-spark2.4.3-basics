package rddbasics

import org.apache.spark.sql.SparkSession

object MultipleSparkSessions {
    def main(args: Array[String]): Unit = {
      val spark1 = SparkSession.builder()
      .appName("Creating Multiple Spark Sessions")
      .master("local")
      .getOrCreate()

      val spark2 = SparkSession.builder()
      .appName("Creating Multiple Spark Sessions")
      .master("local")
      .getOrCreate()
      
      val rdd1 = spark1.sparkContext.parallelize(Array(1,2,3,4,5));      
      val rdd2 = spark2.sparkContext.parallelize(Array(6,7,8,9,10));
      
      rdd1.collect.foreach(println)
      rdd2.collect.foreach(println)
    }

}