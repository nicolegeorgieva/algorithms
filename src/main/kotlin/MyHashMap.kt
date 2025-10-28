import kotlin.math.absoluteValue

fun main() {
  val map = myHashMap()
  map["Iliyan"] = 3
  map["Nicole"] = 6
  map["Anny"] = 5
  map["Rebecca"] = 10

  println("John" in map)
  val readIliyan = map["Iliyan"]
  println(readIliyan)

  map.remove("Anny")
  println(map["Anny"])
}

class MyHashMap : HashMap {
  val arr = Array<MutableList<Pair<String, Int>>>(4) {
    mutableListOf()
  }

  override fun get(key: String): Int? {
    val indexOfKey = key.hash()
    val list = arr[indexOfKey]

    for (element in list) {
      if (element.first == key) {
        return element.second
      }
    }

    return null
  }

  override fun set(key: String, value: Int) {
    val indexOfKey = key.hash()
    val list = arr[indexOfKey]

    for (i in list.indices) {
      if (list[i].first == key) {
        arr[indexOfKey][i] = key to value
        return
      }
    }

    arr[indexOfKey] += (key to value)
  }

  override fun remove(key: String) {
    val indexOfKey = key.hash()
    val list = arr[indexOfKey]

    list.removeIf { pair ->
      pair.first == key
    }
  }

  override fun contains(key: String): Boolean {
    return get(key) != null
  }

  private fun String.hash(): Int {
    return this.hashCode().absoluteValue % arr.size
  }
}

interface HashMap {
  operator fun get(key: String): Int?
  operator fun set(key: String, value: Int)
  fun remove(key: String)
  operator fun contains(key: String): Boolean
}

fun myHashMap(vararg pairs: Pair<String, Int>) = MyHashMap().apply {
  for ((key, value) in pairs) {
    set(key, value)
  }
}