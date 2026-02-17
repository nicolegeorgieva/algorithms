package extensionfunctions

fun main() {
  val example1 = "Hello!".apply {
    println("The greeting is ${this.uppercase()}")
  }
  val example2 = "Good afternoon!".myApply {
    println("The greeting is ${this.uppercase()}")
  }
  // The greeting is Hello!
  // The greeting is Good afternoon!
  // Hello!
  println(example1)
  // Good afternoon!
  println(example2)
}

private fun <T> T.myApply(block: T.() -> Unit): T {
  block()
  return this
}