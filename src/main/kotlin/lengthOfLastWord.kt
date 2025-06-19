fun main() {
  // 4
  println(lengthOfLastWord("   fly me   to   the moon  "))
}

// "   fly me   to   the moon  " -> moon
private fun lengthOfLastWord(s: String): Int {
  var wordLength = 0

  for (i in s.lastIndex downTo 0) {
    if (s[i] == ' ') {
      if (wordLength == 0) {
        continue
      } else {
        return wordLength
      }
    }
    wordLength++
  }

  return wordLength
}