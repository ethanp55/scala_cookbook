// Generic linked list class
class LinkedList[A] {
  private class Node[A] (elem: A) {
    var next: Node[A] = _
    override def toString = elem.toString
  }

  private var head: Node[A] = _

  def add(elem: A) {
    val n = new Node(elem)
    n.next = head
    head = n
  }

  private def printNodes(n: Node[A]) {
    if (n != null) {
      println(n)
      printNodes(n.next)
    }
  }

  def printAll() { printNodes(head) }
}

object Test extends App {
  // Since we used generics in the class definition, we can create linked lists of integers, strings, etc.
  val ints = new LinkedList[Int]()
  ints.add(1)
  ints.add(5)
  ints.printAll()

  val strings = new LinkedList[String]()
  strings.add("Homelander")
  strings.add("Billy Butcher")
  strings.printAll()
}
