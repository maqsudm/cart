name := "cart"
lazy val root = Project("cart", file(".")).settings(
  scalaVersion := "2.13.8",
  version := "0.1",
  libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.13",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.13" % "test"
)