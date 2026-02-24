private class ListNode2(var `val`: Int) {
  var next: ListNode2? = null
}

fun main() {
  var head = ListNode2(1)
  head.next = ListNode2(1)
  head.next?.next = ListNode2(2)

  var x = deleteDuplicates(head)
  println(x?.`val`)
  while (x?.next != null) {
    println(x.next?.`val`)
    x = x.next
  }
}

private fun deleteDuplicates(head: ListNode2?): ListNode2? {
  if (head == null) return null

  var current = head

  while (current?.next != null) {
    if (current.`val` == current.next?.`val`) {
      current.next = current.next?.next
    } else {
      current = current.next
    }
  }

  return head
}