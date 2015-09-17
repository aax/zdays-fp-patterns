import zdaysfppatterns.onlineshop.{User, Service}

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

val userFuture: Future[Option[User]] = Service.loadUserAsync("John")

