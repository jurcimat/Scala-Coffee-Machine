object Greetings extends App {
  val name = scala.io.StdIn.readLine()
  val list = "Hello, " :: name :: "!" :: Nil
  println(list.mkString(""))
}
