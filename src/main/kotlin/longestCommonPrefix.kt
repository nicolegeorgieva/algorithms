import kotlin.math.min

fun main() {
  val words = arrayOf("flower", "flow", "flight")
  // "fl"
  println(longestCommonPrefix(words))
}

private fun longestCommonPrefix(strs: Array<String>): String {
  if (strs.isEmpty()) return ""

  var currentPrefix = strs[0]
  for (i in 1..strs.size - 1) {
    currentPrefix = common(currentPrefix, strs[i])
  }
  return currentPrefix
}


private fun common(s1: String, s2: String): String {
  for (i in 0..min(s1.length, s2.length) - 1) {
    if (s1[i] != s2[i]) {
      // difference
      return s1.substring(0, i)
    }
  }

  return if(s1.length < s2.length) {
    s1
  } else {
    s2
  }
}