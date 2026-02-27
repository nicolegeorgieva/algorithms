fun main() {
  // 2
  println(addDigits(38))
  // 2
  println(addDigits2(38))
}

private fun addDigits(num: Int): Int {
  var resNum = num.toString()

  while (resNum.length > 1) {
    resNum = resNum.sumOf { it.digitToInt() }.toString()
  }

  return resNum.toInt()
}

private fun addDigits2(num: Int): Int {
  return if (num < 10) num else addDigits2((num / 10) + (num % 10))
}