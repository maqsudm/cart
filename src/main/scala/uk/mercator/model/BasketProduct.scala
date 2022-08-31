package uk.mercator.model

trait BasketProduct {

  def getCost: BigDecimal

  def calculateTotal(basketCount: BigInt): BigDecimal
}
