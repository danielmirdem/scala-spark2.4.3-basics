package dfbasics

import org.apache.spark.sql.SparkSession

object DFBasicsOperations {
  
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("DF Basics Operations")
      .master("local")
      .getOrCreate()
      
    val parquetDF = spark.read.
      //schema(schema)// I can add schema here
      parquet("src/main/resources/dataset/userdata1.parquet")
      
    println("schema")
    val schema = parquetDF.schema
    println(schema)
    
    println("columns")
    val cols = parquetDF.columns
    println(cols.mkString(","))
    
    println("description")
    val description = parquetDF.describe("salary")
    description.show
    
    println("columnAndTypes")
    val columnAndTypes = parquetDF.dtypes
    columnAndTypes.foreach(println)
    
    println("head")
    parquetDF.head(3).foreach(println)
    
      
  }  
}