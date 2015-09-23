// functions
def myFunction(a: Int): Boolean = {
  a < 0
}

// value declaration, generic types
val myList: List[Int] = List(1, 2, 3)

// anonymous function/lambda expression
(myNumber: Int, yourNumber: Int) => myNumber + yourNumber

// higher-order function application
myList.exists(n => myFunction(n))
