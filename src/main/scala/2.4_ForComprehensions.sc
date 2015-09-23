import Service._
import Inventory._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration._



// lists
val suggestions = for {
  item <- List(Item(103, 3), Item(117, 4))
  similarItem <- getSimilarItems(item)
  if similarItem.rating > item.rating
} yield similarItem.id



// options
val optionalInvoice = for {
  user <- findUser("John")
  order <- findOrder(user.id)
} yield order.invoice



// futures
val asyncInvoice = for {
  user <- loadUserAsync("John")
  order <- loadOrderAsync(user.id)
} yield order.invoice

Await.result(asyncInvoice, 1.second)