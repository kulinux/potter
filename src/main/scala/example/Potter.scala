package example

object Potter {

  def priceOld(books: Seq[Int]) : Double = {
    val totalPrice = books.foldLeft(0.0)((a, b) => (a + 8)  )
    totalPrice * (1 - calculateDiscount(books.distinct.size))
  }

  def contains(s: Seq[Int], ele: Int, r1: Int, r2: Int) = {
   s.contains(ele) match {
     case true => r1
     case false => r2
   }
  }

  def priceMap(booksAndCount : Map[Int, Int]) : Tuple2[Double, Map[Int, Int]] = {
    val round1 : Seq[Int] = booksAndCount.filter(p => p._2 > 0).keys.toSeq
    val price = priceOld(round1)
    val rest = booksAndCount.map(x => (x._1, contains(round1, x._1,  x._2 - 1, x._2)))
    (price, rest)
  }


  def price(books : Seq[Int]) : Double = {

    val booksAndCount = books.groupBy(identity).mapValues(_.size)

    val r1 = priceMap(booksAndCount)
    val r2 = priceMap(r1._2)
    val r3 = priceMap(r2._2)
    val r4 = priceMap(r3._2)
    val r5 = priceMap(r4._2)
    val r6 = priceMap(r5._2)
    val r7 = priceMap(r6._2)
    val r8 = priceMap(r7._2)

    r1._1 + r2._1 + r3._1 + r4._1 +
      r5._1 + r6._1 + r7._1 + r8._1
  }



  def calculateDiscount (distinctBooks: Int): Double  = {
    distinctBooks match {
      case 1 | 0 => 0.0
      case 2 => 0.05
      case 3 => 0.1
      case 4 => 0.2
      case 5 => 0.25
    }
  }
}

