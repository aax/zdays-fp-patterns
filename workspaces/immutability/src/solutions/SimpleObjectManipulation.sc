case class Address( street: String, city: String )
case class Person( age: Int, name: String, account: Int, address: Address )

val max = new Person( 30, "Max", 2000, Address("Wiesenstrasse", "Zurich") )
max.age

val hans = max.copy(name = "Hans")
hans.age

val julia = max.copy( name="Julia")
val juliaHasMoved =
  julia.copy( address = julia.address.copy(street = "Steinstrasse"))
