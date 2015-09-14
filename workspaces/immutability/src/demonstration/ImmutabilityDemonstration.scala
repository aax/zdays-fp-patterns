package demonstration

object ImmutabilityDemonstration extends App {

   println("Constructing lists")

   val list = List()
   println(list)

   val otherList = ???
   println(otherList)

   val appendFour = ???
   println(appendFour)

   val prependZero = ???
   println(prependZero)
   println()

   println("Updating lists")
   val updated = ???
   println(s"prependZero after update: $prependZero")
   println(s"updated after update: $updated")
   println()

   println("List traversal")
   val tail = ???
   println(s"tail of $prependZero is $tail")
   val head = ???
   println(s"head of $prependZero is $head")
   val tailHead = ???
   println(s"tail.head of $prependZero is $tailHead")
   println()

   println("Mutable list mutation")
   val names = scala.collection.mutable.ArrayBuffer("ivo", "hendrik")
   val languages = List("Scala", "Java", "Ruby")
   val container = (names, languages)
   println(container)

   println("Clearing names")
   names.clear()
   println(s"Container after clearing names: $container")

   names += "max"
   names += "muster"
   println( container )
 }
