# idb-keyval

A facade for [idbkeyval](https://www.npmjs.com/package/idb-keyval) which is a tiny library that seeks to tame IndexedDB as a simple key-val store.

```scala mdoc:js
import org.scalajs.dom
import org.scalajs.dom.html.Button

val button: Button = dom.document.createElement("button").asInstanceOf[Button]
button.textContent = "Write to IndexedDB"
button.onclick = { _ =>
  facades.idbKeyval.set("myKey", "myValue")
}
node.appendChild(button)
```
If you press the button, it will store the value "myValue" under the key "myKey" in IndexedDB using idb-keyval.

Note: You can check this in the browser dev tools - you'll probably have to press the "refresh" button to see the new key in IndexedDB.