package cat.pseudocodi

import org.scalatest.FunSuite

/**
  * @author fede
  */
class SherlockAndTheBeastSuite extends FunSuite {

  test("For N=1, there is no decent number having 1 digit (so we print −1).") {
    assert(SherlockAndTheBeast.decentNumber(1) === "-1")
  }

  test("For N=2, there is no decent number having 2 digits (so we print −1).") {
    assert(SherlockAndTheBeast.decentNumber(2) === "-1")
  }

  test("For N=3, 555 is the only possible number. The number 5 appears three times in this number, so our count of 5's is evenly divisible by 3 (Decent Number Property 3).") {
    assert(SherlockAndTheBeast.decentNumber(3) === "555")
  }

  test("For N=4, there is no decent number having 2 digits (so we print −1).") {
    assert(SherlockAndTheBeast.decentNumber(4) === "-1")
  }

  test("For N=5, 33333 is the only possible number. The number 3 appears five times in this number, so our count of 3's is evenly divisible by 5 (Decent Number Property 2).") {
    assert(SherlockAndTheBeast.decentNumber(5) === "33333")
  }

  test("For N=6, 555555 is the only possible number. The number 5 appears six times in this number, so our count of 5's is evenly divisible by 3 (Decent Number Property 3).") {
    assert(SherlockAndTheBeast.decentNumber(6) === "555555")
  }

  test("For N=9, 555555555 is the only possible number. The number 3 appears nine times in this number, so our count of 5's is evenly divisible by 3 (Decent Number Property 3).") {
    assert(SherlockAndTheBeast.decentNumber(9) === "555555555")
  }

  test("For N=10, 3333333333 is the only possible number") {
    assert(SherlockAndTheBeast.decentNumber(10) === "3333333333")
  }

  test("For N=11, 55555533333 and all permutations of these digits are valid numbers; among them, the given number is the largest one.") {
    assert(SherlockAndTheBeast.decentNumber(11) === "55555533333")
  }

  test("For N=111") {
    val expected: String = List.concat(Range(0, 111).map(i => "5")).mkString
    assert(SherlockAndTheBeast.decentNumber(111) === expected)
  }

  test("For N=14, 55555555533333 and all permutations of these digits are valid numbers; among them, the given number is the largest one.") {
    assert(SherlockAndTheBeast.decentNumber(14) === "55555555533333")
  }

  test("For N=17, 55555555555533333 and all permutations of these digits are valid numbers; among them, the given number is the largest one.") {
    assert(SherlockAndTheBeast.decentNumber(17) === "55555555555533333")
  }

  test("For N=18, 555555555555555555 is the only possible number.") {
    assert(SherlockAndTheBeast.decentNumber(18) === "555555555555555555")
  }

  test("For N=19, 5555555553333333333 is the only possible number.") {
    assert(SherlockAndTheBeast.decentNumber(19) === "5555555553333333333")
  }

  test("For N=20, 33333333333333333333 is the only possible number.") {
    assert(SherlockAndTheBeast.decentNumber(20) === "55555555555555533333")
  }

  test("For N=100000") {
    val expected: String = List.concat(Range(0, 100000).map(i => "3")).mkString
    assert(SherlockAndTheBeast.decentNumber(100000).length === 100000)
  }
}