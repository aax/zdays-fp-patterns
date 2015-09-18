trait CreditCard {
  def charge( price: Double )
}

trait Payments {
  def charge( cc: CreditCard, price: Double)
}

case class Coffee( price: Double )
case class Charge( cc: CreditCard, price: Double )

class Cafe {
  def buyCoffeeStep1( cc: CreditCard ): Coffee = {
    val cup = new Coffee( 3 )
    cc.charge( cup.price )
    cup
  }

  def buyCoffeeStep2( cc: CreditCard, p: Payments ): Coffee = {
    val cup = new Coffee( 3 )
    p.charge(cc, cup.price)
    cup
  }

  def buyCoffeeStep3(cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee( 3 )
    (cup, Charge(cc, cup.price))
  }
}

// vermeiden von externen akkumulatoren
