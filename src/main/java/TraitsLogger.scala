trait Logger1 {
  def log(msg: String) // An abstract method
  
  def doStuff(msg:String){
    println(msg)
  }
}

class ConsoleLogger1 extends Logger1 {
  def log(msg: String) 
  { 
      println(msg) 
  } // No override needed
  
  override def doStuff(msg:String){
    println(msg)
  }
}

object Main1 extends App {
  val logger = new ConsoleLogger1
  var logger1 = new ConsoleLogger1()
  logger.log("Hi..! I am printing from Main..!!")
}