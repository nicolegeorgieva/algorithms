fun main() {
  // true
  println(isSameAfterReversals(526))
  // false
  println(isSameAfterReversals(1800))
  // true
  println(isSameAfterReversals(0))
}

/*
num = 526 -> 625 -> 526 => true
num = 1800 -> 81 -> 18 => false
 */
private fun isSameAfterReversals(num: Int): Boolean {
  return num == 0 || num % 10 != 0
}