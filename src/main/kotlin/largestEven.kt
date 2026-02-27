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
  var lastIndex = -1
  for (i in s.length - 1 downTo 0) {
    if (s[i] == '2') {
      lastIndex = i
      break
    }
  }

  if (lastIndex == -1) return ""
  return s.substring(0, lastIndex + 1)
}

private fun largestEven2(s: String): String = s.dropLastWhile { it.digitToInt() != 2 }