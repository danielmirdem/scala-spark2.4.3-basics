package dfbasics

import org.apache.spark.sql.SparkSession

object CreatingDFWithCSVUsingSS {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder()
      .appName("Creating DF with CSV using Spark Context")
      .master("local")
      .getOrCreate()
      
    val df = sparkSession.read
      //.option("header", "true")
      //.option("inferSchema", "true")
      .options(Map("header" -> "true", "inferSchema" -> "true"))
      .csv("src/main/resources/dataset/grades.txt")
    
    df.printSchema()
    
    df show
    
  }
}