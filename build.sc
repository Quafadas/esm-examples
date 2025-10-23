import mill._
import mill.scalalib._
import mill.scalajslib._

object site extends ScalaJSModule {
  def scalaVersion = "3.3.1"
  def scalaJSVersion = "1.15.0"
  
  def moduleKind = T {
    mill.scalajslib.api.ModuleKind.ESModule
  }
  
  def sources = T.sources {
    super.sources() ++ Seq(PathRef(millSourcePath / "src"))
  }
  
  def resources = T.sources {
    super.resources() ++ Seq(PathRef(millSourcePath / "resources"))
  }
}
