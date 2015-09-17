import zdaysfppatterns.onlineshop._

val cart = ShoppingCart(Vector(Item(103, 59, 3), Item(117, 39, 4), Item(351, 79, 2)))

// version 1
var total = 0
for (item <- cart.items) {
  total += item.price
}
total

// version 2
val amounts = cart.items.map{ item => item.price }

val total1 = amounts.fold(0) { (acc, amount) => acc + amount }
val total2 = amounts.fold(0)(_ + _)
val total3 = amounts.reduce(_ + _)

// version 3
val total4 = amounts.sum