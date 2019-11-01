package com.github.mwegrz.sbtmwegrz

import sbt._

object MwegrzLibraryDependencies extends MwegrzLibraryDependencies

trait MwegrzLibraryDependencies {
  object Versions {
    lazy val Scala: String = "2.13.1"
    lazy val ThreetenExtra: String = "1.5.0"
    lazy val Akka: String = "2.5.26"
    lazy val AkkaHttp: String = "10.1.10"
    lazy val AkkaHttpCors: String = "0.4.1"
    lazy val AkkaPersistenceCassandra: String = "0.100"

    lazy val AkkaHttpJson: String = "1.29.1"
    lazy val Alpakka: String = "1.1.2"
    lazy val Slf4j: String = "1.7.25"
    lazy val Logback: String = "1.2.3"
    lazy val ScalaTest: String = "3.0.8"
    lazy val ScalaCheck: String = "1.14.0"
    lazy val LogbackHocon: String = "0.1.7"
    lazy val ScalaStructlog: String = "0.1.16-SNAPSHOT"
    lazy val ScalaUtil: String = "0.1.58-SNAPSHOT"
    lazy val Config: String = "1.3.4"
    lazy val BcpkixJdk15on: String = "1.61"
    lazy val BouncyCastle: String = BcpkixJdk15on
    lazy val Circe: String = "0.12.3"
    lazy val JwtCirce: String = "4.1.0"
    lazy val ScodecCore: String = "1.11.4"
    lazy val ScodecBits = "1.1.12"
    lazy val Avro4s: String = "3.0.2"
    lazy val Cats: String = "2.0.0"
    lazy val Scalactic: String = ScalaTest
    lazy val ScalaApp: String = "0.1.13"
    lazy val CommonsVfs2: String = "2.1"
    lazy val CommonsPool: String = "1.6"
    lazy val AlpakkaKafka: String = "1.0.4"
    lazy val CassandraDriverCore: String = "3.5.1"
    lazy val CassandraDriverExtras: String = CassandraDriverCore
    lazy val NetemeraScalaClient: String = "0.3.50-SNAPSHOT"
    lazy val Time4J: String = "4.38"
    lazy val JBcrypt: String = "0.4"
    lazy val GoogleMapsServices: String = "0.9.3"
    lazy val BetterFiles: String = "3.8.0"
    lazy val Geodesy: String = "1.1.3"
    lazy val Slick: String = "3.3.2"
  }

  lazy val ThreetenExtra: ModuleID = "org.threeten" % "threeten-extra" % Versions.ThreetenExtra

  // Akka
  lazy val AkkaActor: ModuleID = "com.typesafe.akka" %% "akka-actor" % Versions.Akka
  lazy val AkkaTestkit: ModuleID = "com.typesafe.akka" %% "akka-testkit" % Versions.Akka
  lazy val AkkaStream: ModuleID = "com.typesafe.akka" %% "akka-stream" % Versions.Akka
  lazy val AkkaStreamTestKit: ModuleID = "com.typesafe.akka" %% "akka-stream-testkit" % Versions.Akka
  lazy val AkkaRemote: ModuleID = "com.typesafe.akka" %% "akka-remote" % Versions.Akka
  lazy val AkkaCluster: ModuleID = "com.typesafe.akka" %% "akka-cluster" % Versions.Akka
  lazy val AkkaClusterTools: ModuleID = "com.typesafe.akka" %% "akka-cluster-tools" % Versions.Akka
  lazy val AkkaPersistence: ModuleID = "com.typesafe.akka" %% "akka-persistence" % Versions.Akka
  lazy val AkkaPersistenceQuery: ModuleID = "com.typesafe.akka" %% "akka-persistence-query" % Versions.Akka
  lazy val AkkaPersistenceCassandra
      : ModuleID = "com.typesafe.akka" %% "akka-persistence-cassandra" % Versions.AkkaPersistenceCassandra
  lazy val AkkaPersistenceCassandraLauncher
      : ModuleID = "com.typesafe.akka" %% "akka-persistence-cassandra-launcher" % Versions.AkkaPersistenceCassandra
  lazy val AkkaSlf4j: ModuleID = "com.typesafe.akka" %% "akka-slf4j" % Versions.Akka

  // Akka Typed
  lazy val AkkaPersistenceTyped: ModuleID = "com.typesafe.akka" %% "akka-persistence-typed" % Versions.Akka

  // Akka HTTP
  lazy val AkkaHttp: ModuleID = "com.typesafe.akka" %% "akka-http" % Versions.AkkaHttp
  lazy val AkkaHttpTestkit: ModuleID = "com.typesafe.akka" %% "akka-http-testkit" % Versions.AkkaHttp
  lazy val AkkaHttp2Support: ModuleID = "com.typesafe.akka" %% "akka-http2-support" % Versions.AkkaHttp
  lazy val AkkaHttpCors: ModuleID = "ch.megard" %% "akka-http-cors" % Versions.AkkaHttpCors
  lazy val AkkaHttpCirce: ModuleID = "de.heikoseeberger" %% "akka-http-circe" % Versions.AkkaHttpJson
  lazy val AkkaHttpAvro4s: ModuleID = "de.heikoseeberger" %% "akka-http-avro4s" % Versions.AkkaHttpJson

