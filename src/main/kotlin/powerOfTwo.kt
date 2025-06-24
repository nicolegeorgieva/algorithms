fun main() {
  // false
  println(isPowerOfTwo(3))
  // false
  println(isPowerOfTwo(6))
  //true
  println(isPowerOfTwo(16))
  //true
  println(isPowerOfTwo(2))
}

// n = 3 - false
// n = 1 - true (2^0 = 1)
private fun isPowerOfTwo(n: Int): Boolean {
  if (n == 1) return true
  if (n == 2) return true
  if (n % 2 != 0) return false
  var res = 2

  for (x in 1..31) {
    if (res > n) return false
    res *= 2
    if (res == n) return true
  }

  return false
}