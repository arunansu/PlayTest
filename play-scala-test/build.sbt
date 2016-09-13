name := """play-scala-test"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

EclipseKeys.preTasks := Seq(compile in Compile)

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.sorm-framework" % "sorm" % "0.3.20",
  "com.h2database" % "h2" % "1.4.192",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)
