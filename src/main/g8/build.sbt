ThisBuild / name         := "$name$"
ThisBuild / organization := "$organization$"
ThisBuild / scalaVersion := "$scala_version$"

lazy val loggingDependencies = Seq(Library.Logback, Library.ScalaLogging)

$if(use_protobuf.truthy)$
lazy val scalapbSettings = Seq( Compile / PB.targets := Seq(scalapb.gen() -> (Compile / sourceManaged).value) )
lazy val protobufDependencies = Seq(Library.Protobuf, Library.Scalapb)
$endif$

// TODO: optionally add multiple project
// Add Projects here:

lazy val $project;format="camel"$ = Project(
  id = "$project;format="camel"$",
  base = file("$project;format="norm"$"))
  .enablePlugins(PackPlugin) // TODO: Make optional based on giter8
  .settings(version := "$version$")
  .settings(
    packMain := Map("$project;format="norm"$" -> "$organization;format="package"$.$project;format="Camel"$"),
  )
  .settings(
    libraryDependencies ++= loggingDependencies$if(use_protobuf.truthy)$ ++ protobufDependencies$endif$
  )
