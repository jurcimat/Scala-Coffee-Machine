object RockPaperScissors extends App {
  val gameMap = Map(
    "rock" -> Map(
      "paper" -> "second win",
      "rock" -> "draw",
      "scissors" -> "first win"
    ),
    "paper" -> Map(
      "paper" -> "draw",
      "rock" -> "first win",
      "scissors" -> "second win",
    ),
    "scissors" -> Map(
      "paper" -> "first win",
      "rock" -> "second win",
      "scissors" -> "draw",
    )
  )

  val list = List(scala.io.StdIn.readLine(), scala.io.StdIn.readLine())
  val set = Set(list(0), list(1))
  if (set.size == 1)
    println("draw")
  else {
    val firstMap = gameMap(list.head)
    println(firstMap(list.tail.head))
  }
}