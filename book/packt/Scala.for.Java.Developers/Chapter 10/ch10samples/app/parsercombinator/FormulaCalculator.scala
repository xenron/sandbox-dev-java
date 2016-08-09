package parsercombinator

import scala.util.parsing.combinator._
import java.text.SimpleDateFormat
import java.util.Date

object FormulaCalculator {
  
  abstract class Node
  
  case class Transaction(amount: Int)
  case class Account(name:String) extends Node {
    var transactions: Iterable[Transaction] = List.empty
  }
  
  def addNewTransaction(startingBalance: Int, t: Transaction) = startingBalance + t.amount
  def balance(account: Account) = account.transactions.foldLeft(0)(addNewTransaction)

  case class NumberOfPeriods (value: Int) extends Node {
    override def toString = value.toString
  }
  case class RelativePeriod (value:String) extends Node {
    override def toString = value
  }
  case class Variable(name : String) extends Node
  case class Number(value : Double) extends Node
  case class UnaryOp(operator : String, arg : Node) extends Node
  case class BinaryOp(operator : String, left : Node, right : Node) extends Node
  case class Function(name:String,arguments:List[Node]) extends Node {
    override def toString =
      name+arguments.mkString("(",",",")")
  }

  def evaluate(e : Node) : Double = {
    e match {
      case Number(x) => x
      case UnaryOp("-", x) => -(evaluate(x))
      case BinaryOp("+", x1, x2) => (evaluate(x1) + evaluate(x2))
      case BinaryOp("-", x1, x2) => (evaluate(x1) - evaluate(x2))
      case BinaryOp("*", x1, x2) => (evaluate(x1) * evaluate(x2))
      case BinaryOp("/", x1, x2) => (evaluate(x1) / evaluate(x2))
      case a: Account => balance(a)
    }
  }

  object FormulaParser extends JavaTokenParsers {        
    
    val identifier: Parser[String] = ident
    val relative_period: Parser[RelativePeriod] = """([N|P|\+|\-][0-9]+|CURRENT)""".r ^^ RelativePeriod
    val number_of_periods: Parser[NumberOfPeriods] = """\d+""".r ^^ (i => NumberOfPeriods(i.toInt))
    val account_name: Parser[String] = """[A-Za-z0-9_]+""".r
    
    def account: Parser[Account] = "#" ~> account_name <~ "#" ^^ { Account(_) }
    
    def function: Parser[Function] =
      identifier~"("~account~","~relative_period~","~number_of_periods~")" ^^ {
        case f~"("~acc~","~rp~","~nbp~")" => Function(f,List(acc,rp,nbp))
      } |
      identifier~"("~account~","~relative_period~")" ^^ {
        case f~"("~acc~","~rp~")" => Function(f,List(acc,rp))
      }

      def node: Parser[Node] =
        (term ~ "+" ~ term) ^^ { case lhs~plus~rhs => BinaryOp("+", lhs, rhs) } |
        (term ~ "-" ~ term) ^^ { case lhs~minus~rhs => BinaryOp("-", lhs, rhs) } |
        term

      def term: Parser[Node] =
        (factor ~ "*" ~ factor) ^^ { case lhs~times~rhs => BinaryOp("*", lhs, rhs) } |
        (factor ~ "/" ~ factor) ^^ { case lhs~div~rhs => BinaryOp("/", lhs, rhs) } |
        (factor ~ "^" ~ factor) ^^ { case lhs~exp~rhs => BinaryOp("^", lhs, rhs) } |
        factor

      def factor : Parser[Node] =
        "(" ~> node <~ ")" |
        floatingPointNumber ^^ {x => Number(x.toFloat) } |
        account |
        function

      def parse(text : String) =
            parseAll(node, text)        
    }

    // Parses 3 formula that make computations on accounts
    def main(args: Array[String]) {
        
        val formulaList = List("3*#ACCOUNT1#","#ACCOUNT1#- #ACCOUNT2#","AVERAGE_UNDER_PERIOD(#ACCOUNT4#,+1,12)")
        
        formulaList.foreach { formula =>
            val unspacedFormula = formula.replaceAll("[ ]+","")
            println(s"Parsing of $formula gives result:\n ${FormulaParser.parse(unspacedFormula)}")
        }
    }

}