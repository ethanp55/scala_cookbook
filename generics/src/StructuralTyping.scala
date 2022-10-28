class Duck { def speak() { println("quack") } }
class Tortoise { def speak() { println("crunch") } }

object StructuralTyping extends App {
  // This syntax means that the object you pass in (of type A) must have a speak method
  // The <: is usually used to denote that A must be a subtype of something (for example, A <: Animal).  However, here
  // it is used to say that A must be a subtype of something that has a speak method
  def callSpeak[A <: { def speak(): Unit }](obj: A) {
    obj.speak()
  }

  callSpeak(new Duck)
  callSpeak(new Tortoise)
}