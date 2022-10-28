object PartialFunctions extends App {
  // Partial functions define a few useful methods, like the isDefinedAt method
  // The [Int, Int] syntax means the partial function takes an int and outputs an int; you could have other cases like
  // [Int, String] (takes an int, outputs a string), etc.
  val divide = new PartialFunction[Int, Int] {
    def apply(x: Int): Int = 42 / x

    def isDefinedAt(x: Int): Boolean = x != 0
  }

  println(divide.isDefinedAt(1))
  println(divide.isDefinedAt(0))
  println(divide(1))

  // Rather than overriding the isDefinedAt method, you can use cases and the isDefinedAt method is determined
  // dynamically
  val divideWithCases: PartialFunction[Int, Int] = {
    case x if x != 0 => 42 / x
  }

  println(divideWithCases.isDefinedAt(1))
  println(divideWithCases.isDefinedAt(0))
  println(divideWithCases(1))

  // You can also combine partial functions with orElse and andThen
  val convertEven: PartialFunction[Int, Int] = {
    case x if x % 2 == 0 => x + 1
  }

  val convertOdd: PartialFunction[Int, Int] = {
    case x if x % 2 != 0 => x + 1
  }

  val convertAll: PartialFunction[Int, Int] = convertEven orElse convertOdd  // Can convert both even and odd numbers

  println(convertAll(2))
  println(convertAll(3))

  // Partial functions are also used in many Scala collections APIs, like the collect method
  try {
    val dividedListWithMap = List(0, 1, 2).map(divide)  // Map does not check the isDefinedAt method
  } catch {
    case _ => println("Map does not check the isDefinedAt method")
  }

  val dividedListWithCollect = List(0, 1, 2).collect(divide)  // However, collect does check the isDefinedAt method
  println(dividedListWithCollect)
}