package dfbasics

import org.apache.spark.sql.SparkSession

object WorkingWithAvroFileFormat {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Working with Avro File Format")
      .master("local")
      .getOrCreate()

    val avroDF = spark.read
      .format("avro")
      .load("src/main/resources/dataset/example.avro")
    println("AVRO")  
    avroDF.printSchema()
    avroDF.show()    
    println("Count: " + avroDF.count)
    
    //write the avro in another file 
    avroDF.write.format("avro").save("src/main/resources/output/example-avro-save")
    
  }

}