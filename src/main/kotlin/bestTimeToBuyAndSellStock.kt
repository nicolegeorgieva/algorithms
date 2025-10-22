fun main() {
  // 7
  println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
  // 4
  println(maxProfit(intArrayOf(1, 2, 3, 4, 5)))
  // 0
  println(maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}

// We can only hold 1 stock at a time; can buy and sell multiple times on the same day
private fun maxProfit(prices: IntArray): Int {
  var stock = prices[0]
  var profit = 0

  for (i in 1..prices.size - 1) {
    if (prices[i] < stock) {
      stock = prices[i]
    } else {
      profit += sell(buyPrice = stock, sellPrice = prices[i])
      stock = prices[i]
    }
  }

  return profit
}

private fun sell(buyPrice: Int, sellPrice: Int): Int {
  return sellPrice - buyPrice
}