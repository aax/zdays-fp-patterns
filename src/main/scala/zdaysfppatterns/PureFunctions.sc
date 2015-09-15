import scala.util.{Failure, Success, Try, Random}

object ExternalSystem {
  def doRequest() = {
    if( new Random().nextDouble() > 0.9 ) {
      "a response value!"
    } else {
      throw new IllegalStateException("External System failed")
    }
  }
}

def pureSum(x: Int, y: Int ) = { x + y }

def calculateImpure() = {
  println("Calculating now")
  ExternalSystem.doRequest()
}

def calculatePure(): Try[String] = {
  Try(ExternalSystem.doRequest())
}

val result = for {
  firstResponse <- calculatePure()
  secondResponse <- calculatePure()
  thirdResponse <- calculatePure()
} yield firstResponse + secondResponse + thirdResponse

result match {
  case Success(value) => println(value)
  case Failure(e) => println(e.getMessage)
}