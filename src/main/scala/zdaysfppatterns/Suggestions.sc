import zdaysfppatterns.onlineshop._

import scala.collection.mutable

val cart = ShoppingCart(Vector(Item(103, 59, 3), Item(117, 39, 4), Item(351, 79, 2)))

// version 1
val suggestions = new mutable.MutableList[Item]()
for (item <- cart.items) {
  val similarItems = Inventory.getSimilarItems(item)
  for (similarItem <- similarItems) {
    if (similarItem.rating > item.rating) {
      suggestions += similarItem
    }
  }
}
suggestions


// version 2
def computeSuggestions(item: Item): Seq[Item] = {
  val similarItems = Inventory.getSimilarItems(item)
  similarItems.filter(_.rating > item.rating)
}

val suggestions2 = cart.items.flatMap(item => computeSuggestions(item))