object MapTransformation extends App {
  val map = Map.empty + ("Alice" -> "apple") + ("Bob" -> "orange")
  val lengths =
    map
      .filter(pair => pair._2.contains('e'))
      .map(pair => pair._1.length)
      .filter(l => l > 0)
      .toSet
  val list = (lengths - 3).toList
  println(list.head)
}