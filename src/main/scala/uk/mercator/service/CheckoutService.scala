package uk.mercator.service

import uk.mercator.model.BasketProduct

class CheckoutService {

  def calculateBasketCost(basketItems: List[BasketProduct]):BigDecimal = {
    var total:BigDecimal=BigDecimal(0)
    if(basketItems.isEmpty) {
      total = BigDecimal(0)
    }
    for(basketItem <- basketItems){
      total += basketItem.getCost()
    }
    total
  }

}
