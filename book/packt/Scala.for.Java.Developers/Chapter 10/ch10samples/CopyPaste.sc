object CopyPaste {
  case class Person(name:String)

  val me = Person("Thomas")                       //> me  : CopyPaste.Person = Person(Thomas)
  val you = Person("Current Reader")              //> you  : CopyPaste.Person = Person(Current Reader)
  
  val we = List(you,me).map(_.name).reduceLeft(_+" & "+_)
                                                  //> we  : String = Current Reader & Thomas
  val status = s"$we have fun with Scala"         //> status  : String = Current Reader & Thomas have fun with Scala
  
}