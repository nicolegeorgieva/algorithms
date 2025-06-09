fun main() {
  val people = Queue<String>(4)
  println(people.enqueue("N"))
  println(people.enqueue("I"))
  println(people.enqueue("B"))
  println(people.enqueue("C"))

  // N
  println(people.dequeue())
  // I
  println(people.dequeue())
  // B
  println(people.peek())
  println(people.enqueue("D"))
  println(people.dequeue())
}


class Queue<T>(size: Int) {
  private val queue = MutableList<T?>(size = size, init = { null })
  private var firstIndex = -1
  private var lastIndex = -1

  fun enqueue(t: T): Boolean {
    if (lastIndex + 2 > queue.size) return false

    if (firstIndex < 0) firstIndex = 0
    lastIndex++
    queue[lastIndex] = t
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
      null
    } else {
      queue[firstIndex]
    }
  }

  fun isEmpty(): Boolean {
    return firstIndex < 0 && lastIndex < 0
  }
}