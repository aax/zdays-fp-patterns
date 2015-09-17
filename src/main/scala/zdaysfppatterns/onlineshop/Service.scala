package zdaysfppatterns.onlineshop

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Service {
  private lazy val users = Map("John" -> User(1, "John"), "Sarah" -> User(2, "Sarah"))
  private lazy val orders = Map(1 -> Order(100, Invoice(50)), 2 -> Order(101, Invoice(122)))

  def loadUserOrNull(name: String): User = users.get(name).getOrElse(null)
  def loadOrderOrNull(userId: Int): Order = orders.get(userId).getOrElse(null)

  def loadUser(name: String): Option[User] = users.get(name)
  def loadOrder(userId: Int): Option[Order] = orders.get(userId)

  def loadUserAsync(name: String): Future[Option[User]] = Future(users.get(name))
  def loadOrderAsync(userId: Int): Future[Option[Order]] = Future(orders.get(userId))
}
