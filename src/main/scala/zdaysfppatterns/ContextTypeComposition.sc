import zdaysfppatterns.onlineshop.Service._
import scala.concurrent.ExecutionContext.Implicits.global

// chaining of options
val userNames = List("John", "Elvis")
val optionalUsers = userNames.flatMap( user => findUser(user))
val optionalOrder = optionalUsers.flatMap( user => findOrder(user.id))

// chaining of futures
val asyncUser = loadUserAsync("John")
val asyncOrders = asyncUser.flatMap( user => loadOrderAsync(user.id))

// for comprehension syntactic sugar
val results = for {
  userName <- userNames
  user <- findUser( userName )
  order <- findOrder( user.id )
} yield order

