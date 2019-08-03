package rddbasics

import org.apache.spark.sql.SparkSession




object CreatingSparkContextWithSparkSession {
    def main(args: Array[String]): Unit = {
      val sparkSession = SparkSession.builder()
        .appName("spark context with sark session")
        .master("local")
        .getOrCreate()
        
      val array = Array(1,2,3,4,5,6,7,8,9)
      
      val arrayRDD = sparkSession.sparkContext.parallelize(array, 3)
      
      arrayRDD.foreach(println)
      
      val file = "C:\\Users\\dmiranda\\Downloads\\airtravel.txt"
      val fileRDD = sparkSession.sparkContext.textFile(file)
      
      println("num of lines: ", fileRDD.count)
      fileRDD.take(2).foreach(println)
    }

}