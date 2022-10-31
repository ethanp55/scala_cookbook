import TypeClass.Speak.SpeakFunctionality

object TypeClass extends App {
  // Let's say we have closed models Turtle, Tortoise, and SeaTurtle (i.e. we cannot add functionality directly to these classes)
  trait Animal
  final case class Turtle(name: String) extends Animal
  final case class Tortoise(name: String) extends Animal
  final case class SeaTurtle(name: String) extends Animal

  // Let's now say that later on in the future we decide we want to give these classes the ability to speak (a
  // speak method).  Instead of changing the original class definitions, which would probably cause issues in more
  // complicated cases, we can create a type class
  object Speak {
    // The type class
    trait SpeakFunctionality[A] {
      def speak(obj: A): Unit
    }

    // The companion object
    object SpeakFunctionality {
      // Create an implicit object for each desired type.  In this case we only implement the cases for Turtle and
      // Tortoise
      implicit object TurtleSpeak extends SpeakFunctionality[Turtle] {
        override def speak(obj: Turtle): Unit = println(s"I am a turtle named ${obj.name}")
      }

      implicit object TortoiseSpeak extends SpeakFunctionality[Tortoise] {
        override def speak(obj: Tortoise): Unit = println(s"I am a tortoise named ${obj.name}")
      }
    }
  }

  // With the type class, we can now have Turtles and Tortoises speak (but not SeaTurtles because we did not create an
  // implicit object)
  def makeAnimalSpeak[A](animal: A)(implicit speakFunctionality: SpeakFunctionality[A]): Unit = {
    speakFunctionality.speak(animal)
  }

  makeAnimalSpeak(Turtle("Sheldon"))
  makeAnimalSpeak(Tortoise("Spike"))
//  makeAnimalSpeak(SeaTurtle("Flipper"))  // This will not compile because we did not create an implicit object for SeaTurtles
}