$if(use_pack.truthy)$addSbtPlugin("org.xerial.sbt" % "sbt-pack" % "$sbtpack_version$")$endif$
$if(use_protobuf.truthy)$
addSbtPlugin("com.thesamet" % "sbt-protoc" % "$sbt_protoc_version$")
libraryDependencies += "com.thesamet.scalapb" %% "compilerplugin" % "$scalapb_compilerplugin_version$"
$endif$

