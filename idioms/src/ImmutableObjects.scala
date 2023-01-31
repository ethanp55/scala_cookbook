/*
* In general, it is best to think about immutable objects first before using mutable ones.  This tends
* to yield safer code, as there are fewer side effects in functions and methods.  However, certain situations will
* obviously be better served with mutable objects.  If such a scenario arises, prefer to use the "private val"
* approach (i.e., make mutable objects vals and private.  This is a safe practice because only the class itself can
* modify and/or allow outside access the state of the mutable object.  Furthermore, the use of val prevents the object
* from being reassigned.  As an example, here is a pizza class with a mutable array buffer for toppings (in this
* scenario, it makes sense to be able to add and remove toppings from a pizza).  The _toppings array buffer is a
* private val, and the class allows outside users to add/remove toppings via the addTopping and removeTopping methods.
* If a user wishes to see the specific toppings, they can call the toppings method and receive an immutable list.
* */

class Topping

class Pizza {
  private val _toppings = new collection.mutable.ArrayBuffer[Topping]()

  def toppings = _toppings.toList
  def addTopping(t: Topping) { _toppings += t }
  def removeTopping(t: Topping) { _toppings -= t }
}