fun main() {
  // true
  println(isPalindrome("A man, a plan, a canal: Panama"))
}

private fun isPalindrome(s: String): Boolean {
  var left = 0
  var right = s.lastIndex

  while (left < right) {
    while (left in s.indices && !s[left].isAllowed()) {
      left++
    }
    while (right in s.indices && !s[right].isAllowed()) {
      right--
    }
    if (left == right || left !in s.indices || right !in s.indices) return true
    if (s[left].lowercase() == s[right].lowercase()) {
      left++
      right--
      continue
    } else {
      return false
    }
  }

  return true
}

private fun Char.isAllowed(): Boolean {
  return this in 'A'..'Z' || this in 'a'..'z' || this in '0'..'9'
}