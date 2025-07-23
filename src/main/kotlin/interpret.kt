fun main() {
  // "Goal"
  println(interpret("G()(al)"))
  // "alGalooG"
  println(interpret("(al)G(al)()()G"))
}

/*
G -> G
() -> o
(al) -> al
 */
private fun interpret(command: String): String {
  var interpretation = ""
  for (i in command.indices) {
    when (command[i]) {
      'G' -> interpretation += 'G'
      '(' -> {
        interpretation += if (command[i + 1] == ')') {
          'o'
        } else {
          "al"
        }
      }

      else -> continue
    }
  }
  return interpretation
}