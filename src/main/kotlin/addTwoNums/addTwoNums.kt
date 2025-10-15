package addTwoNums

fun main() {
  val list = listOf(2, 4, 3)
  val list2 = listOf(5, 6, 4)

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

  val num1 = l1.toList()
  val num2 = l2.toList()

  var carry = 0
  val resNum = mutableListOf<Int>()
  var index = 0

  while (index < num1.size || index < num2.size) {
    val currentCount = (num1.getOrNull(index) ?: 0) + (num2.getOrNull(index) ?: 0) + carry

    if (currentCount > 9) {
      resNum.add(currentCount % 10)
      carry = 1
    } else {
      resNum.add(currentCount)
      carry = 0
    }

    index++
  }

  if (carry == 1) {
    resNum.add(carry)
  }

  return resNum.toListNode()
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