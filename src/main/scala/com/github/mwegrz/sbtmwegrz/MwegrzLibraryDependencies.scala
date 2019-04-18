package com.github.mwegrz.sbtmwegrz

import sbt._

object MwegrzLibraryDependencies extends MwegrzLibraryDependencies

trait MwegrzLibraryDependencies {
  object Versions {
    lazy val Scala: String = "2.12.8"
    lazy val ScalaCollectionCompat = "0.2.1"
    lazy val ThreetenExtra: String  = "1.4"
    lazy val Akka: String  = "2.5.21"
    lazy val AkkaHttp: String  = "10.1.7"
    lazy val AkkaPersistenceCassandra: String = "0.93"

    lazy val AkkaHttpJson: String  = "1.23.0"
    lazy val Alpakka: String  = "1.0.0"
    lazy val Slf4j: String  = "1.7.25"
    lazy val Logback: String  = "1.2.3"
    lazy val ScalaTest: String  = "3.0.5"
    lazy val ScalaCheck: String  = "1.14.0"
    lazy val LogbackHocon: String  = "0.1.6"
    lazy val ScalaStructlog: String  = "0.1.9"
    lazy val ScalaUtil: String  = "0.1.41"
    lazy val Config: String  = "1.3.3"
    lazy val BcpkixJdk15on: String  = "1.61"
    lazy val BouncyCastle: String  = BcpkixJdk15on
    lazy val Circe: String  = "0.11.1"
    lazy val JwtCirce: String  = "2.1.0"
    lazy val ScodecCore: String  = "1.11.3"
    lazy val ScodecBits = "1.1.9"
    lazy val Avro4s: String  = "2.0.4"
    lazy val Kebs: String  = "1.6.2"
    lazy val Cats: String = "1.6.0"
    lazy val Scalactic: String = ScalaTest
    lazy val ScalaApp: String = "0.1.10"
    lazy val CommonsVfs2: String = "2.1"
    lazy val CommonsPool: String = "1.6"
    lazy val AlpakkaKafka: String = "1.0.1"
    lazy val CassandraDriver: String = "3.6.0"
    lazy val NetemeraScalaClient: String = "0.3.39"
    lazy val Time4J: String = "4.38"
    lazy val Kamon: String = "1.1.4"
    lazy val Pulsar4S: String = "2.2.0"
    lazy val Ficus: String = "1.4.3"
    lazy val JBcrypt: String = "0.3m"
    lazy val JavaJwt: String = "3.3.0"
    lazy val GoogleMapsServices: String = "0.2.9"
    lazy val BetterFiles: String = "3.6.0"
    lazy val Geodesy: String = "1.1.3"
    lazy val Slick: String = "3.2.3"
  }

  //"scala-parallel-collections" % Versions.Scala
  lazy val ScalaCollectionCompat: ModuleID = "org.scala-lang.modules" %% "scala-collection-compat" % Versions.ScalaCollectionCompat
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
  lazy val AkkaPersistenceCassandra: ModuleID = "com.typesafe.akka" %% "akka-persistence-cassandra" % Versions.AkkaPersistenceCassandra
  lazy val AkkaPersistenceCassandraLauncher: ModuleID = "com.typesafe.akka" %% "akka-persistence-cassandra-launcher" % Versions.AkkaPersistenceCassandra
  lazy val AkkaSlf4j: ModuleID = "com.typesafe.akka" %% "akka-slf4j" % Versions.Akka

  // Akka HTTP
  lazy val AkkaHttp: ModuleID = "com.typesafe.akka" %% "akka-http" % Versions.AkkaHttp
  lazy val AkkaHttpTestkit: ModuleID = "com.typesafe.akka" %% "akka-http-testkit" % Versions.AkkaHttp
  lazy val AkkaHttp2Support: ModuleID = "com.typesafe.akka" %% "akka-http2-support" % Versions.AkkaHttp
  lazy val AkkaHttpCirce: ModuleID = "de.heikoseeberger" %% "akka-http-circe" % Versions.AkkaHttpJson
  lazy val AkkaHttpAvro4s: ModuleID = "de.heikoseeberger" %% "akka-http-avro4s" % Versions.AkkaHttpJson

  // Alpakka
  lazy val AkkaStreamAlpakkaSse: ModuleID = "com.lightbend.akka" %% "akka-stream-alpakka-sse" % Versions.Alpakka
  lazy val AkkaStreamAlpakkaCassandra: ModuleID = "com.lightbend.akka" %% "akka-stream-alpakka-cassandra" % Versions.Alpakka
  lazy val AkkaStreamAlpakkaMqttStreaming: ModuleID = "com.lightbend.akka" %% "akka-stream-alpakka-mqtt-streaming" % Versions.Alpakka
  lazy val AkkaStreamAlpakkaUdp: ModuleID = "com.lightbend.akka" %% "akka-stream-alpakka-udp" % Versions.Alpakka

