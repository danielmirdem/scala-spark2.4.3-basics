package dataset

import org.apache.spark.sql.SparkSession

case class UserData(registration_dttm: Long,
 id: Integer,
 first_name: String,
 last_name: String,
 email: String,
 gender: String,
 ip_address: String,
 cc: String,
 country: String,
 birthdate: String,
 salary: Double,
 title: String,
 comments: String
) 

object DfVsDsPerformances extends App {
  val spark = SparkSession.builder()
    .appName("Df vs Ds Performances")
    .master("local")
    .getOrCreate()
  
  
  var startTime: Long = 0
  var endTime: Long = 0;
  
  println("DF")
  
  startTime = System.currentTimeMillis()
  
  val df = spark.read.
    parquet("src/main/resources/dataset/userdata1.parquet")
  
  val filteredDF =  df.filter("salary>10000")
  println("DF count: " + filteredDF.count)
  
  endTime = System.currentTimeMillis()
  
  println("DF Time: " + (endTime - startTime) / 1000.0)


  println("---------------------------------------------")
  
  println("DS")

  startTime = System.currentTimeMillis()

  import spark.implicits._   
  
  val ds = spark.read.
    parquet("src/main/resources/dataset/userdata1.parquet").as[UserData]
  
  val filteredDS =  df.filter("salary>10000")
  println("DS count: " + filteredDS.count)
  
  endTime = System.currentTimeMillis()
  
  println("DS Time: " + (endTime - startTime) / 1000.0)
  
  
}