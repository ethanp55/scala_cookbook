object Closures extends App {
  // Age cutoff and function for checking if a person with the given age can vote
  var votingAge: Int = 18
  val canVote = (age: Int) => age >= votingAge

  println(canVote(19))

  // If we change the votingAge variable, the canVote function will pick up on that change.  Additionally, if we were
  // to pass the canVote function to a new scope and change the votingAge variable, the canVote function would still
  // pick up on that change; this is known as closure
  votingAge = 20
  println(canVote(19))
}