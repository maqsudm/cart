package uk.mercator.model

class Apple extends BasketProduct {
  val cost: BigDecimal = BigDecimal(0.6)
  override def getCost(): BigDecimal = {
    cost
  }
}
