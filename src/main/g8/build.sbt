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
  $if(use_pack.truthy)$.enablePlugins(PackPlugin)$endif$
  .settings(version := "$version$")
  $if(use_pack.truthy)$
  .settings(
    packMain := Map("$project;format="norm"$" -> "$organization;format="package"$.$project;format="Camel"$"),
  )
  $endif$
  .settings(
    libraryDependencies ++= loggingDependencies$if(use_protobuf.truthy)$ ++ protobufDependencies$endif$
  )
