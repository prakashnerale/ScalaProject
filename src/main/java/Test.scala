

object Test {

  def main(args: Array[String]): Unit = {
    var c1 = new Counter()
    println(c1.curr())
    
    c1.inc()
    c1.inc()
    c1.inc()
    c1.inc()
    c1.inc()
    
     println(c1.curr())
    
  }

}

class Counter {

  var count = 0

  def inc() { count += 1 }

  def curr() = count
}