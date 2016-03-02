package cat.pseudocodi

import java.io.InputStream

/**
  * https://www.hackerrank.com/challenges/angry-professor
  *
  * @author fede
  */
object AngryProfessor {

  def main(args: Array[String]): Unit = {
    doIt(System.in).foreach(println)
  }

  def doIt(stream: InputStream): List[String] = {
    val sc = new java.util.Scanner(stream)
    var lectures: List[Lecture] = List()
    val testCases = sc.nextInt
    for (i <- 1 to testCases) {
      val students = sc.nextInt
      val minAttendance = sc.nextInt
      var lecture = new Lecture(minAttendance, List())
      for (j <- 1 to students) {
        val arrivalTime = sc.nextInt
        lecture = new Lecture(minAttendance, arrivalTime :: lecture.arrivalTimes)
      }
      lectures = lectures ::: List(lecture)
    }
    lectures.map(l => l.arrivalTimes.count((i: Int) => i < 1) >= l.threshold).map((b: Boolean) => if (b) "NO" else "YES")
  }

  case class Lecture(threshold: Int, arrivalTimes: List[Int])

}
