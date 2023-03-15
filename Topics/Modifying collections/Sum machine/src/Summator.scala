object Summator extends App {
  val inputDefinitions = scala.io.StdIn.readLine()
  val inputExpression = scala.io.StdIn.readLine()
  var variables = Map.empty[String, Int]
  inputDefinitions
    .split(',')
    .filter(!_.isEmpty)    
    .map { _.split('=') }
    .map { arr => variables += arr(0) -> arr(1).toInt}
  println(inputExpression.split('+').map( char => variables.getOrElse(char,0)).sum)
}