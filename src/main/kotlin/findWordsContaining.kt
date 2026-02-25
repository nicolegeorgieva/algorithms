fun main() {
  // 0, 1
  println(findWordsContaining(words = arrayOf("leet", "code"), x = 'e'))
  // 0, 1
  println(findWordsContaining2(words = arrayOf("leet", "code"), x = 'e'))
}

private fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
  val res = mutableListOf<Int>()

  for (wordIndex in words.indices) {
    val word = words[wordIndex]
    for (charIndex in word.indices) {
      if (word[charIndex] == x) {
        res += wordIndex
        break
      }
    }
  }

  return res
}

private fun findWordsContaining2(words: Array<String>, x: Char): List<Int> {
  return words.mapIndexedNotNull { wordIndex, word ->
    wordIndex.takeIf { word.contains(x) }
  }
}