package com.github.mwegrz.sbtmwegrz

import com.github.mwegrz.sbtlogback.LogbackPlugin
import com.github.mwegrz.sbtlogback.LogbackPlugin.autoImport._
import com.github.mwegrz.sbtmwegrz.MwegrzLibraryDependencies._
import com.typesafe.sbt.GitPlugin.autoImport.git
import com.typesafe.sbt.GitVersioning
import org.scalastyle.sbt.ScalastylePlugin
import sbt.Keys._
import sbt.{ Setting, _ }
import sbtrelease.ReleasePlugin
import sbtrelease.ReleasePlugin.autoImport._
import ReleaseTransformations._
import net.virtualvoid.sbt.graph.DependencyGraphPlugin
import org.scalafmt.sbt.ScalafmtPlugin.autoImport._
import org.scalafmt.sbt.ScalafmtPlugin
import sbtprotoc.ProtocPlugin.autoImport.PB

import scala.language.implicitConversions

object MwegrzLibraryPlugin extends MwegrzLibraryPlugin

trait MwegrzLibraryPlugin extends AutoPlugin {
  override def requires: Plugins =
    ScalafmtPlugin && ScalastylePlugin && LogbackPlugin && ReleasePlugin &&
      GitVersioning && DependencyGraphPlugin

  override def trigger: PluginTrigger = noTrigger

  override def projectConfigurations: Seq[Configuration] = Seq(IntegrationTest)

  override def projectSettings: Seq[Setting[_]] =
    Seq(
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
      scalaVersion := MwegrzLibraryDependencies.Versions.Scala,
      crossScalaVersions := Seq(scalaVersion.value, "2.12.10"),
      scalacOptions ++=
        (CrossVersion.partialVersion(scalaVersion.value) match {
          case Some((2, n)) if n >= 13 => Seq("-Xsource:2.14")
          case _                       => Seq("-Yno-adapted-args", "-deprecation", "-Ypartial-unification")
        }),
      scalafmtOnCompile := true,
      slf4jVersion := MwegrzLibraryDependencies.Versions.Slf4j,
      logbackVersion := MwegrzLibraryDependencies.Versions.Logback,
      libraryDependencies ++= Seq(
        ThreetenExtra,
        ScalaTest % "test,it",
        ScalaCheck % "test,it",
        LogbackHocon,
        ScalaStructlog,
        Config,
        "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf,compile"
      ),
      PB.targets in Compile := Seq(
        scalapb.gen() -> (sourceManaged in Compile).value
      ),
      releaseCrossBuild := false,
      releaseTagName := { (version in ThisBuild).value },
      releaseTagComment := s"Release version ${(version in ThisBuild).value}",
      releaseCommitMessage := s"Set version to ${(version in ThisBuild).value}",
      releaseProcess := Seq[ReleaseStep](
        checkSnapshotDependencies,
        inquireVersions,
        runClean,
        releaseStepCommandAndRemaining("+test"),
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
      pomIncludeRepository := { _ => false },
      git.useGitDescribe := true,
      git.formattedShaVersion := git.gitHeadCommit.value map { sha => s"$sha".substring(0, 7) },
      offline := false,
      fork in run := true,
      connectInput in run := true
    ) ++ Defaults.itSettings
}
