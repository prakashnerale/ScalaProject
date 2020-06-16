package PrakashFiles

object Test extends App {

  /*val arrBuff = new ArrayBuffer[Int]()
  arrBuff += 10 // arrBuff.+=(10)
  arrBuff += 100
  arrBuff -= 10
  arrBuff.foreach(println)*/

/*  val l = List(1, 2, 3)
  l.foreach(println)

  val l1 = 1 :: 2 :: 3 :: 4 :: Nil // LISP
  l1.foreach(println)
  
  val l2 = List.fill(3)("foo")
  l2.foreach(println)
  
  val l3 = List.range(1,10)
  l3.foreach(println)
  
  val l4 = List.tabulate(5)(n => n * n)
  print("-----------------")
  l4.foreach(println)
  print("-----------------")*/
  
  
  /*val fruits = new ListBuffer[String]()
  fruits += "Apple"
  fruits += "Orange"
  fruits += "Kiwi"
  fruits += "Strawberry"
  
  fruits -= "Apple"
  fruits.foreach(println)
  
  fruits.toList*/
  
/*  val tup = (100, "Prakash" , 200.0)
  println(tup._1)
  println(tup._2)
  println(tup._3)
  
  tup.productIterator.foreach(i => println("Value :"+i))
  
  println(tup.toString())*/
  
/*  var s = Set(1,2,3)
  var s2 = Set(4,5,6,6)
  println(s.isEmpty)
  println(s.head)
  println(s.tail)
  val s3 = s ++ s2*/
  
  val m = Map("name"->"Prakash","location"->"US")
  
  println(m.get("name"))
  println(m("name"))
  //println(m("address"))
  println(m.getOrElse("address", "KEY NOT FOUND"))
  
  
  
}
