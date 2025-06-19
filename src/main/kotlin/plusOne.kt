fun main() {
  // 1,0,0
  println(plusOne(digits = intArrayOf(9, 9)).toList())
}

// [1,2,3] -> [1,2,4]
private fun plusOne(digits: IntArray): IntArray {
  val res = mutableListOf<Int>()
  var inMind = false

  for (i in digits.lastIndex downTo 0) {
    val num = digits[i]

    if (i == digits.lastIndex) {
      if (num + 1 > 9) {
        res += 0
        if (digits.size == 1) {
          res += 1
        }
        inMind = true
        continue
      } else {
        res += num + 1
        continue
      }
    }

    if (inMind) {
      if (num + 1 > 9) {
        res += 0
        if (i == 0) {
          res += 1
        }
        inMind = true
        continue
      } else {
        res += num + 1
        inMind = false
        continue
      }
    } else {
      res += num
      continue
    }
  }

  return res.reversed().toIntArray()
}