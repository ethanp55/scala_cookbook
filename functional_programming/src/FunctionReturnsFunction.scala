object FunctionReturnsFunction extends App {
  // Function that returns a function
  def saySomething(prefix: String): String => String = {
    (s: String) => s"$prefix $s"
  }

  // sayHello is now a function (since saySomething returns a function)
  val sayHello = saySomething("Hello")

  // We can now call sayHello and pass in a string
  println(sayHello("Ethan"))

  // A slightly more complicated example
  def greeting(language: String): String => String = {
    (name: String) => {
      language match {
        case "english" => s"Hello, $name"
        case "spanish" => s"Hola, $name"
      }
    }
  }

  val greetingEnglish = greeting("english")
  val greetingSpanish = greeting("spanish")

  println(greetingEnglish("James"))
  println(greetingSpanish("Santiago"))
}