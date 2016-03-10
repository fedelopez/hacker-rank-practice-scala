package cat.pseudocodi

/**
  * https://www.hackerrank.com/challenges/sherlock-and-the-beast
  *
  * A Decent Number has the following properties:
  * - Its digits can only be 3's and/or 5's.
  * - The number of 3's it contains is divisible by 5.
  * - The number of 5's it contains is divisible by 3.
  *
  * @author fede
  */
object SherlockAndTheBeast {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val t = sc.nextInt()
    val digits: Seq[Int] = for {
      i <- 1 to t
      n = sc.nextInt()
    } yield n
    digits.foreach(i => println(decentNumber(i)))
  }

  //todo no side effects
  def decentNumber(numDigits: Int): String = {
    val s: scala.collection.mutable.ArrayBuffer[String] = scala.collection.mutable.ArrayBuffer.empty[String]
    for (a <- numDigits to numDigits / 2 by -1) {
      val b: Int = a - numDigits
      if (s.length < 2) {
        val res = number(a, Math.abs(b))
        if (!res.equals("-1")) {
          s += res
        }
      }
    }
    if (s.isEmpty) "-1"
    else s.sorted.reverse.head
  }

  def number(a: Int, b: Int): String = {
    if (a % 3 == 0 && b % 5 == 0) toNumberString(a, b)
    else if (a % 5 == 0 && b % 3 == 0) toNumberString(b, a)
    else "-1"
  }

  def toNumberString(a: Int, b: Int): String = {
    List.concat(Range(0, a).map(n => "5"), Range(0, b).map(n => "3")).mkString
  }
}
