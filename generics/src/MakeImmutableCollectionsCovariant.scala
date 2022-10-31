object MakeImmutableCollectionsCovariant extends App {
  trait Animal {
    def speak
  }

  class Turtle(var name: String) extends Animal {
    def speak { println("crunch") }
    override def toString = name
  }

  class Tortoise(name: String) extends Turtle(name) {
    def eat { println("crunch crunch") }
  }

  // To make a collection of immutable objects, you should specify a +A type to make it covariant
  // For example, this makeTurtlesSpeak method requires a Seq (immutable collection) of Turtles, but since Seq is
  // defined as Seq[+A] (see Scala docs), it is covariant and can also accept subclasses of Turtle
  def makeTurtlesSpeak(turtles: Seq[Turtle]) {
    turtles.foreach(_.speak)
  }

  val sheldon = new Turtle("Sheldon")
  val spike = new Tortoise("Spike")
  val shelby = new Tortoise("Shelby")

  val turtles = Seq[Turtle](sheldon, spike)

  makeTurtlesSpeak(turtles)  // This works because turtles is an ArrayBuffer of Turtles

  val tortoises = Seq[Tortoise](spike, shelby)
  makeTurtlesSpeak(tortoises)  // THIS COMPILES NOW; this is because Seq is immutable and is defined as Seq[+A]
}
