import zdaysfppatterns.onlineshop._
import Service._

// version 1
val user: User = loadUserOrNull("John")
var invoice: Invoice = null
if (user != null) {
  val order = loadOrderOrNull(user.id)
  if (order != null) {
    invoice = order.invoice
  }
}
if (invoice != null) {
  println(invoice)
}

// version 2
val userOption: Option[User] = loadUser("John")
val orderOption: Option[Order] = userOption.flatMap(user => loadOrder(user.id))
val invoiceOption: Option[Invoice] = orderOption.map(order => order.invoice)

invoiceOption.foreach { invoice =>
  println(invoice)
}

// version 3
for {
  user <- loadUser("John")
  order <- loadOrder(user.id)
  invoice = order.invoice
} {
  println(invoice)
}