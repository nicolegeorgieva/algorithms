fun main() {
  val arr1 = intArrayOf(1, 2, 3, 4, 5, 6)

  reverseArray(arr1)
  // 6, 5, 4, 3, 2, 1
  println(arr1.joinToString())
}

private fun reverseArray(arr: IntArray) {
  val swaps = arr.size / 2
  for (i in 0..<swaps) {
    arr.swap(a = i, b = arr.lastIndex - i)
  }
}

private fun IntArray.swap(a: Int, b: Int) {
  val saved = this[a]
  this[a] = this[b]
  this[b] = saved
}