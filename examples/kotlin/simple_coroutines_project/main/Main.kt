package main

import com.soywiz.korma.geom.Point
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import main.lib.Greeting
import okhttp3.OkHttp

object Main {
  /**
   * Create a list of coroutines (based on the user input). Each coroutine is delayed for a number
   * of minutes relative to its order in the list, i.e. coroutine {@code i} is delayed for {@code
   * i} seconds. After the delay, the coroutine prints a greeting message indicating its number.
   */
  @JvmStatic
  fun main(args: Array<String>) = runBlocking {
    val num: Int =
      if (args.isNotEmpty()) {
        args[0].toInt()
      } else {
        1
      }

    for (i in 0 until num) {
      val p = Point(1, 1)
      val httpV = OkHttp.VERSION
      launch { println(Greeting.getGreeting(i + 1)) }
    }

    // this should be printed before any of the coroutines output their messages
    println("Hello from Main coroutine")
  }
}
