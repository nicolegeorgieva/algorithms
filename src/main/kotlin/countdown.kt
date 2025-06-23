import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  println("Starting countdown...")
  runBlocking {
    val job = launch {
      countdownFlow(start = 5)
        .onEach { value ->
          println("Countdown: $value")
        }
        .collect {
          println("Value: $it")
        }
    }

    job.join()
    println("Countdown finished!")
  }
}

private fun countdownFlow(start: Int): Flow<Int> {
  return flow {
    var countdown = start
    while (countdown >= 0) {
      emit(countdown)
      delay(1000)
      countdown--
    }
  }
}