object WordsReverser extends App {
  val s = scala.io.StdIn.readLine()
  val result = s.reverse.split(" ").map(w => w.reverse).mkString(" ")
  println(result)
}