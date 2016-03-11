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

  def decentNumber(numDigits: Int): String = {

    def doIt(a: Int, numbers: List[String]): String = {
      if (a > numDigits / 2 && numbers.length < 2) {
        val b: Int = Math.abs(a - numDigits)
        val res = number(a, b)
        if (res.equals("-1")) doIt(a - 1, numbers)
        else doIt(a - 1, res :: numbers)
      } else {
        val head: Option[String] = numbers.sorted.reverse.headOption
        head.getOrElse("-1")
      }
    }
    doIt(numDigits, List())
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
