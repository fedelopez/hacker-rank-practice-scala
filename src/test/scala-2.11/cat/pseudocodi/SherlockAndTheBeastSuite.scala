package cat.pseudocodi

import org.scalacheck.Gen
import org.scalatest._
import org.scalatest.prop._

/**
  * @author fede
  */
class SherlockAndTheBeastSuite extends PropSpec with PropertyChecks with ShouldMatchers {

  lazy val multiplesOfThree = for {
    n <- Gen.choose(1, 100000)
    leftOver = n % 3
  } yield n - leftOver

  lazy val multiplesOfFive = for {
    n <- Gen.choose(1, 100000)
    leftOver = n % 5
  } yield n - leftOver

  val myGen = for {
    n <- multiplesOfThree
    m <- multiplesOfFive
  } yield n + m

  property("for all N divisible by 3, its digits should only be 5's.") {
    forAll(multiplesOfThree) { (n: Int) =>
      val number: String = SherlockAndTheBeast.decentNumber(n)
      number should fullyMatch regex """5+"""
    }
  }

  property("for all N divisible by 5, its digits should be all 3's or 5's followed by 3's.") {
    forAll(multiplesOfFive) { (n: Int) =>
      val number: String = SherlockAndTheBeast.decentNumber(n)
      number should fullyMatch regex """(5+)|(5+3+)"""
    }
  }

  property("for all N divisible by 3, the resulting string should have N characters") {
    forAll(multiplesOfThree) { (n: Int) =>
      val number: String = SherlockAndTheBeast.decentNumber(n)
      number should have length n
    }
  }

  property("for all N divisible by 5, the resulting string should have N characters") {
    forAll(multiplesOfFive) { (n: Int) =>
      val number: String = SherlockAndTheBeast.decentNumber(n)
      number should have length n
    }
  }

  property("for all N not divisible by 3 or 5, yielding a decent number, its digits should be all 3's or 5's followed by 3's.") {
    forAll(myGen) { (n: Int) =>
      val number: String = SherlockAndTheBeast.decentNumber(n)
      number should fullyMatch regex """(5+)|(5+3+)"""
    }
  }
}