import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source

object ScalaTutorial {
  def main(args: Array[String]){
    
    //loops
    
    var i = 0
    while(i<=10){
      println(i)
      i += 1
    }
    
    do{
    //.............
      i += 1
    } while(i<=21)
      
    val randLetters = "ASDWERFGDFSHJF"
    
    for (i <- 0 until randLetters.length){
      println(randLetters(i))
    }
    
    var evenList = for { i <- 1 to 20 if (i % 2) == 0 } yield i
    
    for (i <- 1 to 5; j <- 6 to 10){
      println("i: " + i)
      println("j: " + j)
    }
    
    //reading standard input
    var numberGuess = 0
    
    do{
      print("guess a number")
      numberGuess = readLine.toInt
      
    } while(numberGuess != 15 )
      
    printf("you guessed the secret number %d\n", 15)
     
    //-----------
    //format
    val name = "Papi"
    val age =34
    val weight = 175.5
    
    println(s"hello $name")
    
    println(f"I am age ${age +1} and weight $weight%.2f")
    
    //justification
    printf("'%5d'\n", 5)
    printf("'%-5d'\n", 5)
    printf("'%05d'\n", 5)
    //printf("'%.5d'\n", 5)
    
    def factorial(num: BigInt): BigInt = {
      if(num <= 1)
        1
      else
        num * factorial(num - 1)
    }
    
    println("Factorial of 4 = " + factorial(4))

    //Arrays

    val friends = Array("Bob", "Tom")
    
    friends(0) = "Sue"
    
    println("Best Friends " + friends(0))
    
    val friends2 = ArrayBuffer[String]()
    
    friends2.insert(0, "Phil")
    
    friends2 += "Mark"
    
    friends2 ++= Array("Susy", "Peter")

    friends2.insert(1, "Juan", "Jorge", "Pablo")
    
    friends2.remove(1,2)
    
    var friend : String = ""
    
    for (friend <- friends2)
      println(friend)
      
    val favNums = new Array[Int](20)

     val favNumsTimes2 = for(num <- favNums) yield 2 * num
     
     favNumsTimes2.foreach(println)
     
     //multi dimension
     var multTable = Array.ofDim[Int](10,10)
     //two fors to populate 
     //multTable(3)(4)
     
     //Maps:
     val employees = Map("Manager" -> "Bob S.", "Secretary" -> "Sue B.")
     
     if(employees.contains("Manager"))
       printf("Manager : %s\n", employees("Manager") )
       
     val customers = collection.mutable.Map(100->"Genio", 101->"Figura")
     
     printf("Cust 1 : %s\n", customers(100))
     
     customers(100) = "Capo"
     customers(102) = "Titan" 
     
     for((k,v) <- customers)
       printf("%d : %s\n", k, v)
       
       
    //tuples
    var tupleMarge = (103, "Capo", 290)
    
    tupleMarge._1
    
    tupleMarge.productIterator.foreach{ i => println(i)}
    
    println(tupleMarge.toString())
  }
}
