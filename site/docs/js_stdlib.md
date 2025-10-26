# Js stdlib (numerical)

A very simple start on stdlb for Scala.js, wrapping [stdlib-js](https://www.npmjs.com/package/@stdlib/blas-base) which provides basic numerical routines. Further exploration of this in [vecxt](https://github.com/Quafadas/vecxt/tree/main)

```scala mdoc:js

import facades.blas
import scala.scalajs.js.typedarray.Float64Array
import scala.scalajs.js

val x = new Float64Array(js.Array(1.0, 2.0, 3.0))
blas.dscal(3, 2.0, x, 1)

node.innerHTML = s"Scaled array: [${x.mkString(", ")}]"

```
