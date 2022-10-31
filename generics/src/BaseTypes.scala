import scala.collection.mutable.ArrayBuffer

object BaseTypes extends App{
  trait CrewMember
  trait Commendations
  class Officer extends CrewMember
  class RedShirt extends CrewMember

  // This says that Crew is an ArrayBuffer whose elements must be a CrewMember or a child of CrewMember
  // You can also use this syntax for methods or more complicated requirements, such as something like A <: Officer with Commendations
  class Crew[A <: CrewMember] extends ArrayBuffer[A]

  // Defining Crew this way allows you to do the following
  val crewMembers = new Crew[CrewMember]()  // CrewMember is the actual class
  val officers = new Crew[Officer]()  // Officer is a subclass/child of CrewMember
  val redshirts = new Crew[RedShirt]()  // RedShirt is another child of CrewMember

//  val strings = new Crew[String]()  // THIS WILL NOT COMPILE; this is because String is not a child of CrewMember
}