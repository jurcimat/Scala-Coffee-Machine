object BabylonianSquareRoot extends App {

  def sqrt(r: Int, x: Int = ???): Int = {
    if (x * x != r)
      sqrt(r, ???)
    else
      x
  }
  println(sqrt(207936))
}