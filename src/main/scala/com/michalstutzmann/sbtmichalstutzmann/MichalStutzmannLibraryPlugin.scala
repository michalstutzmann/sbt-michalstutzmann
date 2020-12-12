package com.michalstutzmann.sbtmichalstutzmann

import com.github.mwegrz.sbtlogback.LogbackPlugin
import com.github.mwegrz.sbtlogback.LogbackPlugin.autoImport._
import MichalStutzmannLibraryDependencies._
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

object MichalStutzmannLibraryPlugin extends MichalStutzmannLibraryPlugin

trait MichalStutzmannLibraryPlugin extends AutoPlugin {
  override def requires: Plugins =
    ScalafmtPlugin && ScalastylePlugin && LogbackPlugin && ReleasePlugin &&
      GitVersioning && DependencyGraphPlugin

  override def trigger: PluginTrigger = noTrigger

  override def projectConfigurations: Seq[Configuration] = Seq(IntegrationTest)

  override def projectSettings: Seq[Setting[_]] =
    Seq(
      organization := "com.michalstutzmann",
      organizationName := "Michał Stutzmann",
      developers := List(
        Developer(
          id = "michalstutzmann",
          name = "Michał Stutzmann",
          email = null,
          url = url("https://github.com/michalstutzmann")
        )
      ),
      scalaVersion := MichalStutzmannLibraryDependencies.Versions.Scala,
      crossScalaVersions := Seq(scalaVersion.value, "2.12.12"),
      scalacOptions ++=
        (CrossVersion.partialVersion(scalaVersion.value) match {
          case Some((2, n)) if n >= 13 => Seq("-Xsource:2.14")
          case _                       => Seq("-Yno-adapted-args", "-deprecation", "-Ypartial-unification")
        }),
      scalafmtCheck := true,
      scalafmtSbtCheck := true,
      slf4jVersion := MichalStutzmannLibraryDependencies.Versions.Slf4j,
      logbackVersion := MichalStutzmannLibraryDependencies.Versions.Logback,
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
