package cat.pseudocodi

import java.io.InputStream
import java.util.Scanner

/**
  * https://www.hackerrank.com/challenges/angry-professor
  *
  * @author fede
  */
object AngryProfessor {

  def main(args: Array[String]): Unit = {
    doIt(System.in).foreach(println)
  }

  def doIt(stream: InputStream): Seq[String] = {
    val sc = new Scanner(stream)
    val testCases = sc.nextInt
    val lectures: Seq[Lecture] = for {
      i <- 1 to testCases
      students = sc.nextInt
      minAttendance = sc.nextInt
      arrivalTimes: Seq[Int] = for (j <- 1 to students) yield sc.nextInt
    } yield new Lecture(minAttendance, arrivalTimes)
    lectures.map(l => l.arrivalTimes.count((i: Int) => i < 1) >= l.threshold).map((b: Boolean) => if (b) "NO" else "YES")
  }

  case class Lecture(threshold: Int, arrivalTimes: Seq[Int])

}
