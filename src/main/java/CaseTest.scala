case class Book(isbn: String)

object CaseTest extends App{
  val b1 = Book("12345ABC")
  val b2 = Book("12345ABC")
  val b3 = Book("12AB123C")
  
  println(b1==b2)
  println(b1==b3)
}