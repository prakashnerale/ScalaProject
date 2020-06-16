object MultipleConstructors extends App{
  
  /*val s1 = new Student(1001,"Edureka")
  s1.showDetails()
  
  val s2 = new Student(1002,"Lenevo",30)
  s2.showDetails()
  
  val s3 = new Student("edureka@gmail.com")
  s3.showDetails()*/
  
}

class Student(id:Int,name:String){
  var age =0
  var email=""
  
  def showDetails(){
    println("ID :"+id+" - Name : "+name+" Age: "+age +" Email: "+email)
  }
  
  def this(id:Int,name:String,age:Int){
    this(id,name)
    this.age = age
  }
  
  def this(email:String){
    this(0,"")
    this.email=email
  }
}