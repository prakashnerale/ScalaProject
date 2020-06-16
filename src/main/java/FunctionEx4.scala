

object FunctionEx4 extends App {

  def fact(n: Int=4): Int = {
    if (n == 0) {
      1
    } else {
      n * fact(n - 1)
    }
  }
  
  println(fact())
  println(fact(5))
}