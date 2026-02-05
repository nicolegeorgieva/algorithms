fun main() {
  /*
 [
  CharOccurence(
     rowIndex = 1,
     columnIndex = 0,
   ),
   CharOccurence(
     rowIndex = 1,
     columnIndex = 3,
   ),
   ]
   */
  println(
    findOccurencesOfChar(
      board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
      ),
      char = 'S'
    )
  )

  /*
 [
  CharOccurence(
     rowIndex = 0,
     columnIndex = 3,
   ),
   CharOccurence(
     rowIndex = 2,
     columnIndex = 3,
   ),
   ]
   */
  println(
    findMatchingNeighborsOfChar(
      board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
      ),
      charOccurence = CharOccurence(
        rowIndex = 1,
        columnIndex = 3,
      ),
      matchingChar = 'E'
    )
  )

  // true
  println(
    exist(
      board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
      ),
      word = "ABCCED",
    )
  )
  // true
  println(
    exist(
      board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
      ),
      word = "SEE",
    )
  )
}

private fun exist(board: Array<CharArray>, word: String): Boolean {
  return false
}

private data class CharOccurence(
  val rowIndex: Int,
  val columnIndex: Int,
)

private fun findOccurencesOfChar(
  board: Array<CharArray>,
  char: Char,
): List<CharOccurence> {
  val res = mutableListOf<CharOccurence>()

  for (rowIndex in board.indices) {
    for (columnIndex in board[rowIndex].indices) {
      if (char == board[rowIndex][columnIndex]) {
        res += CharOccurence(
          rowIndex = rowIndex,
          columnIndex = columnIndex,
        )
      }
    }
  }

  return res
}

private fun findMatchingNeighborsOfChar(
  board: Array<CharArray>,
  charOccurence: CharOccurence,
  matchingChar: Char,
): List<CharOccurence> {
  val matchingNeighbors = mutableListOf<CharOccurence>()
  val row = charOccurence.rowIndex
  val column = charOccurence.columnIndex

  // up
  if (row - 1 >= 0) {
    if (board[row - 1][column] == matchingChar) {
      matchingNeighbors += CharOccurence(
        rowIndex = row - 1,
        columnIndex = column,
      )
    }
  }

  // down
  if (row + 1 <= board.size) {
    if (board[row + 1][column] == matchingChar) {
      matchingNeighbors += CharOccurence(
        rowIndex = row + 1,
        columnIndex = column,
      )
    }
  }

  // left
  if (column - 1 >= 0) {
    if (board[row][column - 1] == matchingChar) {
      matchingNeighbors += CharOccurence(
        rowIndex = row,
        columnIndex = column - 1,
      )
    }
  }

  // right
  if (column + 1 <= board.size) {
    if (board[row][column + 1] == matchingChar) {
      matchingNeighbors += CharOccurence(
        rowIndex = row,
        columnIndex = column + 1,
      )
    }
  }

  return matchingNeighbors
}