package facades

import scala.scalajs.js
import scala.scalajs.js.annotation._

@js.native
@JSImport("https://cdn.jsdelivr.net/npm/ms@2.1.3/+esm", JSImport.Default)
object ms extends js.Object {
  def apply(s: Double): String = js.native
  def apply(s: String): Double = js.native
}