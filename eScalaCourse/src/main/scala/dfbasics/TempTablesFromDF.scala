package dfbasics

import org.apache.spark.sql.SparkSession

object TempTablesFromDF {
    def main(args: Array[String]): Unit = {
      val spark = SparkSession.builder()
        .appName("Working with TempTables FromDF")
        .master("local")
        .getOrCreate()
        
      val df = spark.read.
      //schema(schema)// I can add schema here
        parquet("src/main/resources/dataset/userdata1.parquet")
      println("schema")
      df.printSchema()

      val tempTable = df.createTempView("userdata")
      
      val limitedDF = spark.sql("select * from userdata where first_name='Irene'")
      limitedDF.show()

      //Override existing TempTable
      limitedDF.createOrReplaceTempView("userdata")
      
      spark.sql("select * from userdata limit 10").show      
      
    }
}