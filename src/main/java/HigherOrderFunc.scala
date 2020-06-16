

object HigherOrderFunc extends App {

  // Higher order function.
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b)0 else f(a) + sum(f, a + 1, b)
  }

  
  def sumCubesOld(a: Int, b: Int):Int = {
    if (a > b) {
      0
    } else {
      cube(a) + sumCubesOld(a + 1, b)
    }
  }
  
  // Sum cubes from a to b
  def cube(x: Int) = { x * x * x }

  def sumCubes(a: Int, b: Int) = {
    sum((x: Int) => x * x * x, a, b)
  }

  println(sumCubes(1, 3))

}