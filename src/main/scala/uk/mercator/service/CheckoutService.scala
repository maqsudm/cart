package uk.mercator.service

import uk.mercator.model.{Apple, BasketProduct, Orange}

import java.text.NumberFormat
import java.util.Locale

class CheckoutService {

  /**
   * I take a list of BasketProduct type and calculate the
   * basket total based on the discount rules set for each product.
   *
   * @param basketItems list of basketProduct types
   * @return formattedBasketTotal in UK currency
   */
  def calculateBasketCost(basketItems: List[BasketProduct]):String = {
    var total:BigDecimal=BigDecimal(0)
    if(basketItems.isEmpty) {
      total = BigDecimal(0)
    }else{
      val apple = new Apple
      val orange = new Orange
      total = apple.calculateTotal(basketItems.count(bi => bi.isInstanceOf[Apple]))
        .+(orange.calculateTotal(basketItems.count(bi => bi.isInstanceOf[Orange])))
    }
    val nf = NumberFormat.getCurrencyInstance(Locale.UK)
    nf.format(total)
  }

}
