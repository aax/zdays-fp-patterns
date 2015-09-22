import zdaysfppatterns.onlineshop._

import scala.collection.mutable

/**
 * TODO: get IDs of items, that
 * - are similar to an item in the shopping cart,
 * - but have a higher rating
 */

val items = Vector(Item(103, 59, 3), Item(117, 39, 4), Item(351, 79, 2))

// version 1
val suggestions = new mutable.MutableList[Int]()
for (item <- items) {
  val similarItems = Inventory.getSimilarItems(item)
  for (similarItem <- similarItems) {
    if (similarItem.rating > item.rating) {
      suggestions += similarItem.id
    }
  }
}
suggestions


// version 2
def computeSuggestions(item: Item): Seq[Int] = {
  val similarItems = Inventory.getSimilarItems(item)
  val suggestedItems = similarItems.filter(other =>
    other.rating > item.rating)
  suggestedItems.map(item => item.id)
}

val suggestions2 = items.flatMap(item => computeSuggestions(item))













// version 3
val suggestions3 = for {
  item <- items
  similarItem <- Inventory.getSimilarItems(item)
  if similarItem.rating > item.rating
} yield similarItem.id