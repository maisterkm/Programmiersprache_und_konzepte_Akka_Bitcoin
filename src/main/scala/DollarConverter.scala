/**
  * @author <Maister Oleksandr>
  * Matrikelnummer: a1277671
  */

import akka.actor.{Actor, ActorLogging, ActorRef, Props}

object DollarConverter {
  def props(printerActor: ActorRef): Props = Props(new DollarConverter(printerActor))
  case class dollar2euro(dollar: BigDecimal)
  case class dollar2bitcoin(dollar: BigDecimal)
}

class DollarConverter(printerActor: ActorRef) extends Actor with ActorLogging {
  import DollarConverter._
  import Printer._

  var bitcoin: BigDecimal = 0.00
  var euro: BigDecimal = 0.00

  def receive = {
    case dollar2bitcoin(dollar) => bitcoin = dollar / 6500
      printerActor ! PrintCurrency(bitcoin)
    case dollar2euro(dollar) => euro = dollar * 0.85
      printerActor ! PrintCurrency(euro)
  }

}