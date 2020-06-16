package PrakashFiles


import PrakashFiles.Student

object StudentTest extends App{
  val s1 = new Student(1001,"Prakash")
  s1.showDetails()
  
  val s2 = new Student(1002,"Edureka",30)
  s2.showDetails()
  
  val s3 = new Student("edureka@gmail.com")
  s3.showDetails()
}