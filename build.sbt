ThisBuild / version := "0.1.0-SNAPSHOT"
Compile / compileOrder := CompileOrder.JavaThenScala
lazy val root = (project in file("."))
  .settings(
    name := "java-sbt-example",
    libraryDependencies ++= Seq(
        "net.aichler" % "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test,
        "io.cucumber" % "cucumber-java" % "6.1.1" % Test,
        "io.cucumber" %% "cucumber-scala" % "6.10.4" % Test,
    )
)
