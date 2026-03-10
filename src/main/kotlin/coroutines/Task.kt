package coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.system.measureTimeMillis

suspend fun main() {
  val time = measureTimeMillis {
    val dashboard = fetchUserDashboard("user_123")
    println("Fetched: $dashboard")
  }
  println("Completed in ${time}ms")
}

private val viewModelScope = CoroutineScope(Dispatchers.Main + SupervisorJob())
private val dashBoardState = MutableStateFlow<DashBoard?>(null)

private var fetchJob: Job? = null

private fun handleCancel() {
  fetchJob?.cancel()
  dashBoardState.value = null
}

private fun handleHomeScreen() {
  fetchJob = viewModelScope.launch {
    while (true) {
      val photos = async(Dispatchers.IO) {
        fetchUserPhotos()
      }
      val posts = async {
        withContext(Dispatchers.IO) {
          fetchUserPosts()
        }
      }
      val friends = async {
        fetchUserFriends()
      }

      dashBoardState.value = DashBoard(
        photos = photos.await(),
        posts = posts.await(),
        friends = friends.await()
      )

      delay(1_000)
    }
  }
}

private suspend fun fetchUserDashboard(userId: String): DashBoard? {
  return try {
    coroutineScope {
      val photos = async {
        fetchUserPhotos()
      }
      val posts = async {
        fetchUserPosts()
      }
      val friends = async {
        fetchUserFriends()
      }

      DashBoard(
        photos = photos.await(),
        posts = posts.await(),
        friends = friends.await()
      )
    }
  } catch (e: Exception) {
    null
  }
}

data class DashBoard(val photos: UserPhotos, val posts: UserPosts, val friends: UserFriends)
data class UserPhotos(val photos: List<String>)
data class UserPosts(val posts: List<String>)
data class UserFriends(val friends: List<String>)

private suspend fun fetchUserPhotos(): UserPhotos {
  delay(2000)
  return UserPhotos(listOf())
}

private suspend fun fetchUserPosts(): UserPosts {
  delay(2500)
  return UserPosts(listOf("Hello", "Hi"))
}

private suspend fun fetchUserFriends(): UserFriends = withContext(Dispatchers.IO) {
  delay(3000)
  UserFriends(listOf("Annie", "Sarah"))
}