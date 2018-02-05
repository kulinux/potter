package example

object Potter {

  def priceOld(books: Seq[Int]) : Double = {
    val totalPrice = books.foldLeft(0.0)((a, b) => (a + 8)  )
    totalPrice * (1 - calculateDiscount(books.distinct.size))
  }



  def price(books : Seq[Int]) : Double = {
    if(books.size == 0) 0.0
    val distinctBooks = books.distinct
    val booksAndCount = distinctBooks.map( x => (x, books.filter(_ == x).size ) )

    val distinct = booksAndCount
      .map( (x) => (x._1, x._2 - 1) )
      .filter( x => x._2 >= 0)
      .map( x => x._1 )

    val onRound = priceOld(distinct)

    val rest = books.filter( x => distinct.contains(x))

    onRound + price(rest)
    /*

    val priceBooksWithoutDiscount = distinct * 8

    val totalPrice = (books - distinctBooks).foldLeft(0.0)((a, b) => (a + 8)  )

    priceBooksWithoutDiscount + (totalPrice * (1 - calculateDiscount(books.distinct.size)))
    */

  }


  def price(books : Seq[Int]) : Double = {
    if(books.size == 0) 0.0
    val distinctBooks = books.distinct
    val booksAndCount = distinctBooks.map( x => (x, books.filter(_ == x).size ) )

    val distinct = booksAndCount
      .map( (x) => (x._1, x._2 - 1) )
      .filter( x => x._2 >= 0)
      .map( x => x._1 )

    val onRound = priceOld(distinct)

    val rest = books.filter( x => distinct.contains(x))

    onRound + price(rest)
    /*

    val priceBooksWithoutDiscount = distinct * 8

    val totalPrice = (books - distinctBooks).foldLeft(0.0)((a, b) => (a + 8)  )

    priceBooksWithoutDiscount + (totalPrice * (1 - calculateDiscount(books.distinct.size)))
    */

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

