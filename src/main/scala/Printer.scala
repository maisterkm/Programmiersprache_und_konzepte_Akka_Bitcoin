/**
  * @author <Maister Oleksandr>
  * Matrikelnummer: a1277671
  */

import akka.actor.{Actor, ActorLogging, Props}

object Printer {
  def props: Props = Props[Printer]
  final case class Print(message: String)
  case class PrintCurrency(currency: BigDecimal)
}

class Printer extends Actor with ActorLogging {
  import Printer._

  def receive = {
    //case Print(message) => printl(s"$message")
    case Print(message) => println(s"$message")

    //case PrintCurrency(currency) => log.info(s"$currency")
    case PrintCurrency(currency) => println(s"$currency")
  }

}




