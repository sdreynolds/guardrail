package dev.guardrail.sbt.modules

import dev.guardrail.sbt.Build._

import sbt._
import sbt.Keys._

object javaSpringMvc {
  val javaxAnnotationVersion = "1.3.2"
  val scalatestVersion       = "3.2.10"
  val springBootVersion      = "2.5.6"

  val dependencies = Seq(
    "org.springframework.boot"   %  "spring-boot-starter-web"  % springBootVersion,
    "javax.annotation"           %  "javax.annotation-api"    % javaxAnnotationVersion, // for jdk11
    "javax.validation"           %  "validation-api"           % "2.0.1.Final",
    "junit"                      %  "junit"                    % "4.13.2"           % Test,
    "org.springframework.boot"   %  "spring-boot-starter-test" % springBootVersion  % Test,
  ) ++ Seq(
    "org.scala-lang.modules"     %% "scala-java8-compat"       % "1.0.1"            % Test,
    "org.scalatest"              %% "scalatest"                % scalatestVersion   % Test,
    "org.mockito"                %% "mockito-scala"            % "1.16.46"           % Test,
  ).map(_.cross(CrossVersion.for3Use2_13))

  val project = commonModule("java-spring-mvc")

  val sample = buildSampleProject("springMvc", dependencies)
}
