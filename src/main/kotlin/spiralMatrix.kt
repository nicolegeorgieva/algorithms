fun main() {
  val list = listOf(3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0)
  val listNode = list.toListNode()

  // Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
  println(
    spiralMatrix(m = 3, n = 5, head = listNode)
      .joinToString(separator = "\n") {
        it.toList().toString()
      }
  )
}

private enum class MatrixDirection {
  Right,
  Down,
  Left,
  Up,
}

data class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

/*
Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
Output: [
[3,0,2,6,8],
[5,0,-1,-1,1],
[5,2,4,9,7]
]
 */
private fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
  if (head == null) return arrayOf()

  val rows = m
  val columns = n

  val matrix = Array(rows) { _ ->
    IntArray(columns) { _ ->
      -1
    }
  }

  var currentNum: ListNode? = head
  var currentRow = 0
  var currentElementIndex = 0
  var reachedSpace = 1
  var direction = MatrixDirection.Right

  // we fill the first value
  matrix[currentRow][currentElementIndex] = currentNum?.`val` ?: -1
  if (columns > 1) {
    currentElementIndex++
  } else {
    currentRow++
  }

  while (reachedSpace < rows * columns) {
    reachedSpace++
    // ! remaining spaces should be filled with "-1" !
    matrix[currentRow][currentElementIndex] = currentNum?.next?.`val` ?: -1
    if (reachedSpace == rows * columns) return matrix
    currentNum = currentNum?.next

    when (direction) {
      MatrixDirection.Right -> {
        if ((currentElementIndex == columns - 1) || (matrix[currentRow][currentElementIndex + 1] != -1)) {
          direction = MatrixDirection.Down
          currentRow++
          continue
        }
        currentElementIndex++
      }

      MatrixDirection.Down -> {
        if ((currentRow == rows - 1) || (matrix[currentRow + 1][currentElementIndex] != -1)) {
          direction = MatrixDirection.Left
          currentElementIndex--
          continue
        }
        currentRow++
      }

      MatrixDirection.Left -> {
        if ((currentElementIndex == 0) || (matrix[currentRow][currentElementIndex - 1] != -1)) {
          direction = MatrixDirection.Up
          currentRow--
          continue
        }
        currentElementIndex--
      }

      MatrixDirection.Up -> {
        if (matrix[currentRow - 1][currentElementIndex] != -1) {
          direction = MatrixDirection.Right
          currentElementIndex++
          continue
        }
        currentRow--
      }
    }
  }

  return matrix
}

// 1 -> 2 -> 3 -> 4 -> null
private fun List<Int>.toListNode(): ListNode? {
  if (this.isEmpty()) return null
  val head = ListNode(this[0])
  var current = head

  for (i in 1 until this.size) {
    val next = ListNode(this[i])
    current.next = next
    current = next
  }

  return head
}