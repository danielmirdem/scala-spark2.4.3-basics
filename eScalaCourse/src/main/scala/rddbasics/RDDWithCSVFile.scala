package rddbasics

import org.apache.spark.sql.SparkSession

object RDDWithCSVFile {
    def main(args: Array[String]): Unit = {
      val spark = SparkSession.builder()
      .appName("Creating RDD with CSV Files")
      .master("local")
      .getOrCreate()
      
      val csvRDD = spark.sparkContext.textFile("src/main/resources/dataset/airtravel.txt", 3);
      
      println(csvRDD.count)
      csvRDD.take(5).foreach(println)
      
      val header = csvRDD.first
      
      val csvRDDWithoutHeader = csvRDD.filter(_ != header)
      csvRDDWithoutHeader.take(5).foreach(println)
      
      val phraseIds = csvRDDWithoutHeader.map(line => line.split(",")(0))
      
      phraseIds.foreach(println)
      
      val onlyTwoColumns = csvRDDWithoutHeader.map(line =>{
          val colArray = line.split(",  ")
          Array(colArray(0), colArray(3)).mkString(",")
      })
      //.take(5).foreach(println)   
        
      onlyTwoColumns.take(5).foreach(println)
      
      onlyTwoColumns.saveAsTextFile("src/main/resources/output/twoCols.txt")
      
    }

}