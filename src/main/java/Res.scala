

object Res {
  private var lastResNum = 0
  
  private def doReservation()={
    lastResNum = lastResNum +1
    lastResNum
  }
}

class Res{
  val id = Res.doReservation()
  println(id)
}