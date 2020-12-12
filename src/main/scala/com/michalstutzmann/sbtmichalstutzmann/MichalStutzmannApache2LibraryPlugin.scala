package com.michalstutzmann.sbtmichalstutzmann

import sbt.Keys._
import sbt.{ Setting, _ }
import sbtrelease.ReleasePlugin.autoImport._
import ReleaseTransformations._
import com.jsuereth.sbtpgp.PgpKeys

import scala.language.implicitConversions

object MichalStutzmannApache2LibraryPlugin extends MichalStutzmannApache2LibraryPlugin

trait MichalStutzmannApache2LibraryPlugin extends MichalStutzmannLibraryPlugin {
  override def projectSettings: Seq[Setting[_]] =
    super.projectSettings ++ Seq(
      releaseProcess := Seq[ReleaseStep](
        checkSnapshotDependencies,
        inquireVersions,
        runClean,
        releaseStepCommandAndRemaining("test"),
        setReleaseVersion,
        commitReleaseVersion,
        tagRelease,
        releaseStepCommand("publishSigned"),
        setNextVersion,
        commitNextVersion,
        releaseStepCommand("sonatypeReleaseAll"),
        pushChanges
      ),
      releasePublishArtifactsAction := PgpKeys.publishSigned.value,
      publishTo := Some(
        if (isSnapshot.value)
          Opts.resolver.sonatypeSnapshots
        else
          Opts.resolver.sonatypeStaging
      ),
      licenses := Seq(
        "Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")
      ),
      homepage := None,
      scmInfo := None
    )
}
