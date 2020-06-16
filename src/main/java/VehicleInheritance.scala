
class Vehicle(speed : Int){
  val mph = speed
  
  def race() = {println("Racing")}
}

class car(speed:Int) extends Vehicle(speed){
  override val mph =speed
  
  override def race() = {println("car Racing")}
}

class Bike(speed:Int) extends Vehicle(speed){
  override val mph =speed
  
  override def race() = {println("Bike Racing")}
}



object VehicleInheritance extends App {
  val vehicle1 = new car(200)
  vehicle1.race()
  
  val vehicle2 = new Bike(100)
  vehicle2.race()
}

