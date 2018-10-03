package com.github.mwegrz.sbtmwegrz

import sbt._

import scala.language.implicitConversions

object MwegrzPlugin extends MwegrzPlugin

trait MwegrzPlugin extends AutoPlugin {
  object autoImport {
    lazy val MwegrzLibraryDependencies: com.github.mwegrz.sbtmwegrz.MwegrzLibraryDependencies.type = com.github.mwegrz.sbtmwegrz.MwegrzLibraryDependencies
  }
}

