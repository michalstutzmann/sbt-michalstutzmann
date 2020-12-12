package com.michalstutzmann.sbtmichalstutzmann

import sbt._

import scala.language.implicitConversions

object MichalStutzmannPlugin extends MichalStutzmannPlugin

trait MichalStutzmannPlugin extends AutoPlugin {
  object autoImport {
    lazy val MichalStutzmannLibraryDependencies
        : com.michalstutzmann.sbtmichalstutzmann.MichalStutzmannLibraryDependencies.type =
      com.michalstutzmann.sbtmichalstutzmann.MichalStutzmannLibraryDependencies
  }
}
