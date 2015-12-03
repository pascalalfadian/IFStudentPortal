name := "IFStudentPortal"

version := "1.0"

lazy val IFStudentPortal = (project in file("."))
	.enablePlugins(PlayJava)
	.aggregate(SIAModels)
	.dependsOn(SIAModels)

lazy val SIAModels = project

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
	cache,
	javaWs,
	"org.jsoup" % "jsoup" % "1.8.2"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
EclipseKeys.preTasks := Seq(compile in Compile)

fork in run := false