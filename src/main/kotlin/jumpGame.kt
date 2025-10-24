fun main() {
  // true
  println(canJump(intArrayOf(2, 3, 1, 1, 4)))
  // false
  println(canJump(intArrayOf(3, 2, 1, 0, 4)))
  // true
  println(canJump(intArrayOf(2, 0)))
  // true
  println(canJump(intArrayOf(2, 5, 0, 0)))
  // true
  println(canJump(intArrayOf(2, 0, 0)))
  // true
  println(canJump(intArrayOf(1, 1, 1, 0)))
}

private fun canJump(nums: IntArray): Boolean {
  if (nums.size == 1) return true
  if (nums[0] == 0) return false

  var maxPotential = nums[0]

  for (i in 1..nums.lastIndex - 1) {
    val currentPotential = nums[i]

    maxPotential = maxOf(maxPotential - 1, currentPotential)
    if (maxPotential == 0) return false
  }

  return true
}