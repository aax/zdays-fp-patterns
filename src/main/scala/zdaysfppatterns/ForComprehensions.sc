import zdaysfppatterns.onlineshop.Service._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

// lists, options
val userNames = List("John", "Elvis")
val invoices = for {
  userName <- userNames
  user <- findUser(userName)
  order <- findOrder(user.id)
} yield order.invoice


// futures
val asyncInvoice = for {
  user <- loadUserAsync("John")
  order <- loadOrderAsync(user.id)
} yield order.invoice


Await.result(asyncInvoice, 1.second)