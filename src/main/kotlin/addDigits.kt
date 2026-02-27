fun main() {
  // 2
  println(addDigits(38))
}

private fun addDigits(num: Int): Int {
  var resNum = num.toString()

  while (resNum.length > 1) {
    resNum = resNum.sumOf { it.digitToInt() }.toString()
  }

  return resNum.toInt()
}