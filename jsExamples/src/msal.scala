package facades

package frontend.component

import scala.scalajs.js
import scala.scalajs.js.Promise
import scala.scalajs.js.annotation.*

object msal:

  val authority = "https://login.microsoftonline.com/common"

  // === MSAL Classes ===
  @js.native
  @JSImport("@azure/msal-browser", "PublicClientApplication")
  class PublicClientApplication(config: Configuration) extends js.Object:
    def initialize(): Promise[Unit] = js.native
    def acquireTokenSilent(request: TokenRequest): Promise[AuthenticationResult] = js.native
    def acquireTokenPopup(request: TokenRequest): Promise[AuthenticationResult] = js.native
    def acquireTokenRedirect(request: TokenRequest): Promise[Unit] = js.native
    def loginPopup(request: TokenRequest): Promise[AuthenticationResult] = js.native
    def loginRedirect(request: TokenRequest): Promise[Unit] = js.native
    def handleRedirectPromise(): Promise[AuthenticationResult | Null] = js.native
    def getAllAccounts(): js.Array[AccountInfo] = js.native
    def setActiveAccount(account: AccountInfo): Unit = js.native
  end PublicClientApplication

  // === Configuration Objects ===
  @js.native
  trait Configuration extends js.Object:
    var auth: Auth
    var cache: CacheOptions
  end Configuration

  object Configuration:
    def apply(auth: Auth, cache: CacheOptions): Configuration =
      js.Dynamic.literal(
        auth = auth,
        cache = cache
      ).asInstanceOf[Configuration]
  end Configuration

  @js.native
  trait CacheOptions extends js.Object:
    var cacheLocation: String
  end CacheOptions

  object CacheOptions:
    def apply(cacheLocation: String = "sessionStorage"): CacheOptions =
      js.Dynamic.literal(
        cacheLocation = cacheLocation
      ).asInstanceOf[CacheOptions]
  end CacheOptions

  @js.native
  trait Auth extends js.Object:
    var clientId: String
    var authority: String
    var redirectUri: String
    var navigateToLoginRequestUrl: Boolean
    var supportsNestedAppAuth: Boolean
  end Auth

  object Auth:
    def apply(
        clientId: String,
        authority: String,
        redirectUri: String,
        navigateToLoginRequestUrl: Boolean = true,
        supportsNestedAppAuth: Boolean = false
    ): Auth =
      js.Dynamic.literal(
        clientId = clientId,
        authority = authority,
        redirectUri = redirectUri,
        navigateToLoginRequestUrl = navigateToLoginRequestUrl,
        supportsNestedAppAuth = supportsNestedAppAuth
      ).asInstanceOf[Auth]
  end Auth

  // === Request / Response Types ===
  @js.native
  trait TokenRequest extends js.Object:
    var scopes: js.Array[String]
    var account: js.UndefOr[AccountInfo]
    var forceRefresh: js.UndefOr[Boolean]
  end TokenRequest

  object TokenRequest:
    def apply(
        scopes: js.Array[String] = js.Array("User.Read"),
        account: js.UndefOr[AccountInfo] = js.undefined,
        forceRefresh: js.UndefOr[Boolean] = js.undefined
    ): TokenRequest =
      js.Dynamic.literal(
        scopes = scopes,
        account = account,
        forceRefresh = forceRefresh
      ).asInstanceOf[TokenRequest]
  end TokenRequest

  @js.native
  trait AuthenticationResult extends js.Object:
    val accessToken: String
    val idToken: String
    val expiresIn: Double
    val account: AccountInfo
  end AuthenticationResult

  @js.native
  trait AccountInfo extends js.Object:
    val username: String
    val homeAccountId: String
    val localAccountId: String
    val environment: String
    val tenantId: String
  end AccountInfo

end msal