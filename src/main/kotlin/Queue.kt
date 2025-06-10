fun main() {
  val people = Queue<String>(1)
  // true
  println(people.enqueue("A"))
  // A
  println(people.dequeue())
  // D
  println(people.enqueue("B"))
  // false
  println(people.enqueue("C"))
}

class Queue<T>(
  private val size: Int
) {
  private val queue = MutableList<T?>(size = size, init = { null })
  private var firstIndex = -1
  private var lastIndex = -1

  fun enqueue(t: T): Boolean {
    if (isFull()) return false
    if (firstIndex < 0 && lastIndex < 0) {
      firstIndex = 0
      lastIndex = 0
    }
    lastIndex = lastIndex % size
    queue[lastIndex] = t
    lastIndex++
    return true
  }

  fun dequeue(): T? {
    val first = peek() ?: return null
    firstIndex += 1
    return first
  }

  /**
   * Returns the first element in the queue or null if empty.
   */
  fun peek(): T? {
    return if (isEmpty()) {
      firstIndex = -1
      lastIndex = -1
      null
    } else {
      queue[firstIndex]
    }
  }

  fun isEmpty(): Boolean {
    return (firstIndex < 0 && lastIndex < 0) || (firstIndex > size - 1)
  }

  fun isFull(): Boolean {
    if (isEmpty()) return false
    return (lastIndex == firstIndex) || (lastIndex % size == 0)
  }
}