import sbt._
$if(use_protobuf.truthy)$
import scalapb.compiler.Version.scalapbVersion
$endif$

object Version {
  $if(use_protobuf.truthy)$
  final val Protobuf     = "$protobuf_version$"
  $endif$
  final val Logback      = "$logback_version$"
  final val ScalaLogging = "$scala_logging_version$"
}

object Library {
  $if(use_protobuf.truthy)$
  final val Protobuf: ModuleID     = "com.google.protobuf"         % "protobuf-java"   % Version.Protobuf
  final val Scalapb: ModuleID      = "com.thesamet.scalapb"       %% "scalapb-runtime" % scalapbVersion       % "protobuf"
  $endif$
  final val Logback: ModuleID      = "ch.qos.logback"              % "logback-classic" % Version.Logback
  final val ScalaLogging: ModuleID = "com.typesafe.scala-logging" %% "scala-logging"   % Version.ScalaLogging
}
