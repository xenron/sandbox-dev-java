package util

import scala.xml._

object Sample1 extends App {

  val input = XML.loadFile("conf/testdata.xml")
  
  val amounts = input \\ "AMT"
}