import ReleaseTransformations._

lazy val root = (project in file(".")).
  enablePlugins(SbtPlugin, ReleasePlugin, ScalafmtPlugin).
  settings(
    name := "sbt-mwegrz",
    organization := "com.github.mwegrz",
    scalacOptions ++= Seq(
      "-encoding",
      "UTF-8",
      "-deprecation",
      "-unchecked"
    ),
    scalaVersion := "2.12.8",
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-nop" % "1.7.25"
    ),
    addSbtPlugin("com.lucidchart" %% "sbt-scalafmt" % "1.15"),
    addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0"),
    addSbtPlugin("com.github.gseitz" %% "sbt-release" % "1.0.8"),
    addSbtPlugin("com.github.mwegrz" %% "sbt-logback" % "0.1.7"),
    addSbtPlugin("com.typesafe.sbt" %% "sbt-git" % "0.9.3"),
    addSbtPlugin("com.typesafe.sbt" %% "sbt-native-packager" % "1.3.4"),
    addSbtPlugin("io.spray" %% "sbt-revolver" % "0.9.1"),
    addSbtPlugin("com.jsuereth" %% "sbt-pgp" % "1.1.1"),
    addSbtPlugin("org.xerial.sbt" %% "sbt-sonatype" % "2.3"),
    addSbtPlugin("net.virtual-void" %% "sbt-dependency-graph" % "0.9.2"),
    addSbtPlugin("com.github.cb372" %% "sbt-explicit-dependencies" % "0.2.6"),
    // Release settings
    releaseTagName := { (version in ThisBuild).value },
    releaseTagComment := s"Release version ${(version in ThisBuild).value}",
    releaseCommitMessage := s"Set version to ${(version in ThisBuild).value}",
    releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies,
      inquireVersions,
      runClean,
      runTest,
      setReleaseVersion,
      commitReleaseVersion,
      tagRelease,
      releaseStepCommandAndRemaining("publishSigned"),
      setNextVersion,
      commitNextVersion,
      releaseStepCommandAndRemaining("sonatypeReleaseAll"),
      pushChanges
    ),
    releasePublishArtifactsAction := PgpKeys.publishSigned.value,
    // Publish settings
    publishTo := Some(
      if (isSnapshot.value)
        Opts.resolver.sonatypeSnapshots
      else
        Opts.resolver.sonatypeStaging
    ),
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { _ => false },
    licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")),
    homepage := Some(url("http://github.com/mwegrz/sbt-mwegrz")),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/mwegrz/sbt-mwegrz.git"),
        "scm:git@github.com:mwegrz/sbt-mwegrz.git"
      )
    ),
    developers := List(
      Developer(
        id = "mwegrz",
        name = "Michał Węgrzyn",
        email = null,
        url = url("https://github.com/mwegrz")
      )
    )
  )
