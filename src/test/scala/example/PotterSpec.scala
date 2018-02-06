package example

import org.scalatest._

class PotterSpec extends FlatSpec with Matchers {

  "Potter" should "Test Basic" in {
    Potter.price(Seq()) should be(0)
    Potter.price(Seq(0)) should be(8)
    Potter.price(Seq(1)) should be(8)
    Potter.price(Seq(2)) should be(8)
    Potter.price(Seq(3)) should be(8)
    Potter.price(Seq(4)) should be(8)

    Potter.price(Seq(0, 0)) should be(8 * 2)
    Potter.price(Seq(1, 1, 1)) should be(8 * 3)
  }

  "Potter" should "test simple discount" in {
    Potter.price(Seq(0, 1)) should be(8 * 2 * 0.95)
    Potter.price(Seq(0, 2, 4)) should be(8 * 3 * 0.9)
    Potter.price(Seq(0, 1, 2, 4)) should be(8 * 4 * 0.8)
    Potter.price(Seq(0, 1, 2, 3, 4)) should be(8 * 5 * 0.75)
  }

  "Potter" should "test several discounts" in {
    Potter.price(Seq(0, 0, 1)) should be( 8 + (8 * 2 * 0.95) )
    Potter.price(Seq(0, 0, 1, 1)) should be( 2 * (8 * 2 * 0.95) )
    Potter.price(Seq(0, 0, 1, 2, 2, 3)) should be(( 8 * 4 * 0.8) + (8 * 2 * 0.95) )
    Potter.price(Seq(0, 1, 1, 2, 3, 4)) should be(8 + (8 * 5 * 0.75) )
  }

  /*
  "Potter" should "test edge cases" in {
    Potter.price(Seq(0, 0, 1, 1, 2, 2, 3, 4)) should
      be( 2 * (8 * 4 * 0.8) )
    Potter.price(Seq(
      0, 0, 0, 0, 0,
      1, 1, 1, 1, 1,
      2, 2, 2, 2,
      3, 3, 3, 3, 3
    )) should be( 3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8) )

  }
  */

}
