package uk.mercator.model

class Apple extends BasketProduct {

  val cost: BigDecimal = BigDecimal(0.6)

  override
  def getCost: BigDecimal = {
    cost
  }

  /**
   * I calculate the cost of total
   * apples in the basket by applying
   * the discount rules. i.e
   * Buy 1 get 1 free
   *
   * if basket has less than 2 apples then no discount rules
   * are applied
   *
   * @param basketCount total apples in bag
   * @return
   */
  override
  def calculateTotal(basketCount: BigInt): BigDecimal = {
    var applesTotal=BigDecimal(0)
    if(basketCount==0) applesTotal
    else if(basketCount>1){
      val (quotient, remainder) = basketCount./%(2)
      applesTotal = getCost.*(BigDecimal(quotient)).+(getCost.*(BigDecimal(remainder)))
    }else applesTotal = getCost
    applesTotal
  }

}
