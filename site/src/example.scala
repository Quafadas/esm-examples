package example

import scala.scalajs.js
import scala.scalajs.js.annotation._

@JSExportTopLevel("ExampleApp")
object ExampleApp {
  
  @JSExport
  def main(): Unit = {
    println("Hello from Scala.js!")
  }
  
  @JSExport
  def greet(name: String): String = {
    s"Hello, $name!"
  }
}
