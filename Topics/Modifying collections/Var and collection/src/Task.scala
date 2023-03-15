// You can experiment here, it won’t be checked
import org.apache.spark.sql.SparkSession

val spark = SparkSession
  .builder()
  .appName("Spark SQL basic example")
  .config("spark.some.config.option", "some-value")
  .getOrCreate()

// For implicit conversions like converting RDDs to DataFrames
import spark.implicits._
object Task {
  def main(args: Array[String]): Unit = {
    // put your code here
    val list = List("E1A7CA131B8CDCD5","2ED530818CE82769", "E1A7CA13")
    val result = new java.math.BigInteger("E1A7CA131B8CDCD5",16)  //pars(list(2),16)

    println(result)
  }
}
