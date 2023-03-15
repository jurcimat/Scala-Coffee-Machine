object Calculator extends App {

  val input = scala.io.StdIn.readLine().split(' ').toList
  input match {
    case a :: "+" :: b :: Nil if a.forall(_.isDigit) && b.forall(_.isDigit) =>
      println(a.toInt + b.toInt)
    case a :: "-" :: b :: Nil if a.forall(_.isDigit) && b.forall(_.isDigit) =>
      println(a.toInt - b.toInt)
    case _ => println("Unsupported expression")
  }
}