fun main() {
  // 1112
  println(largestEven("1112"))
  // 22
  println(largestEven("221"))
  // ""
  println(largestEven("1"))
  // 1112
  println(largestEven2("1112"))
  // 22
  println(largestEven2("221"))
  // ""
  println(largestEven2("1"))
}

private fun largestEven(s: String): String {
  var newString = s
  for (i in newString.length - 1 downTo 0) {
    if (newString[i].digitToInt() != 2) {
      newString = newString.dropLast(1)
    } else {
      return newString
    }
  }

  return newString
}

private fun largestEven2(s: String): String = s.dropLastWhile { it.digitToInt() != 2 }