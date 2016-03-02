package cat.pseudocodi

import java.io.ByteArrayInputStream

import org.scalatest.FunSuite

/**
  * @author fede
  */
class AngryProfessorSuite extends FunSuite {

  test("The professor wants at least 3 students in attendance, but only 2 have arrived on time, then the class is canceled.") {
    val stream: ByteArrayInputStream = new ByteArrayInputStream("1\n4\n3\n-1\n-3\n4\n2".getBytes)
    assert(AngryProfessor.doIt(stream) === List("YES"))
  }

  test("The professor wants at least 2 students in attendance, and there are 2 who have arrived on time, then the class is not canceled") {
    val stream: ByteArrayInputStream = new ByteArrayInputStream("1\n4\n2\n0\n-1\n2\n1".getBytes)
    assert(AngryProfessor.doIt(stream) === List("NO"))
  }

  test("two lectures") {
    val stream: ByteArrayInputStream = new ByteArrayInputStream("2\n4\n3\n-1\n-3\n4\n2\n4\n2\n0\n-1\n2\n1".getBytes)
    assert(AngryProfessor.doIt(stream) === List("YES", "NO"))
  }
}