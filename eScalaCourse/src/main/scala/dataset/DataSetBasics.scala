package dataset

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.DoubleType
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.StructField

case class Grade(lastName: String, firstName: String, ssn: String, test1: Double, test2: Double, test3: Double, test4: Double, finalScore: Double, grade: String)

object DataSetBasics extends App {
    val spark = SparkSession.builder()
      .appName("DataSet Basics")
      .master("local")
      .getOrCreate()
     
    val ownSchema =  StructType(
      StructField("lastName", StringType, false) ::
      StructField("firstName", StringType, false) ::
      StructField("ssn", StringType, false) ::
      StructField("test1", DoubleType, true) ::
      StructField("test2", DoubleType, true) ::
      StructField("test3", DoubleType, true) ::
      StructField("test4", DoubleType, true) ::
      StructField("finalScore", DoubleType, false) ::
      StructField("grade", StringType, false) :: Nil
    )
  
   import spark.implicits._   
    
   val gradesDS = spark.read
                   .option("header", "true")
                   //.option("inferSchema", "true")
                   .schema(ownSchema)
                   .csv("src/main/resources/dataset/grades.csv").as[Grade]
    
   gradesDS.show()

}