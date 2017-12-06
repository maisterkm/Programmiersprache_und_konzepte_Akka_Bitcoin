/**
  * @author <Maister Oleksandr>
  * Matrikelnummer: a1277671
  */

import akka.actor.{Actor, ActorLogging, ActorRef, Props}

object EuroConverter {
  def props(printerActor: ActorRef): Props = Props(new EuroConverter(printerActor))
  case class euro2bitcoin(euro: BigDecimal)
  case class euro2dollar(euro: BigDecimal)
}

class EuroConverter(printerActor: ActorRef) extends Actor with ActorLogging {
  import EuroConverter._
  import Printer._

  var bitcoin: BigDecimal = 0.00
  var dollar: BigDecimal = 0.00

  def receive = {
    case euro2bitcoin(euro: BigDecimal) => bitcoin = euro / 5551
      printerActor ! PrintCurrency(bitcoin)
    case euro2dollar(euro: BigDecimal) => dollar = euro * 1.18
      printerActor ! PrintCurrency(dollar)
  }

}


