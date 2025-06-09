fun main() {
  val input = "([])"
  println(isValid(s = input))
}

// s consists of parentheses only '()[]{}'
// ([]) -> true
// Open brackets must be closed in the correct order
// ([{}])
// After each open bracket follows eather closed bracket for it || dif open bracket

class Stack(
  size: Int
) {
  private val arr: CharArray = CharArray(size)
  private var topIndex = -1

  fun push(char: Char): Boolean {
    if (topIndex + 2 > arr.size) return false
    topIndex++
    arr[topIndex] = char
    return true
  }

  fun pop(): Char? {
    val last = peek() ?: return null
    topIndex -= 1
    return last
  }

  fun peek(): Char? {
    if (isEmpty()) return null
    return arr[topIndex]
  }

  fun isEmpty(): Boolean {
    return topIndex < 0
  }
}

fun isValid(s: String): Boolean {
  if (s.length % 2 != 0) return false
  val lastOpenBracket = Stack(s.length / 2)

  for (i in s.indices) {
    val char = s[i]

    when (char) {
      '[', '(', '{' -> {
        val res = lastOpenBracket.push(char)
        if (!res) return false
      }

      ']' -> {
        if (lastOpenBracket.pop() != '[') return false
      }

      ')' -> {
        if (lastOpenBracket.pop() != '(') return false
      }

      '}' -> {
        if (lastOpenBracket.pop() != '{') return false
      }
    }
  }

  return lastOpenBracket.isEmpty()
}