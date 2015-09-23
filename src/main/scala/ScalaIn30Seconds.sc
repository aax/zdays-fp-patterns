def myFunction(a: Int): Boolean = {
  a < 0
}

val myList: List[Int] = List(1, 2, 3)

(myNumber: Int, yourNumber: Int) => myNumber + yourNumber

myList.exists(n => myFunction(n))
