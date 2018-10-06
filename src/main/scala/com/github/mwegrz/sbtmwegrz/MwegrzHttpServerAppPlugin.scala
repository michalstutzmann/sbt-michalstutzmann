package com.github.mwegrz.sbtmwegrz

import com.typesafe.sbt.packager.archetypes.JavaServerAppPackaging
import com.typesafe.sbt.SbtNativePackager
import com.typesafe.sbt.SbtNativePackager.autoImport._
import com.typesafe.sbt.packager.docker.DockerPlugin
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport._
import sbt.Keys._
import sbt.{Setting, _}
import spray.revolver.RevolverPlugin
import spray.revolver.RevolverPlugin.autoImport._
import com.typesafe.sbt.packager.universal.UniversalPlugin.autoImport._
import com.github.mwegrz.sbtmwegrz.MwegrzLibraryDependencies._

import scala.language.implicitConversions

object MwegrzHttpServerAppPlugin extends MwegrzHttpServerAppPlugin

trait MwegrzHttpServerAppPlugin extends MwegrzLibraryPlugin {
  override def requires: Plugins = super.requires && SbtNativePackager && JavaServerAppPackaging && DockerPlugin && RevolverPlugin

  override def projectSettings: Seq[Setting[_]] = super.projectSettings ++ Seq(
    libraryDependencies ++= Seq(
      ScalaApp,
      AkkaActor,
      AkkaStream,
      AkkaPersistence,
      AkkaPersistenceCassandra,
      AkkaPersistenceCassandraLauncher % "test,it",
      AkkaSlf4j,
      AkkaHttp,
      AkkaHttpTestkit % "test,it",
      AkkaHttpCirce,
      AkkaHttpAvro4s,
      JwtCirce,
      CirceCore,
      CirceGeneric,
      CirceGenericExtras,
      CirceParser,
      CirceJava8,
      Avro4sCore,
      KebsAvro
    ),

    Revolver.enableDebugging(port = 5050, suspend = false),

    maintainer := "Michał Węgrzyn",
    packageSummary := name.value,
    packageDescription := name.value,
    topLevelDirectory := None,

    dockerBaseImage := "mwegrz/docker-java-jre:0.1.10",
    dockerUpdateLatest := true,
    dockerAlias := DockerAlias(
      dockerRepository.value,
      dockerUsername.value,
      (packageName in Docker).value,
      Some((version in Docker).value)
    ),
    dockerExposedPorts := Seq(8080)
  ) ++ Defaults.itSettings
}

