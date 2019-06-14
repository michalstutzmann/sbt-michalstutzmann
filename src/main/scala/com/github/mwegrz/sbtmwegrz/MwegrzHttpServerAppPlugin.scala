package com.github.mwegrz.sbtmwegrz

import com.typesafe.sbt.packager.archetypes.JavaServerAppPackaging
import com.typesafe.sbt.SbtNativePackager
import com.typesafe.sbt.SbtNativePackager.autoImport._
import com.typesafe.sbt.packager.docker.DockerPlugin
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport._
import sbt.Keys._
import sbt.{ Setting, _ }
import spray.revolver.RevolverPlugin
import spray.revolver.RevolverPlugin.autoImport._
import com.typesafe.sbt.packager.universal.UniversalPlugin.autoImport._
import com.github.mwegrz.sbtmwegrz.MwegrzLibraryDependencies._
import net.virtualvoid.sbt.graph.DependencyGraphPlugin

import scala.language.implicitConversions

object MwegrzHttpServerAppPlugin extends MwegrzHttpServerAppPlugin

trait MwegrzHttpServerAppPlugin extends MwegrzLibraryPlugin {
  override def requires: Plugins =
    super.requires && SbtNativePackager && JavaServerAppPackaging && DockerPlugin && RevolverPlugin && DependencyGraphPlugin

  override def projectSettings: Seq[Setting[_]] =
    super.projectSettings ++ Seq(
      libraryDependencies ++= Seq(
        ScalaApp,
        AkkaActor,
        AkkaStream,
        AkkaStreamTestKit,
        AkkaPersistence,
        AkkaPersistenceQuery,
        AkkaCluster,
        AkkaClusterTools,
        AkkaPersistenceCassandra,
        "com.google.guava" % "guava" % "19.0" force (),
        AkkaPersistenceCassandraLauncher % "test,it",
        AkkaSlf4j,
        AkkaHttp,
        AkkaHttpCors,
        AkkaHttp2Support,
        AkkaHttpTestkit % "test,it",
        AkkaHttpCirce,
        AkkaHttpAvro4s,
        JwtCirce,
        CirceCore,
        CirceGeneric,
        CirceGenericExtras,
        CirceParser,
        Avro4sCore
      ),
      Revolver.enableDebugging(port = 5050, suspend = false),
      maintainer := "Michał Węgrzyn",
      packageSummary := name.value,
      packageDescription := name.value,
      topLevelDirectory := None,
      dockerBaseImage := "mwegrz/docker-java-jre:2.0.1",
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
