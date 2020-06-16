package common

object HigherOrderFuncExample extends App {

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) {
      return 0
    } else {
      return f(a) + sum(f, a + 1, b)
    }
  }

  def cube(n: Int): Int = { n * n * n }

  def sumCube(a: Int, b: Int) = { sum(n => n * n * n, a, b) }

  println(sumCube(1, 3))
  
}