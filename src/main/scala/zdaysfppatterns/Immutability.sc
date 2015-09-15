// Constructing lists
val list = List(1, 2, 3)

val otherList = 1 :: 2 :: 3 :: List()

// appending / prepending
val appendFour = list :+ 4
val prependZero = 0 +: appendFour

// Updating lists
val updated = prependZero.updated(2, 10)

// List traversal
val tail = prependZero.tail
val head = prependZero.head
val tailHead = prependZero.tail.head

// Mutable list mutation
val names = scala.collection.mutable.ArrayBuffer("ivo", "hendrik")
val languages = List("Scala", "Java", "Ruby")
val container = (names, languages)

names.clear()
names += "max"
names += "muster"
