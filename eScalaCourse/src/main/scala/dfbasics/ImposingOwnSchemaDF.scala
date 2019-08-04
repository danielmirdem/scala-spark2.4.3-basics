package dfbasics

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.DoubleType

object ImposingOwnSchemaDF {
  
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Imposing own Schema to all the DF")
      .master("local")
      .getOrCreate()
      
    val gradesDF = spark.read
      .options(Map("header" -> "true", "inferSchema" -> "true"))
      .csv("src/main/resources/dataset/grades.csv")
    
    println("InferSchema")  
    gradesDF.printSchema()
    
    val ownSchema =  StructType(
      StructField("Last name", StringType, false) ::
      StructField("First name", StringType, false) ::
      StructField("SSN", StringType, false) ::
      StructField("Test1", StringType, true) ::
      StructField("Test2", DoubleType, true) ::
      StructField("Test3", DoubleType, true) ::
      StructField("Test4", DoubleType, true) ::
      StructField("Final", StringType, false) ::
      StructField("Grade", StringType, false) :: Nil
    )
      
    val gradesDFWithSchema = spark.read
      .options(Map("header" -> "true", "inferSchema" -> "true"))
      .schema(ownSchema)
      .csv("src/main/resources/dataset/grades.csv")
      //.format(...)   //
      //.load(.....)   //for not supporter format we still can use schema
 
    println("OwnSchema")  
    gradesDFWithSchema.printSchema()
      
  }  
}