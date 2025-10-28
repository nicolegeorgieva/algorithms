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
  val lettersInMagazine = mutableMapOf<Char, Int>()

  for (char in magazine) {
    lettersInMagazine[char] = (lettersInMagazine[char] ?: 0) + 1
  }

  for (char in ransomNote) {
    val charInMagazine = lettersInMagazine[char] ?: return false
    if (charInMagazine - 1 < 0) return false
    lettersInMagazine[char] = charInMagazine - 1
  }

  return true
}