object ImmutabilityRunner extends App {

  val list = List(1, 2, 3)
  println(list)

  val otherList = 1 :: 2 :: 3 :: List()
  println(otherList)

  val appendFour = list :+ 4
  println(appendFour)

  val prependZero = 0 +: appendFour
  println(prependZero)

  val tail = prependZero.tail
  println(s"tail of $prependZero is $tail")
  val head = prependZero.head
  println(s"head of $prependZero is $head")
  val tailHead = prependZero.tail.head
  println(s"tail.head of $prependZero is $tailHead")

  val names = scala.collection.mutable.ArrayBuffer("ivo", "hendrik")
  val languages = List("Scala", "Java", "Ruby")
  val container = (names, languages)
  println(container)

  names.clear()
  println(container)

  names += "max"
  names += "muster"
  println( container )
}
