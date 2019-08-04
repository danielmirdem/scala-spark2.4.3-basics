package dfbasics

import org.apache.spark.sql.SparkSession

/**
 * Spark 2.x supports CSV, JSON, ORC, PARQUET Formats
 * 
 * Spark 1.x supports JSON, ORC, PARQUET Formats
 */

object DfFileFormats {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder()
      .appName("df fileformats")
      .master("local")
      .getOrCreate()
    
    /* I Can use schema with the read method
    val schema = StructType(
      StructField("id", StringType, false) :: Nil,
      StructField("Field2", IntegerType, true) :: Nil,
      StructField("Field3", StringType, false) :: Nil,
      ...
    )
    */
            
    val jsonDF = sparkSession.read.
      //schema(schema)// I can add schema here    
      json("src/main/resources/dataset/example.json")
    println("JSON")  
    jsonDF.printSchema()
    jsonDF.show()
    println("Count: " + jsonDF.count)
        
    val orcDF = sparkSession.read.
      //schema(schema)// I can add schema here
      orc("src/main/resources/dataset/orc-file-format.orc")      
    println("ORC")  
    orcDF.printSchema()
    orcDF.show()    
    println("Count: " + orcDF.count)
    
    val parquetDF = sparkSession.read.
      //schema(schema)// I can add schema here
      parquet("src/main/resources/dataset/userdata1.parquet")      
    println("PARQUET")  
    parquetDF.printSchema()
    parquetDF.show()    
    println("Count: " + parquetDF.count)
  }
}