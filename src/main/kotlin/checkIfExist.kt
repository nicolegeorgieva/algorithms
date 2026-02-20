fun main() {
  // true
  println(checkIfExist(arr = intArrayOf(10, 2, 5, 3)))
  // false
  println(checkIfExist(arr = intArrayOf(3, 1, 7, 11)))
  // false
  println(checkIfExist(arr = intArrayOf(0, -2, 2)))
}

/*
 i != j
 arr[i] == 2 * arr[j]
 */
private fun checkIfExist(arr: IntArray): Boolean {
  val numsMap = mutableMapOf<Int, Int>()
  for (i in arr.indices) {
    numsMap[arr[i]] = i
  }

  for (j in arr.indices) {
    val double = arr[j] * 2
    if (double in numsMap && j != numsMap[double]) return true
  }

  return false
}