case class Address( street: String, city: String )
case class Person( firstName: String, lastName: String, address: Address )

val max = new Person( "Max", "Muster", Address("Steinstrasse", "Zurich") )

val maxGotMarried = max.copy(lastName = "Doe")

val maxMoved = maxGotMarried.copy(address = maxGotMarried.address.copy(street = "Farbhof"))