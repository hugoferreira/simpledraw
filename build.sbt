name := "simpledraw"

organization := "pt.up.fe"

version := "0.1"

libraryDependencies ++= Seq(
	"junit" % "junit" % "4.12" % "test"
)

mainClass in (Compile, run) := Some("Main")

