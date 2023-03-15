object CharactersFrequency extends App {

  val input = scala.io.StdIn.readLine()
  def build(source: String, result: Map[Char,Int]): Map[Char,Int] =
    if (source.nonEmpty) {
      val c = source.head
      val freq = c -> (result.getOrElse(c, 0) + 1)
      build(source.tail, result ++ Map(freq))
    } else
      result
   println(build(input, Map.empty[Char, Int]).mkString(","))
}