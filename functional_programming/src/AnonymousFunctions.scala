object AnonymousFunctions extends App {
  val x: List[Int] = List.range(1, 20)

  // The "(num: Int) => num % 2 != 0" piece is an anonymous function
  val odds: List[Int] = x.filter((num: Int) => num % 2 != 0)
  println(odds)

  // Note that this simplified version gives the same result
  val odds2: List[Int] = x.filter(_ % 2 != 0)
  println(odds == odds2)
}