import rillit.Lenser
import rillit._

case class Email( user: String, domain: String )
case class Contact( email: Email, web: String )
case class Person( name: String, contact: Contact )
val me = Person(
  name = "Hendrik",
  contact = Contact(
    email = Email("hendrik.schoeneberg", "zuehlke.com"),
    web = "www.zuehlke.com"
  )
)

val updatedNestedCopy = me.copy(
  contact = me.contact.copy(
    email = me.contact.email.copy(
      user = "hesc"
    )
  )
)

val updatedWithLens = Lenser[Person].contact.email.user.set(me, "withLens")