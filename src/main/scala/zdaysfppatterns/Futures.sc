import zdaysfppatterns.onlineshop.Service._
import zdaysfppatterns.onlineshop.{Invoice, Order, User}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

// version 1
val asyncUser = loadUserAsync("John")
val asyncOrder: Future[Order] = asyncUser.flatMap(user => loadOrderAsync(user.id))
val asyncInvoice: Future[Invoice] = asyncOrder.map(order => order.invoice)

// leaving the box
asyncInvoice.foreach { invoice =>
  println(invoice)
}

Await.result(asyncInvoice, 1.second)

// version 2
val invoiceFuture2 = for {
  user <- loadUserAsync("John")
  order <- loadOrderAsync(user.id)
} yield order.invoice


Await.result(invoiceFuture2, 1.second)