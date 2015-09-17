package zdaysfppatterns.onlineshop

case class User(id: Int, name: String)
case class Order(id: Int, invoice: Invoice)
case class Invoice(amount: Int)