{%
  helium.site.templates.head = ../custom-css.template.html
%}

# Quill

Here we use ScalablyTyped to generate facades for Quill, a rich text editor.


```scala mdoc:js
import typings.quill.quillMod
import typings.quill.coreQuillMod.QuillOptions
import typings.quill.themesSnowMod
import org.scalajs.dom
import org.scalajs.dom.document
import com.raquo.laminar.api.L.{*, given}
import scala.scalajs.js

val hiVar = Var("Update me!")

val app = div(
  div(

  child.text <-- hiVar.signal,
  idAttr := "editor",
  onMountCallback { ctx =>

        val opt = QuillOptions().setTheme("snow")

        val editor = quillMod.default(ctx.thisNode.ref, opt)

        editor.setText(hiVar.now())

        // Listen for text changes and update the reactive variable
        val changeHandler: js.Function = () => {
          val currentHtml = editor.getSemanticHTML()
          hiVar.set(currentHtml)
        }
        editor.on("text-change", changeHandler)
  }
  ),
  p("Here's the html representation;"),
  p(
    child.text <-- hiVar.signal,
    border := "2px solid green",
  ),
)
node.id = "app"

render(
  dom.document.querySelector("#app"),
  app
)

```
