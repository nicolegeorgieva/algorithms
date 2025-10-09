package addTwoNums

fun main() {
  val list = listOf(9)
  val list2 = listOf(1, 9, 9, 9, 9, 9, 9, 9, 9, 9)

  // [7,0,8]
  println(
    addTwoNumbers(
      l1 = list.toListNode(),
      l2 = list2.toListNode()
    )?.toList().toString()
  )
}

private class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
  if (l1 == null || l2 == null) return null

  val firstNum = l1.toList().reversed().joinToString("").toBigDecimal()
  val secondNum = l2.toList().reversed().joinToString("").toBigDecimal()

  val sumReversed = (firstNum + secondNum).toString().reversed().toList().map { char ->
    char.digitToInt()
  }

  return sumReversed.toListNode()
}

private fun List<Int>.toListNode(): ListNode? {
  if (this.isEmpty()) return null

  val head = ListNode(this[0])
  var current = head

  for (i in 1..this.lastIndex) {
    val next = ListNode(this[i])
    current.next = next
    current = next
  }

  return head
}

private fun ListNode.toList(): List<Int> {
  val list = mutableListOf<Int>()
  var currentNum = this

  while (true) {
    list += currentNum.`val`
    currentNum = currentNum.next ?: return list
  }
}