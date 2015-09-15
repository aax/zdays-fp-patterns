package zdaysfppatterns.onlineshop

object Inventory {

  lazy val items: Seq[Item] = {
    (0 to 100).map { id =>
      val price = id / 2
      val rating = ((id + 3) % 5) + 1
      Item(id, price, rating)
    }
  }


  def getSimilarItems(item: Item): Seq[Item] = {
    items.filter(_.id / 10 % 10 == item.id / 10 % 10)
  }

  def getItem(id: Int): Option[Item] = {
    items.find(_.id == id)
  }
}
