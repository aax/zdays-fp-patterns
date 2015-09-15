import scala.util.{Failure, Success, Try, Random}

object ExternalSystem {
  def doRequest() = {
    if( new Random().nextDouble() > 0.2 ) {
      "a response value!"
    } else {
      throw new IllegalStateException("External System failed")
    }
  }
}

def calculateImpure() = {
  println("Calculating now")
  ExternalSystem.doRequest()
}

def calculate(): Try[String] = {
  Try(ExternalSystem.doRequest())
}

val result = for {
  firstResponse <- calculate()
  secondResponse <- calculate()
  thirdResponse <- calculate()
} yield firstResponse + secondResponse + thirdResponse

result match {
  case Success(value) => println(value)
  case Failure(e) => println(e.getMessage)
}