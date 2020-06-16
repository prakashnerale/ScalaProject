package PrakashFiles

object CounterTest extends App{
  val c1 = new Counter()
  println("Initial Value: "+c1.curr())
  c1.incr()
  c1.incr()
  c1.incr()
  c1.incr()
  c1.incr()
  println("Final Value: "+c1.curr())
  
}


class Counter {
  var count = 0 // Fields must be initilized.
  
  def incr() {
    count += 1
  }
  
  def curr() = {
    count
  }
}
