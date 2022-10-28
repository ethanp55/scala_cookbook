import scala.collection.mutable.ArrayBuffer

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

object MakeMutableCollectionsInvarient extends App {
  // To make a collection of mutable objects, you should specify an A type to make it invarient
  // For example, this makeTurtlesSpeak method requires an ArrayBuffer (mutable collection) of Turtles; anything else will not compile
  def makeTurtlesSpeak(turtles: ArrayBuffer[Turtle]) {
    turtles.foreach(_.speak)
  }

  val sheldon = new Turtle("Fido")
  val spike = new Tortoise("Wonder Dog")
  val shelby = new Tortoise("Shaggy")

  val turtles = ArrayBuffer[Turtle]()
  turtles += sheldon
  turtles += spike

  makeTurtlesSpeak(turtles)  // This works because turtles is an ArrayBuffer of Turtles

  val tortoises = ArrayBuffer[Tortoise]()
  tortoises += spike
  tortoises += shelby
//  makeTurtlesSpeak(tortoises)  THIS WILL NOT COMPILE; this is because tortoises is an ArrayBuffer of Tortoises, not Turtles
}

