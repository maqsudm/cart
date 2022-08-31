package uk.mercator.service

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite
import uk.mercator.model.{Apple, Orange}


class CheckoutServiceTest extends AnyFunSuite with BeforeAndAfter{

  var checkoutService: CheckoutService = _

  before{
    checkoutService = new CheckoutService
  }

  test("passing an empty basket returns zero"){
      val total = checkoutService.calculateBasketCost(List.empty)
      assert(total.equals(0))
  }

  test("passing a basket with 1 Apple returns .60"){
    val apple = new Apple
    val items = List(apple)
    val total = checkoutService.calculateBasketCost(items)
    assert(total.equals(BigDecimal(.6)))
  }

  test("passing a basket with 1 Orange returns .25"){
    val orange = new Orange
    val items = List(orange)
    val total = checkoutService.calculateBasketCost(items)
    assert(total.equals(BigDecimal(.25)))
  }

  test("passing a basket with 3 Apples returns 1.20"){
    val apple = new Apple
    val apple1 = new Apple
    val apple2 = new Apple
    val items = List(apple, apple1, apple2)
    val total = checkoutService.calculateBasketCost(items)
    assert(total.equals(BigDecimal(1.2)))
  }

  test("passing a basket with 1 Apple and 1 orange returns .85"){
    val apple = new Apple
    val orange = new Orange
    val items = List(apple, orange)
    val total = checkoutService.calculateBasketCost(items)
    assert(total.equals(BigDecimal(.85)))
  }

  test("passing a basket with 3 Apples and 1 orange returns 1.45"){
    val apple = new Apple
    val apple1 = new Apple
    val apple2 = new Apple
    val orange = new Orange
    val items = List(apple, apple1, orange, apple2)
    val total = checkoutService.calculateBasketCost(items)
    assert(total.equals(BigDecimal(1.45)))
  }

  test("passing a basket with 3 Apples and 2 oranges returns 1.45"){
    val apple = new Apple
    val apple1 = new Apple
    val apple2 = new Apple
    val orange = new Orange
    val orange1 = new Orange
    val items = List(apple, apple1, orange, apple2, orange1)
    val total = checkoutService.calculateBasketCost(items)
    assertResult(BigDecimal(1.70)){
      total
    }
  }


  test("passing a basket with 3 Apples and 3 oranges with offer applied returns 1.70"){
    val apple = new Apple
    val apple1 = new Apple
    val apple2 = new Apple
    val orange = new Orange
    val orange1 = new Orange
    val orange2 = new Orange
    val items = List(apple, apple1, orange, apple2, orange1, orange2)
    val total = checkoutService.calculateBasketCost(items)
    assert(total.equals(BigDecimal(1.70)))
  }

  test("passing a basket with 1 Apple and 5 oranges with offer applied returns 1.60"){
    val apple = new Apple
    val orange3 = new Orange
    val orange4 = new Orange
    val orange = new Orange
    val orange1 = new Orange
    val orange2 = new Orange
    val items = List(apple, orange3, orange, orange4, orange1, orange2)
    val total = checkoutService.calculateBasketCost(items)
    assertResult(BigDecimal(1.60)){
      total
    }
  }


}
