object Fibonacci extends App {

  def printNumber(last: Int, current: Int, count: Int): Unit =
    if (count > 0) {
      println(last)
      printNumber(current, current + last, count - 1)
    }

  printNumber(0, 1, 20)
}