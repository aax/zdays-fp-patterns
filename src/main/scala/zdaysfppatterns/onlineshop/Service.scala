package zdaysfppatterns.onlineshop

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Try

object Service {
  private lazy val users = Map("John" -> User(1, "John"), "Sarah" -> User(2, "Sarah"))
  private lazy val orders = Map(1 -> Order(100, Invoice(50)), 2 -> Order(101, Invoice(122)))

  def loadUserOrNull(name: String): User = users.get(name).getOrElse(null)
  def loadOrderOrNull(userId: Int): Order = orders.get(userId).getOrElse(null)

  def findUser(name: String): Option[User] = users.get(name)
  def findOrder(userId: Int): Option[Order] = orders.get(userId)

  def loadUserAsync(name: String): Future[User] = Future(users(name))
  def loadOrderAsync(userId: Int): Future[Order] = Future(orders(userId))
}
