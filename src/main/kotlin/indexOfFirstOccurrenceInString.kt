fun main() {
  // -1
  println(strStr(haystack = "leetcode", needle = "leeto"))
  // 5
  println(strStr(haystack = "sadbutsad", needle = "tsad"))
}

private fun strStr(haystack: String, needle: String): Int {
  for (i in 0..haystack.lastIndex - needle.lastIndex) {
    val found = checkMatch(haystack = haystack, needle = needle, offset = i)
    if (found) return i
  }

  return -1
}

private fun checkMatch(haystack: String, needle: String, offset: Int): Boolean {
  for (i in 0..needle.lastIndex) {
    if (needle[i] != haystack[offset + i]) return false
  }

  return true
}