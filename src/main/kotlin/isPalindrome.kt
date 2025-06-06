fun main() {
  val x = 121
  val y = -121

  // true
  println(isPalindrome(x))
  // 121- => false
  println(isPalindrome(y))
}

private fun isPalindrome(x: Int): Boolean {
  if (x < 0) return false
  val num = x.toString()
  for (i in 0 until num.length / 2) {
    if (num[i] != num[num.lastIndex - i]) {
      return false
    }
  }
  return true
}