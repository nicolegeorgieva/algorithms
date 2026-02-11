fun main() {
  println(
    exist(
      board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
      ),
      word = "SEE"
    )
  )
}

private data class Coord(val r: Int, val c: Int)

private fun exist(
  board: Array<CharArray>,
  word: String
): Boolean {
  val starts = findStarts(
    board = board,
    target = word.first()
  )
  return starts.any { start ->
    search(
      board = board,
      start = start,
      word = word,
      seen = emptySet(),
    )
  }
}

private fun findStarts(
  board: Array<CharArray>,
  target: Char
): List<Coord> = board.foldIndexed(
  listOf<Coord>()
) { r, acc, row ->
  acc + row.foldIndexed(
    listOf<Coord>()
  ) { c, rms, char ->
    if (char == target)
      rms + Coord(r, c)
    else rms
  }
}

private fun search(
  board: Array<CharArray>,
  start: Coord,
  word: String,
  seen: Set<Coord>,
): Boolean {
  if (word == "") return true
  if (start.r !in board.indices) return false
  if (start.c !in board[0].indices) return false
  if (start in seen) return false

  val char = board[start.r][start.c]
  if (char != word.first()) return false

  val nw = word.drop(1)
  val nSeen = seen + start

  return search(
    board = board,
    start = Coord(start.r - 1, start.c),
    word = nw,
    seen = nSeen,
  ) ||
      search(
        board = board,
        start = Coord(start.r + 1, start.c),
        word = nw,
        seen = nSeen,
      ) ||
      search(
        board = board,
        start = Coord(start.r, start.c - 1),
        word = nw,
        seen = nSeen,
      ) ||
      search(
        board = board,
        start = Coord(start.r, start.c + 1),
        word = nw,
        seen = nSeen,
      )
}