

object AnonymousFunc extends App {

  val x = List(1, 2, 3, 4, 5)
  //  x.foreach(ele => println(ele))
  //  x.foreach(println)

  //  (1 to 10).map(_ * 10).foreach(println)
  //  (1 to 10).map(ele => ele * 10).foreach(println)
  println((1 to 10).reduceLeft(_ + _))
  println((1 to 10).reduceLeft(_ min _))
  println((1 to 10).reduceLeft(_ max _))
}