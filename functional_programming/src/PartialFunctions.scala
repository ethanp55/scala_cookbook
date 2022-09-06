object PartialFunctions extends App {
  // A function that sums 3 variables
  val sum = (a: Int, b: Int, c: Int) => a + b + c

  // We can pass in 2 parameters to the sum function, creating a PARTIAL FUNCTION -> we can then use this partial
  // function later on
  val partialFunction = sum(2, 5, _)
  println(s"partialFunction type: ${partialFunction.getClass}")

  // 2 cases where we can use the partial function, but note that now we only need to pass in a single argument since
  // the first 2 have already been applied
  val res1 = partialFunction(7)
  val res2 = partialFunction(10)

  println(s"1st result: $res1")
  println(s"2nd result: $res2")
}