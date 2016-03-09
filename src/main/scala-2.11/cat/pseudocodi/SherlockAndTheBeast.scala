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
    for (i <- 1 to t) {
      val n = sc.nextInt()
      println(decentNumber(n))
    }
  }

  def decentNumber(numDigits: Int): Long = {
    try {
      val longs: Seq[Long] = for {
        a <- 0 to numDigits
        b = numDigits - a
        num = (a, b) match {
          case (`a`, `b`) if `a` % 3 == 0 && `b` % 5 == 0 => List.concat(Range(0, a).map(n => "5"), Range(0, b).map(n => "3")).mkString.toLong
          case (`a`, `b`) if `a` % 5 == 0 && `b` % 3 == 0 => List.concat(Range(0, b).map(n => "5"), Range(0, a).map(n => "3")).mkString.toLong
          case _ => -1
        }
      } yield num
      longs.foldLeft(-1l)((i: Long, l: Long) => Math.max(i, l))
    } catch {
      case nfe: NumberFormatException => -1
    }
  }

}
