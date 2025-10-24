# Turndown

Markdown to HTML converter. Here, I handrolled the facade at `facades/TurndownService.scala`, and we remap the import at linktime.


```scala mdoc:js
val turndownService = new facades.TurndownService()
val asHtml = turndownService.turndown("""
<b>It's so html</b>
<ol>
  <li>Item 1</li>
  <li>Item 2</li>
</ol>
""")

node.innerHTML = asHtml
node.asInstanceOf[org.scalajs.dom.HTMLElement].style.border = "3px solid green"


```