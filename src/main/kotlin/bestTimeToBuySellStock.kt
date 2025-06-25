fun main() {
  val prices = intArrayOf(7, 1, 5, 3, 6, 4)
  // 5
  println(maxProfit(prices))

  val prices2 = intArrayOf(7, 6, 4, 3, 1)
  // 0
  println(maxProfit(prices2))

  val prices3 = intArrayOf(2, 4, 1)
  // 2
  println(maxProfit(prices3))

  val prices4 = intArrayOf(2, 1, 2, 1, 0, 1, 2)
  // 2
  println(maxProfit(prices4))
}

/*
prices = [7,1,5,3,6,4]
profit = 5

no profit - 0
 */
private fun maxProfit(prices: IntArray): Int {
  if (prices.size <= 1) return 0

  var minPrice = prices[0]
  var maxProfit = 0

  for (i in 1..prices.size - 1) {
    val currentPrice = prices[i]
    val profit = currentPrice - minPrice
    if (profit > maxProfit) {
      maxProfit = profit
    } else if (currentPrice < minPrice) {
      minPrice = currentPrice
    }
  }

  return maxProfit
}