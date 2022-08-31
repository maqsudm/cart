package uk.mercator.service

import uk.mercator.model.{Apple, BasketProduct, Orange}

class CheckoutService {

  def calculateBasketCost(basketItems: List[BasketProduct]):BigDecimal = {
    var total:BigDecimal=BigDecimal(0)
    if(basketItems.isEmpty) {
      total = BigDecimal(0)
    }else{
      val apple = new Apple
      val orange = new Orange
      total = apple.calculateTotal(basketItems.count(bi => bi.isInstanceOf[Apple]))
        .+(orange.calculateTotal(basketItems.count(bi => bi.isInstanceOf[Orange])))
    }
    total
  }

}
