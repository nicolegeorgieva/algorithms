fun main() {
  // true
  println(isIsomorphic(s = "egg", t = "add"))
  // false
  println(isIsomorphic(s = "foo", t = "bar"))
  // false
  println(isIsomorphic(s = "badc", t = "baba"))
  // false
  println(isIsomorphic(s = "egcd", t = "adfd"))
  // true
  println(isIsomorphic(s = "title", t = "paper"))
}

/*
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character.
Preserve the order of characters.
No two characters may map to the same character.
A character may map to itself.
 */
private fun isIsomorphic(s: String, t: String): Boolean {
  if (s == t) return true
  if (s.length != t.length) return false

  val sMapping = mutableMapOf<Char, Char>()
  val tMapping = mutableMapOf<Char, Char>()

  for (i in s.indices) {
    val sC = s[i]
    val tC = t[i]
    if (sC in sMapping && sMapping[sC]!! != tC) return false
    if (tC in tMapping && tMapping[tC]!! != sC) return false

    sMapping[sC] = tC
    tMapping[tC] = sC
  }

  return true
}