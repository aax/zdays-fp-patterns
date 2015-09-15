import zdaysfppatterns.onlineshop.{Item, Inventory}

val maybeItem: Option[Item] = Inventory.getItem(100)
val maybeRating = maybeItem.map(item => item.rating)
val maybeRatingPercentage = maybeRating.map(rating => rating * 100 / 5)
