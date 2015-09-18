import zdaysfppatterns.onlineshop.Service._
import zdaysfppatterns.onlineshop.{Invoice, Order, User}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

// version 1
val userFuture: Future[User] = loadUserAsync("John")
val orderFuture: Future[Order] = userFuture.flatMap(user => loadOrderAsync(user.id))
val invoiceFuture: Future[Invoice] = orderFuture.map(order => order.invoice)

invoiceFuture.foreach { invoice =>
  println(invoice)
}

Await.result(invoiceFuture, 1.second)

// version 2
val invoiceFuture2 = for {
  user <- loadUserAsync("John")
  order <- loadOrderAsync(user.id)
} yield order.invoice


Await.result(invoiceFuture2, 1.second)