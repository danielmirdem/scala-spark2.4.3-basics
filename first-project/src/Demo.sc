import scala.math._

object Demo {

  println("Welcome PAPA")                         //> Welcome PAPA

	//variables
  var num : Int = 8;                              //> num  : Int = 8
  
  println(num)                                    //> 8
  
  //inmutables
  val s = 2                                       //> s  : Int = 2
  
  //s = 3
  var r = 3                                       //> r  : Int = 3
  
  r = 6
  
 //operator = function
 var result = 8 + 7                               //> result  : Int = 15
 var result2 = 8.+(7)                             //> result2  : Int = 15
 
 	case class Student2(var rollno: Int = 1, var name: String = "daniel", var marks: Int = 90)
 
  //class
  case class Student(var rollno: Int = 1, var name: String = "daniel", var marks: Int = 90)
  {
    //method
  	def show() = println("hi");
  	
  	def show2() = {
  		println("hi");
  	}
  	
  	//operator = function
  	def >(s2: Student): Boolean = marks > s2.marks
  	
  }
  
  //instances
  var s1 = Student();                             //> s1  : Demo.Student = Student(1,daniel,90)
  
  var s2 = Student(3, "capo");                    //> s2  : Demo.Student = Student(3,capo,90)
  
  var s3 = Student(name = "papa");                //> s3  : Demo.Student = Student(1,papa,90)

  var s4 = Student(marks = 100);                  //> s4  : Demo.Student = Student(1,daniel,100)
  
  //calling method
  s1.show()                                       //> hi
  
  s1.show()                                       //> hi

  //using operator=function
  s1>s4                                           //> res0: Boolean = false
  
  s4>s1                                           //> res1: Boolean = true
  
  s1.>(s4)                                        //> res2: Boolean = false
  
  //list
  
  var nums = List(4, 7, 2, 3, 8, 9)               //> nums  : List[Int] = List(4, 7, 2, 3, 8, 9)
 
  for (n <- nums) println(n)                      //> 4
                                                  //| 7
                                                  //| 2
                                                  //| 3
                                                  //| 8
                                                  //| 9
 
 
  //reverse
  nums.reverse                                    //> res3: List[Int] = List(9, 8, 3, 2, 7, 4)
  
  //lambda
  nums.foreach{i: Int => println(i)}              //> 4
                                                  //| 7
                                                  //| 2
                                                  //| 3
                                                  //| 8
                                                  //| 9
  
 
  //remove
  nums.drop(2)                                    //> res4: List[Int] = List(2, 3, 8, 9)
  
  //take
  nums.drop(2).take(2)                            //> res5: List[Int] = List(2, 3)
  
  //syntantic sugar
  nums drop 2                                     //> res6: List[Int] = List(2, 3, 8, 9)
  
  
  //Type Hierarchy
  var list2 = List(12,32,54,true)                 //> list2  : List[AnyVal] = List(12, 32, 54, true)
  
  var list3 = List("papa", 1)                     //> list3  : List[Any] = List(papa, 1)
  
  var list4 = List("papa", s1, s2)                //> list4  : List[java.io.Serializable] = List(papa, Student(1,daniel,90), Stud
                                                  //| ent(3,capo,90))
  
  var list5 = List(s1, s2)                        //> list5  : List[Demo.Student] = List(Student(1,daniel,90), Student(3,capo,90)
                                                  //| )
     
     
  //List Options
        
  val list6= List(Student(name="jorge"), Student(2, "luis", 30), s2)
                                                  //> list6  : List[Demo.Student] = List(Student(1,jorge,90), Student(2,luis,30),
                                                  //|  Student(3,capo,90))
  
  val fisrt = list6.head                          //> fisrt  : Demo.Student = Student(1,jorge,90)
  
  val rest = list6.tail                           //> rest  : List[Demo.Student] = List(Student(2,luis,30), Student(3,capo,90))
  
  val restHead = list6.tail.head                  //> restHead  : Demo.Student = Student(2,luis,30)
 
  val toppers = list6.filter(s=> s.marks>=60)     //> toppers  : List[Demo.Student] = List(Student(1,jorge,90), Student(3,capo,90
                                                  //| ))
  val parts = list6.partition(s=> s.marks>=60)    //> parts  : (List[Demo.Student], List[Demo.Student]) = (List(Student(1,jorge,9
                                                  //| 0), Student(3,capo,90)),List(Student(2,luis,30)))
  
  //Tuples
  val part1 = parts._1                            //> part1  : List[Demo.Student] = List(Student(1,jorge,90), Student(3,capo,90))
                                                  //| 
  val part2 = parts._2                            //> part2  : List[Demo.Student] = List(Student(2,luis,30))

  val (part_1, part_2) = list6.partition(s=> s.marks>=60)
                                                  //> part_1  : List[Demo.Student] = List(Student(1,jorge,90), Student(3,capo,90)
                                                  //| )
                                                  //| part_2  : List[Demo.Student] = List(Student(2,luis,30))
 
  part_1                                          //> res7: List[Demo.Student] = List(Student(1,jorge,90), Student(3,capo,90))
  
  part_2                                          //> res8: List[Demo.Student] = List(Student(2,luis,30))
  
  //big numbers:
  
  val bigguy = BigInt("2312332132131212342424532432434242342424242424242343242423423")
                                                  //> bigguy  : scala.math.BigInt = 231233213213121234242453243243424234242424242
                                                  //| 4242343242423423
  val bigDec = BigDecimal("3.22222222222222222222222222222222223333333333333")
                                                  //> bigDec  : scala.math.BigDecimal = 3.222222222222222222222222222222222233333
                                                  //| 33333333
 
 var randInt = 1000                               //> randInt  : Int = 1000
 
   randInt += 1
 
 //scala.math_
 abs(-1)                                          //> res9: Int = 1
 
 sqrt(4)                                          //> res10: Double = 2.0
   
 // conditional - logical
 val canVote = if(randInt>18) "yes" else "no"     //> canVote  : String = yes
 
 
}