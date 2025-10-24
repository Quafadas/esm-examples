{%
  helium.site.templates.head = ../webawesome-css.template.html
%}

# WebAwesome

An [excellent UI component framework](https://webawesome.com) that someone has [kindly made facades for](https://github.com/nguyenyou/webawesome-laminar) and integrates with Laminar.


```scala mdoc:js

import org.scalajs.dom

import com.raquo.laminar.api.L.*
import io.github.nguyenyou.webawesome.laminar.*

val demo = div(
      div(
        Button(
          _.onClick --> { _ =>
            Dialog()("Button clicked!")
          }
        )("Click me")
      ),
      div(
        Tree(
          _.selection := "multiple"
        )(
          TreeItem()("Item 1"),
          TreeItem()("Item 2"),
          TreeItem()(
            TreeItem()("Subitem 2.1"),
            TreeItem()("Subitem 2.2"),
          ),
        )
      )
    )

render(
  node,
  demo
)

```