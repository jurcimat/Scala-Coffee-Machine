import scala.io.StdIn._

object ScalaExample {
  def main(args: Array[String]) {
    // put your code here
    val name : String = scala.io.StdIn.readLine()
    val age : Int = scala.io.StdIn.readInt()
    val favouriteMovie : String = scala.io.StdIn.readLine()
    println("Hi, " + name + ", your age is " + age + ", your favorite movie is " + favouriteMovie)
  }
}