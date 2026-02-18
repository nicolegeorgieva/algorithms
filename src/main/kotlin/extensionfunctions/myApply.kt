package extensionfunctions

fun main() {
  val example1 = "Hello!".apply {
    println("The greeting is ${this.uppercase()}")
  }
  val example2 = "Good afternoon!".myApply {
    println("The greeting is ${this.uppercase()}")
  }
  println(example1)
  println(example2)

  val list = mutableListOf<Int>().myApply {
    add(1)
    add(2)
    remove(1)
    addAll(listOf(4, 5))
  }
  println(list)
}

private fun <T> T.myApply(block: T.() -> Unit): T {
  block()
  return this
}