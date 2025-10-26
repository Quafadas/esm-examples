# MSAL

This isn't a working example, because i don't want to go through the hasslen off app registration, but hopefully it provides a sketch.

The ESM part here is significantly sketchier. Not at all clear if it's meant to be used like this.

```scala mdoc:js
import scala.scalajs.js
import org.scalajs.dom.console
import org.scalajs.dom.html.Button
import facades.msal.*

object MsalClient:

  // Create an MSAL configuration
  private val msalConfig = Configuration(
    Auth(
      clientId = "clientId",
      authority = "authority",
      redirectUri = "redirectUri"
    ),
    CacheOptions("sessionStorage")
  )

  // Instantiate the PublicClientApplication
  private val pca = new PublicClientApplication(msalConfig)

  // Optional: active account tracking
  private var activeAccount: js.UndefOr[AccountInfo] = js.undefined

  // Initialize MSAL (required for redirect flows)
  def initialize(): Unit =
    pca.initialize()
      .`then`[Unit](_ =>
        console.log("MSAL initialized")
        // Try to handle any redirect result (if using redirect flow)
        pca.handleRedirectPromise().`then`[Unit](
          result =>
            if (result != null && result.account != null) {
              pca.setActiveAccount(result.account)
              activeAccount = result.account
              console.log("Redirect login successful for:", result.account.username)
            } else {
              console.log("No redirect response found")
            }
        )
      )
      .`catch`(e => console.error("MSAL initialization failed", e))

  // Attempt silent token acquisition; fallback to popup if necessary
  def acquireToken(scopes: js.Array[String] = js.Array("User.Read")): Unit =
    val request = TokenRequest(scopes = scopes, account = activeAccount)

    pca.acquireTokenSilent(request)
      .`then`[Unit](result =>
        console.log("Token acquired silently:", result.accessToken.take(10) + "...")
      )
      .`catch` {_ =>
        console.log("Silent token acquisition failed; trying popup login")
        loginPopupAndGetToken(request)
      }

  private def loginPopupAndGetToken(request: TokenRequest): Unit =
    pca.loginPopup(request)
      .`then`[Unit](result =>
        pca.setActiveAccount(result.account)
        activeAccount = result.account
        console.log("Login successful for:", result.account.username)
        acquireToken(request.scopes)
      )
      .`catch`(e => console.error("Login failed", e))

// Elsewhere...

// @main
// def mainApp(): Unit =
//   MsalClient.initialize()
  // Later, e.g., on a button click:
  // MsalClient.acquireToken()


val button: Button = org.scalajs.dom.document.createElement("button").asInstanceOf[Button]
button.textContent = "Get Token"
button.onclick = _ =>
  MsalClient.initialize()
node.appendChild(button)

```