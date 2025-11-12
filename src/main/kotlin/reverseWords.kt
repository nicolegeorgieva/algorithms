fun main() {
  // "blue is sky the"
  println(reverseWords(s = "the sky is blue"))
}

/*
Returns a string of the words in reverse order concatenated by a single space
without leading or trailing spaces
 */
private fun reverseWords(s: String): String {
  val word = s.split(" ").filter { it.isNotBlank() }
  return word.reversed().joinToString(" ")
}