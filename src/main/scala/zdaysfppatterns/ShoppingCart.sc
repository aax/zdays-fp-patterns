import zdaysfppatterns.onlineshop._

val cart = ShoppingCart(Vector(Item(103, 59, 3), Item(117, 39, 4), Item(351, 79, 2)))

val amounts = cart.items.map{ item => item.price }

val total1 = amounts.fold(0) { (aggregator, amount) => aggregator + amount }
val total2 = amounts.fold(0)(_ + _)
val total3 = amounts.reduce(_ + _)
val total4 = amounts.sum

val suggestions = cart.items.flatMap(computeSuggestions(_))

def computeSuggestions(item: Item): Seq[Item] = {
  val similarItems = Inventory.getSimilarItems(item)
  similarItems.filter(_.rating > item.rating)
}
