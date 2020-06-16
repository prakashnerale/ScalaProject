package common

object MyFirstExample extends App {
   
     var c1 = new Counter
     println(c1.curr())
     
     c1.inc()
     c1.inc()
     
     println(c1.curr())

}

class Counter{
  var count = 0
  
  def curr()=count
  
  def inc(){count+=1}
}