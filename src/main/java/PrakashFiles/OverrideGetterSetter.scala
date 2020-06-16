package PrakashFiles

object OverrideGetterSetter {
  def main(args: Array[String]): Unit = {
    val l1 = new Lion()
    println(l1.age())
    l1.age_=(20)
    println(l1.age())
    l1.age_=(5)
    println(l1.age())
  }
}

class Lion {
  private var privateAge:Int = 0

  def age() = {
    privateAge
  }

  def age_=(newAge: Int) {
    // Validation Here.
    if (newAge > privateAge) {
      privateAge = newAge
    }
  }
}