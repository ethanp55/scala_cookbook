object MethodsWithSimpleGenerics extends App {
  // Randomly selects an element from a sequence
  // Since we are using generics, this sequence can be a sequence of numbers, strings, etc.
  def randomElement[A](seq: Seq[A]): A = {
    val randomNum = util.Random.nextInt(seq.length)
    seq(randomNum)
  }

  println(randomElement(Seq("Foo", "Bar", "Baz")))

  println(randomElement(List(1, 2, 3)))

  println(randomElement(List(4.0, 5.0, 6.0)))
}