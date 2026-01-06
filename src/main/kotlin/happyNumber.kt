fun main() {
  // true
  println(isHappy(19))
  // false
  println(isHappy(2))
}

// Starting with any positive integer, replace the number by the sum of the squares of its digits
// Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1
// Those numbers for which this process ends in 1 are happy
private fun isHappy(n: Int): Boolean {
  var x = n
  repeat(50) {
    x = magicSum(x)
    if (x == 1) return true
  }

  return false
}

private fun magicSum(n: Int): Int {
  var x = n
  var sum = 0
  while (x != 0) {
    val lastDigit = x % 10
    sum += lastDigit * lastDigit
    x /= 10
  }
  return sum
}