fun main() {
  // -1
  println(strStr(haystack = "leetcode", needle = "leeto"))
  // 5
  println(strStr(haystack = "sadbutsad", needle = "tsad"))
}

private fun strStr(haystack: String, needle: String): Int {
  for (i in 0..haystack.lastIndex - needle.lastIndex) {
    val potentialMatch = haystack.substring(i..i + needle.lastIndex)
    if (potentialMatch == needle) return i
  }

  return -1
}