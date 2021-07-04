import mill._, scalalib._, scalajslib._

object Versions {
  val scalaVersion = "2.13.6"
  val scalaJSVersion = "1.6.0"

  val zioVersion = "1.0.9"
  val laminarVersion = "0.13.0"
  // val airStreamVersion = "0.13.0"

}

trait Common extends ScalaModule {
  override def scalaVersion = Versions.scalaVersion

  override def sources = T.sources {
    super.sources() ++ Seq(
      PathRef(millSourcePath / os.up / "shared" / "src")
    )
  }

  def ivyDeps = super.ivyDeps() ++ Agg(
    ivy"dev.zio::zio::${Versions.zioVersion}"
  )

  def scalacPluginIvyDeps = super.scalacPluginIvyDeps() ++ Agg(
    ivy"org.typelevel:::kind-projector:0.13.0",
    ivy"com.olegpy::better-monadic-for:0.3.1"
  )
}

object frontend extends Common with ScalaJSModule {
  override def scalaJSVersion = Versions.scalaJSVersion

  def moduleKind = T(mill.scalajslib.api.ModuleKind.ESModule)

  def ivyDeps = super.ivyDeps() ++ Agg(
    ivy"com.raquo::laminar::${Versions.laminarVersion}"
    // ivy"com.raquo::airstream::${Versions.airStreamVersion}"
  )

}
