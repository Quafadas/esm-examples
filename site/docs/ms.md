# Facades 101 (ms)

A demonstration of an extremely simple facade
- Imported directly via ES Module
- No bundler. The browser resolves the dependancy directly from a CDN.

https://www.npmjs.com/package/ms


```scala
package facades
import scala.scalajs.js
import scala.scalajs.js.annotation._
@js.native
@JSImport("https://cdn.jsdelivr.net/npm/ms@2.1.3/+esm", JSImport.Default)
object ms extends js.Object {
  def apply(s: Double): String = js.native
  def apply(s: String): Double = js.native
}

```

```scala mdoc:js
node.innerHTML = s"MS time : ${facades.ms("2 days")} , ms mills in S ${facades.ms(1000)}"
node.asInstanceOf[org.scalajs.dom.HTMLElement].style.border = "3px solid green"
```

### Notes:

We can't have the facade directly in mdoc,

```sh
error: ms.md:12:1:
@js.native is not allowed on local definitions
```
So instead we have it in a dependant module.