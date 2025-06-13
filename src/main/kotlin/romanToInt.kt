fun main() {
  val num = "IV"
  // 3
  println(romanToInt(num))

  val num2 = "XIX"
  // 19
  println(romanToInt(num2))

  val num3 = "CCCIV"
  // 304
  println(romanToInt(num3))

  val num4 = "MMMCD"
  // 3400
  println(romanToInt(num4))
}

private val map = mapOf(
  "I" to 1,
  "IV" to 4,
  "V" to 5,
  "IX" to 9,
  "X" to 10,
  "XL" to 40,
  "L" to 50,
  "XC" to 90,
  "C" to 100,
  "CD" to 400,
  "D" to 500,
  "CM" to 900,
  "M" to 1000
)

private fun romanToInt(s: String): Int {
  if (map[s] != null) return map[s]!!
  var num = 0
  var i = 0

  while (i in s.indices) {
    val currentChar = s[i]
    val pair = if (i != s.lastIndex) "$currentChar${s[i + 1]}" else ""
    if (map[pair] != null) {
      num += map[pair] ?: 0
      i += 2
    } else {
      num += map[currentChar.toString()] ?: 0
      i++
    }
  }

  return num
}