  lazy val ScalaTest: ModuleID = "org.scalatest" %% "scalatest" % Versions.ScalaTest
  lazy val Scalactic: ModuleID = "org.scalactic" %% "scalactic" % Versions.Scalactic
  lazy val ScalaCheck: ModuleID = "org.scalacheck" %% "scalacheck" % Versions.ScalaCheck

  lazy val LogbackHocon: ModuleID = "com.github.mwegrz" % "logback-hocon" % Versions.LogbackHocon
  lazy val ScalaStructlog: ModuleID = "com.github.mwegrz" %% "scala-structlog" % Versions.ScalaStructlog

  lazy val ScalaApp: ModuleID = "com.github.mwegrz" %% "scala-app" % Versions.ScalaApp
  lazy val ScalaUtil: ModuleID = "com.github.mwegrz" %% "scala-util" % Versions.ScalaUtil

  lazy val Config: ModuleID = "com.typesafe" % "config" % Versions.Config
  lazy val Ficus: ModuleID = "com.iheart" %% "ficus" % Versions.Ficus

  lazy val CirceCore: ModuleID = "io.circe" %% "circe-core" % Versions.Circe
  lazy val CirceGeneric: ModuleID = "io.circe" %% "circe-generic" % Versions.Circe
  lazy val CirceGenericExtras: ModuleID = "io.circe" %% "circe-generic-extras" % Versions.Circe
  lazy val CirceParser: ModuleID = "io.circe" %% "circe-parser" % Versions.Circe
  lazy val CirceJava8: ModuleID = "io.circe" %% "circe-java8" % Versions.Circe
  lazy val Circe: Seq[ModuleID] = Seq(CirceCore, CirceGeneric, CirceGenericExtras, CirceParser, CirceJava8)

  lazy val CatsCore: ModuleID = "org.typelevel" %% "cats-core" % Versions.Cats

  lazy val Avro4sCore: ModuleID = "com.sksamuel.avro4s" %% "avro4s-core" % Versions.Avro4s
  lazy val JwtCirce: ModuleID = "com.pauldijou" %% "jwt-circe" % Versions.JwtCirce
  lazy val BcpkixJdk15on: ModuleID = "org.bouncycastle" % "bcpkix-jdk15on" % Versions.BouncyCastle
  lazy val BouncyCastle: ModuleID = BcpkixJdk15on
  lazy val ScodecCore: ModuleID = "org.scodec" %% "scodec-core" % Versions.ScodecCore
  lazy val ScodecBits: ModuleID = "org.scodec" %% "scodec-bits" % Versions.ScodecBits
  lazy val KebsAvro: ModuleID = "pl.iterators" %% "kebs-avro" % Versions.Kebs
  lazy val CassandraDriverCore: ModuleID = "com.datastax.cassandra" % "cassandra-driver-core" % Versions.CassandraDriver
  lazy val CassandraDriverExtras: ModuleID = "com.datastax.cassandra" % "cassandra-driver-extras" % Versions.CassandraDriver

  lazy val AlpakkaKafka: ModuleID = "com.typesafe.akka" %% "akka-stream-kafka" % Versions.AlpakkaKafka
  lazy val CommonsVfs2: ModuleID = "org.apache.commons" % "commons-vfs2" % Versions.CommonsVfs2
  lazy val CommonsPool: ModuleID = "commons-pool" % "commons-pool" % Versions.CommonsPool
  lazy val NetemeraScalaClient: ModuleID = "com.netemera" %% "netemera-scala-client" % Versions.NetemeraScalaClient
  lazy val Time4jCore: ModuleID = "net.time4j" % "time4j-core" % Versions.Time4J
  lazy val Pulsar4sAkkaStreams: ModuleID = "com.sksamuel.pulsar4s" %% "pulsar4s-akka-streams" % Versions.Pulsar4S
  lazy val NettyTransportNativeEpoll: ModuleID = "io.netty" % "netty-transport-native-epoll" % "4.1.21.Final" // Cassandra asks for it
  lazy val HttpClient: ModuleID = "org.apache.httpcomponents" % "httpclient" % "4.5.5"

  lazy val JBcrypt: ModuleID = "org.mindrot" % "jbcrypt" % Versions.JBcrypt
  lazy val KamonCore: ModuleID = "io.kamon" %% "kamon-core" % Versions.Kamon
  lazy val GoogleMapsServices: ModuleID = "com.google.maps" % "google-maps-services" % Versions.GoogleMapsServices
  lazy val BetterFiles: ModuleID = "com.github.pathikrit" %% "better-files" % Versions.BetterFiles
  lazy val Geodesy: ModuleID = "org.gavaghan" % "geodesy" % Versions.Geodesy
  lazy val Slick: ModuleID = "com.typesafe.slick" %% "slick" % Versions.Slick
  lazy val SlickHikaricp: ModuleID = "com.typesafe.slick" %% "slick-hikaricp" % Versions.Slick
}
