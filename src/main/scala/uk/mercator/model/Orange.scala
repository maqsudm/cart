package uk.mercator.model

class Orange extends BasketProduct {
  val cost: BigDecimal = BigDecimal(0.25)
  override def getCost(): BigDecimal = {
    cost
  }
}
