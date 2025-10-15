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

  var node1 = l1
  var node2 = l2

  var carry = false
  var resHead: ListNode? = null
  var resCurrentNode = resHead

  while (node1 != null || node2 != null) {
    val currentCount = (node1?.`val` ?: 0) + (node2?.`val` ?: 0) + (if (carry) 1 else 0)

    val num = if (currentCount > 9) {
      carry = true
      currentCount % 10
    } else {
      carry = false
      currentCount
    }
    if (resHead == null) {
      resHead = ListNode(num)
      resCurrentNode = resHead
    } else {
      val newNode = ListNode(num)
      resCurrentNode!!.next = newNode
      resCurrentNode = newNode
    }

    node1 = node1?.next
    node2 = node2?.next
  }

  if (carry) {
    resCurrentNode?.next = ListNode(1)
  }

  return resHead
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