object FunctionsAsVariables extends App {
  // We can create a function variable
  val hypotenuse = (a: Double, b: Double) => {
    Math.pow(Math.pow(a, 2) + Math.pow(b, 2), 0.5)
  }
  val c = hypotenuse(2, 2)
  println(c)

  // We can also pass the function variable to other functions as if it were a regular variable
  def applyHypotenus(a: Double, b: Double, func: (Double, Double) => Double): Double = {
    func(a, b)
  }
  val newC = applyHypotenus(4, 5, hypotenuse)
  println(newC)
}