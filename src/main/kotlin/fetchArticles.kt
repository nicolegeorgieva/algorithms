import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
  val searchQueryFlow = MutableStateFlow("")
  launch {
    delay(2_000)
    searchQueryFlow.value = "kotlin"
    delay(1_000)
    searchQueryFlow.value = "android"
    delay(5_000)
    searchQueryFlow.value = "compose"
  }
  val articlesFlow = flow {
    while(true) {
      emit(fetchArticles())
      delay(1_000)
    }
  }

  val combined = combine(
    flow = searchQueryFlow,
    flow2 = articlesFlow,
    transform = { query, articles ->
        articles.filter {
          it.contains(
            other = query,
            ignoreCase = true,
          )
        }
    }
  )

  combined.collectLatest {
    println(it)
  }
}

private suspend fun fetchArticles(): List<String> {
  delay(2_000)
  return listOf(
    "Kotlin Flow Explained",
    "Jetpack Compose Basics",
    "Coroutines Best Practices",
    "Advanced Android Development"
  )
}