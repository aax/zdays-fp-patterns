import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

val future = Future {
  Thread.sleep(2000)
  "finished"
}

val future2 = future.map(msg => "computation " + msg)
val future3 = future2.flatMap( msg =>
  Future {
    msg + "!!!"
  }
)

"program finished"

Await.result(future3, 3.seconds)