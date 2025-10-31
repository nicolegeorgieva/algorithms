fun main() {
  // true
  println(isIsomorphic(s = "egg", t = "add"))
  // false
  println(isIsomorphic(s = "foo", t = "bar"))
  // false
  println(isIsomorphic(s = "badc", t = "baba"))
  // false
  println(isIsomorphic(s = "egcd", t = "adfd"))
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

  val mapping = mutableMapOf<Char, Char>()

  for (i in s.indices) {
    val currentChar = s[i]
    if (t[i] in mapping.values && mapping.entries.first { it.value == t[i] }.key != currentChar) return false
    if (mapping[currentChar] != null && mapping[currentChar] != t[i]) return false
    mapping[currentChar] = t[i]
  }

  return true
}