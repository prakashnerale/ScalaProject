package PrakashFiles

class Student(id: Int, name: String) {
  private var studentAge = 0
  private var studentEmail = "NA"

  def this(id:Int, name:String, age:Int){
    this(id,name)
    studentAge = age
  }
  
  def this(email: String){
    this(9999,"NA")
    studentEmail = email
  }
  
  def showDetails() {
    println(id + " " + name + " " + studentAge + " " + studentEmail)
  }
}