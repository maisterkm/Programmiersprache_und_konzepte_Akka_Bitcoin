/**
  * @author <Maister Oleksandr>
  * Matrikelnummer: a1277671
  */

import akka.actor.{Actor, ActorLogging, ActorRef, Props}

object BitcoinConverter {
  def props(printerActor: ActorRef): Props = Props(new BitcoinConverter(printerActor))
  case class bitcoin2euro(bitcoin: BigDecimal)
  case class bitcoin2dollar(bitcoin: BigDecimal)
}

class BitcoinConverter(printerActor: ActorRef) extends Actor with ActorLogging {
  import BitcoinConverter._
  import Printer._

  var dollar: BigDecimal = 0.00
  var euro: BigDecimal = 0.00

  def receive = {
    case bitcoin2dollar(bitcoin) => dollar = bitcoin * 6500
      printerActor ! PrintCurrency(dollar)
    case bitcoin2euro(bitcoin) => euro = bitcoin * 5551
      printerActor ! PrintCurrency(euro)
  }

}