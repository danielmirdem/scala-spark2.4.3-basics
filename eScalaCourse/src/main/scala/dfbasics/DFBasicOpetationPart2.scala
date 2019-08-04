package dfbasics

import org.apache.spark.sql.SparkSession

object DFBasicOpetationPart2 {
    def main(args: Array[String]): Unit = {
      val spark = SparkSession.builder()
        .appName("DF Basics Operations Part 2")
        .master("local")
        .getOrCreate()
        
      val df = spark.read.
        //schema(schema)// I can add schema here
        parquet("src/main/resources/dataset/userdata1.parquet")
      println("schema")
      df.printSchema()
             
      val dfSelResult = df.select("first_name", "email", "salary")
        .where("first_name=='Irene'")      
      println("select and where")
      dfSelResult.show(10)

      val dfSelResult2 = df.select("first_name", "email", "salary")
        .filter(df("first_name") === "Irene")      
      println("select with filter")
      dfSelResult2.show(10)

      val dfSelResult3 = df.select("first_name", "email", "salary")
        .groupBy("first_name").count()      
      println("select with group by")
      dfSelResult3.show(10)
      
      
    }
}