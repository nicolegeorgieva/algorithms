import kotlin.math.round

fun main() {
  // 2
  println(mySqrt(2147483647))
  // 2
  println(mySqrt(4))
  // 2
  println(mySqrt(8))
  // 3
  println(mySqrt(10))
  // 10
  println(mySqrt(100))
  // 90
  println(mySqrt(8192))
  // 46339
  println(mySqrt(2147395599))
}

// Returns the square root of x rounded down to the nearest integer
// Res should not be negative
private fun mySqrt(x: Int): Int {
  return exactSqrt(x.toDouble()).toInt()
}

private fun exactSqrt(t: Double): Double {
  var num = t / 2

  while (round(num * num) != t) {
    num = (num + (t / num)) / 2
  }

  return num
}