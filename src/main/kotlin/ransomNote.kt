fun main() {
  // false
  println(canConstruct(ransomNote = "a", magazine = "b"))
  // true
  println(canConstruct(ransomNote = "aa", magazine = "aab"))
}

/*
Input: ransomNote = "a", magazine = "b"
Output: false

Input: ransomNote = "aa", magazine = "aab"
Output: true
 */
private fun canConstruct(ransomNote: String, magazine: String): Boolean {
  val lettersInMagazine = IntArray(26) { 0 }

  for (char in magazine) {
    val index = char.code - 'a'.code
    lettersInMagazine[index] += 1
  }

  for (char in ransomNote) {
    val indexOfChar = char.code - 'a'.code

    if (lettersInMagazine[indexOfChar] - 1 < 0) return false

    lettersInMagazine[indexOfChar] -= 1
  }

  return true
}