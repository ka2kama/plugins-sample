import Piyo.notAutoImport

name := "plugins-sample"

version := "0.1"

scalaVersion := "2.13.1"

lazy val root = (project in file("."))
  .enablePlugins(Foo)
  .settings(
    commands += notAutoImport.piyoCommand,
    commands += fugaCommand,
  )
// lazy val root = (project in file(".")).enablePlugins(Baz)
// lazy val root = (project in file(".")).enablePlugins(Foo).disablePlugins(Hoge)
