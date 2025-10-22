fun main() {
  val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
  rotate(nums = arr, k = 3)
  // [5,6,7,1,2,3,4]
  println(arr.toList().joinToString())

  val arr2 = intArrayOf(1, 2)
  rotate(nums = arr2, k = 7)
  // [2, 1]
  println(arr2.toList().joinToString())
}

// O(2n) time | O(n) space
// O(n) time | O(n) space
private fun rotate(nums: IntArray, k: Int): Unit {
  if (nums.size == 1) return
  if (k == 0) return
  if (k == nums.size) return

  val numsArr = nums.clone() // O(n) time | O(n) space

  for (i in nums.indices) { // O(n) time
    val newPosition = (i + k) % nums.size
    nums[newPosition] = numsArr[i]
  }
}