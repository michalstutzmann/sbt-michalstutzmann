package com.github.mwegrz.sbtmwegrz

import com.github.mwegrz.sbtlogback.LogbackPlugin
import com.github.mwegrz.sbtlogback.LogbackPlugin.autoImport._
import com.lucidchart.sbt.scalafmt.ScalafmtCorePlugin.autoImport._
import com.lucidchart.sbt.scalafmt.ScalafmtPlugin
import com.github.mwegrz.sbtmwegrz.MwegrzLibraryDependencies._
import com.typesafe.sbt.GitPlugin.autoImport.git
import com.typesafe.sbt.GitVersioning
import org.scalastyle.sbt.ScalastylePlugin
import sbt.Keys._
import sbt.{Setting, _}
import sbtrelease.ReleasePlugin
import sbtrelease.ReleasePlugin.autoImport._
import ReleaseTransformations._
import net.virtualvoid.sbt.graph.DependencyGraphPlugin

import scala.language.implicitConversions

object MwegrzLibraryPlugin extends MwegrzLibraryPlugin

trait MwegrzLibraryPlugin extends AutoPlugin {
  override def requires: Plugins = ScalafmtPlugin && ScalastylePlugin && LogbackPlugin && ReleasePlugin &&
    GitVersioning && DependencyGraphPlugin

  override def trigger: PluginTrigger = noTrigger

  override def projectConfigurations: Seq[Configuration] = Seq(IntegrationTest)

  override def projectSettings: Seq[Setting[_]] = Seq(
    organization := "com.github.mwegrz",
    organizationName := "Michał Węgrzyn",
    developers := List(
      Developer(
        id = "mwegrz",
        name = "Michał Węgrzyn",
        email = null,
        url = url("https://github.com/mwegrz")
      )
    ),

    scalacOptions in ThisBuild ++= Seq("-feature", "-deprecation"),

    scalaVersion := MwegrzLibraryDependencies.Versions.Scala,
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full),

    scalafmtOnCompile := true,

    slf4jVersion := MwegrzLibraryDependencies.Versions.Slf4j,
    logbackVersion := MwegrzLibraryDependencies.Versions.Logback,

    resolvers += Opts.resolver.sonatypeStaging,

    libraryDependencies ++= Seq(
      ThreetenExtra,
      ScalaTest % "test,it",
      ScalaCheck % "test,it",
      LogbackHocon,
      ScalaStructlog,
      Config,
      Ficus
    ),

    releaseTagName := { (version in ThisBuild).value },
    releaseTagComment := s"Release version ${(version in ThisBuild).value}",
    releaseCommitMessage := s"Set version to ${(version in ThisBuild).value}",
    releaseCrossBuild := true,

    releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies,
      inquireVersions,
      runClean,
      runTest,
      setReleaseVersion,
      commitReleaseVersion,
      tagRelease,
      setNextVersion,
      commitNextVersion,
      pushChanges
    ),

    crossPaths := true,
    autoScalaLibrary := true,
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { _ =>
      false
    },

    git.useGitDescribe := true,

    offline := false,
    fork in run := true,
    connectInput in run := true
  ) ++ Defaults.itSettings
}
