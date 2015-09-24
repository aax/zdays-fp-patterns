import Service._



// version 1: using null
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



// version 2: using options
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













