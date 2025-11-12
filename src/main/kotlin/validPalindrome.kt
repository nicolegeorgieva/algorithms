fun main() {
  // true
  println(isPalindrome("A man, a plan, a canal: Panama"))
}

private fun isPalindrome(s: String): Boolean {
  val word = s.lowercase().filter {
    it in 'a'..'z' || it in '0'..'9'
  }

  return word == word.reversed()
}