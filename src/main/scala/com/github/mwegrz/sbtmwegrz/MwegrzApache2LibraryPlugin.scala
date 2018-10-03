package com.github.mwegrz.sbtmwegrz

import sbt.Keys._
import sbt.{Setting, _}
import sbtrelease.ReleasePlugin.autoImport._
import ReleaseTransformations._
import com.typesafe.sbt.pgp.PgpKeys

import scala.language.implicitConversions

object MwegrzApache2LibraryPlugin extends MwegrzApache2LibraryPlugin

trait MwegrzApache2LibraryPlugin extends MwegrzLibraryPlugin {
  override def projectSettings: Seq[Setting[_]] = super.projectSettings ++ Seq(
    releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies,
      inquireVersions,
      runClean,
      runTest,
      setReleaseVersion,
      commitReleaseVersion,
      tagRelease,
      releaseStepCommand("publishSigned"),
      setNextVersion,
      commitNextVersion,
      releaseStepCommand("sonatypeRelease"),
      pushChanges
    ),
    releasePublishArtifactsAction := PgpKeys.publishSigned.value,
    publishTo := Some(
      if (isSnapshot.value)
        Opts.resolver.sonatypeSnapshots
      else
        Opts.resolver.sonatypeStaging
    ),
    licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")),
    homepage := None,
    scmInfo := None
  )
}