  // Alpakka
  lazy val AkkaStreamAlpakkaSse: ModuleID = "com.lightbend.akka" %% "akka-stream-alpakka-sse" % Versions.Alpakka
  lazy val AkkaStreamAlpakkaCassandra
      : ModuleID = "com.lightbend.akka" %% "akka-stream-alpakka-cassandra" % Versions.Alpakka
  lazy val AkkaStreamAlpakkaMqttStreaming
      : ModuleID = "com.lightbend.akka" %% "akka-stream-alpakka-mqtt-streaming" % Versions.Alpakka
  lazy val AkkaStreamAlpakkaUdp: ModuleID = "com.lightbend.akka" %% "akka-stream-alpakka-udp" % Versions.Alpakka

  lazy val ScalaTest: ModuleID = "org.scalatest" %% "scalatest" % Versions.ScalaTest
  lazy val Scalactic: ModuleID = "org.scalactic" %% "scalactic" % Versions.Scalactic
  lazy val ScalaCheck: ModuleID = "org.scalacheck" %% "scalacheck" % Versions.ScalaCheck

  lazy val LogbackHocon: ModuleID = "com.github.mwegrz" % "logback-hocon" % Versions.LogbackHocon
  lazy val ScalaStructlog: ModuleID = "com.github.mwegrz" %% "scala-structlog" % Versions.ScalaStructlog

  lazy val ScalaApp: ModuleID = "com.github.mwegrz" %% "scala-app" % Versions.ScalaApp
  lazy val ScalaUtil: ModuleID = "com.github.mwegrz" %% "scala-util" % Versions.ScalaUtil

  lazy val Config: ModuleID = "com.typesafe" % "config" % Versions.Config

  lazy val CirceCore: ModuleID = "io.circe" %% "circe-core" % Versions.Circe
  lazy val CirceGeneric: ModuleID = "io.circe" %% "circe-generic" % Versions.Circe
  lazy val CirceGenericExtras: ModuleID = "io.circe" %% "circe-generic-extras" % Versions.Circe
  lazy val CirceParser: ModuleID = "io.circe" %% "circe-parser" % Versions.Circe
  lazy val CirceJava8: ModuleID = "io.circe" %% "circe-java8" % Versions.Circe
  lazy val Circe: Seq[ModuleID] =
    Seq(CirceCore, CirceGeneric, CirceGenericExtras, CirceParser, CirceJava8)

  lazy val CatsCore: ModuleID = "org.typelevel" %% "cats-core" % Versions.Cats

  lazy val Avro4sCore: ModuleID = "com.sksamuel.avro4s" %% "avro4s-core" % Versions.Avro4s
  lazy val JwtCirce: ModuleID = "com.pauldijou" %% "jwt-circe" % Versions.JwtCirce
  lazy val BcpkixJdk15on: ModuleID = "org.bouncycastle" % "bcpkix-jdk15on" % Versions.BouncyCastle
  lazy val BouncyCastle: ModuleID = BcpkixJdk15on
  lazy val ScodecCore: ModuleID = "org.scodec" %% "scodec-core" % Versions.ScodecCore
  lazy val ScodecBits: ModuleID = "org.scodec" %% "scodec-bits" % Versions.ScodecBits
  lazy val CassandraDriverCore
      : ModuleID = "com.datastax.cassandra" % "cassandra-driver-core" % Versions.CassandraDriverCore
  lazy val CassandraDriverExtras
      : ModuleID = "com.datastax.cassandra" % "cassandra-driver-extras" % Versions.CassandraDriverExtras

  lazy val AlpakkaKafka: ModuleID = "com.typesafe.akka" %% "akka-stream-kafka" % Versions.AlpakkaKafka
  lazy val CommonsVfs2: ModuleID = "org.apache.commons" % "commons-vfs2" % Versions.CommonsVfs2
  lazy val CommonsPool: ModuleID = "commons-pool" % "commons-pool" % Versions.CommonsPool
  lazy val NetemeraScalaClient: ModuleID = "com.netemera" %% "netemera-scala-client" % Versions.NetemeraScalaClient
  lazy val Time4jCore: ModuleID = "net.time4j" % "time4j-core" % Versions.Time4J
  lazy val NettyTransportNativeEpoll
      : ModuleID = "io.netty" % "netty-transport-native-epoll" % "4.1.21.Final" // Cassandra asks for it
  lazy val HttpClient: ModuleID = "org.apache.httpcomponents" % "httpclient" % "4.5.5"

  lazy val JBcrypt: ModuleID = "org.mindrot" % "jbcrypt" % Versions.JBcrypt
  lazy val GoogleMapsServices: ModuleID = "com.google.maps" % "google-maps-services" % Versions.GoogleMapsServices
  lazy val BetterFiles: ModuleID = "com.github.pathikrit" %% "better-files" % Versions.BetterFiles
  lazy val Geodesy: ModuleID = "org.gavaghan" % "geodesy" % Versions.Geodesy
  lazy val Slick: ModuleID = "com.typesafe.slick" %% "slick" % Versions.Slick
  lazy val SlickHikaricp: ModuleID = "com.typesafe.slick" %% "slick-hikaricp" % Versions.Slick
}
