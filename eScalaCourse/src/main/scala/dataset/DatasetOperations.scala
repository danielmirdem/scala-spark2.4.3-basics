package dataset

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.DoubleType
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.StructField

object DatasetOperations extends App {

  val spark = SparkSession.builder()
  .appName("Dataset Operations")
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
                   .csv("src/main/resources/dataset/grades.csv")
                   .where("lastName is not null")
                   .as[Grade]

  
   println("Filter: finalScore>45")
   val filterGrades = gradesDS.filter(grade =>grade.finalScore>45)       
   filterGrades.show()   
   println("Count: " + filterGrades.count)
  
   println("Where: finalScore>45")
   val whereGrades = gradesDS
     .where(gradesDS("finalScore") >45)
     //.where("finalScore>45") another way     
   whereGrades.show()   
   println("Count: " + whereGrades.count)

   println("Select: firstName, lastName, finalScore, grade")   
   case class GradeSelected(lastName: String, firstName: String, finalScore: Double, grade: String)   
   val selectGrades = gradesDS.select("firstName", "lastName", "finalScore", "grade").as[GradeSelected]       
   selectGrades.show()   
   println("Count: " + selectGrades.count)
   
   
   
}