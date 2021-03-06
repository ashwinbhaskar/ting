val dottyVersion = "0.20.0-RC1"
val scala212Version = "2.13.1"

enablePlugins(GraalVMNativeImagePlugin)

graalVMNativeImageOptions ++= Seq(
  "--initialize-at-build-time",
  "--initialize-at-run-time=" +
    "com.typesafe.config.impl.ConfigImpl$EnvVariablesHolder," +
    "com.typesafe.config.impl.ConfigImpl$SystemPropertiesHolder",
  "--no-fallback",
  "--static"
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "ting",
    version := "0.1.0",
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",
    libraryDependencies += "net.jcazevedo" % "moultingyaml_2.13" % "0.4.1",
    libraryDependencies += "com.lihaoyi" % "os-lib_2.13" % "0.3.0",
    // To make the default compiler and REPL use Dotty
    scalaVersion := dottyVersion
  )
