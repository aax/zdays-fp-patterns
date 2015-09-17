name := "ZDays Functional Patterns"

version := "1.0"

resolvers += "rillit-repository" at "http://akisaarinen.github.com/rillit/maven"

libraryDependencies ++= Seq(
  "fi.akisaarinen" % "rillit_2.10" % "0.1.0"
)

initialCommands += """
  import rillit.Lenser
 """
