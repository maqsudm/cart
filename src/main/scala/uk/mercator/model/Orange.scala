package uk.mercator.model

class Orange extends BasketProduct {

  val cost: BigDecimal = BigDecimal(0.25)

  override
  def getCost: BigDecimal = {
    cost
  }

  /**
   *I calculate the cost of total
   * Oranges in the basket by applying
   * the discount rules. i.e
   * Buy 3 for price of 2
   *
   * if basket has less than 3 oranges then no discount rules
   * are applied
   *
   * @param basketCount total oranges in bag
   * @return
   */
  override
  def calculateTotal(basketCount: BigInt): BigDecimal = {
    var orangesTotal=BigDecimal(0)
    if(basketCount==0) orangesTotal
    else if(basketCount>2){
      val (quotient, remainder) = basketCount./%(3)
      orangesTotal = getCost.*(BigDecimal(quotient))
        .*(BigDecimal(3)
          .*(BigDecimal(2)))
        ./(BigDecimal(3))
        .+(getCost.*(BigDecimal(remainder)))
    }else orangesTotal = getCost.*(BigDecimal(basketCount))
    orangesTotal
  }

}
