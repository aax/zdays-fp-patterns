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
val optionalUser = findUser("John")
val optionalOrder = optionalUser.flatMap(user => findOrder(user.id))
val optionalInvoice = optionalOrder.map(order => order.invoice)

// leaving the box
optionalInvoice.foreach(invoice =>
  println(invoice))

optionalInvoice match {
  case Some(invoice) => println(invoice)
  case None => println("no invoice")
}

// version 3
val userNames = List("John", "Elvis")
val results = for {
  userName <- userNames
  user <- findUser(userName)
  order <- findOrder(user.id)
  invoice = order.invoice
} yield invoice