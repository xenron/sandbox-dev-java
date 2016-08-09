package se.wssample

case class Book(title:String, quantity:String)
case class Library(book:List[Book])

object patternMatching {

  val book1 = Book("Scala for Java Developers","10")
  val book2 = Book("Effective Java","12")
  val books = List(book1,book2)
  def bookAboutScala(book:Book) = book match {
    case Book(a,b) if a contains "Scala" => Some(book)
    case _ => None
  }
  bookAboutScala(book1)
  bookAboutScala(book2)
  books map (b => bookAboutScala(b))
  books map bookAboutScala
  books flatMap bookAboutScala
  val regex = """(.*)(Scala|Java)(.*)""".r
  def whatIs(that:Any) = that match {
    case Book(t,_) if (t contains "Scala") =>
      s"${t} is a book about Scala"
    case Book(_,_) => s"$that is a book "
    case regex(_,word,_) => s"$that is something about ${word}"
    case head::tail => s"$that is a list of books"
    case _ => "You tell me !"
  }
  whatIs(book1)
  whatIs(book2)
  whatIs(books)
  whatIs("Scala pattern matching")
  whatIs("Love")
}