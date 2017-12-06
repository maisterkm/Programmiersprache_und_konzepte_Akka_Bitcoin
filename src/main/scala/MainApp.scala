/**
  * @author <Maister Oleksandr>
  * Matrikelnummer: a1277671
  */

import akka.actor.{ActorRef, ActorSystem}

object MainApp extends App {
  import EuroConverter._
  import DollarConverter._
  import BitcoinConverter._

  val system: ActorSystem = ActorSystem("mainAkka")

  try {
    val printer: ActorRef = system.actorOf(Printer.props, "printerActor")
    val ec: ActorRef = system.actorOf(EuroConverter.props(printer), "euroConverter")
    val dc: ActorRef = system.actorOf(DollarConverter.props(printer), "dollarConverter")
    val bc: ActorRef = system.actorOf(BitcoinConverter.props(printer), "bitcoinConverter")

    val bitcoin = BigDecimal("1")
    val dollar = BigDecimal("200")
    val euro = BigDecimal("300")

    // Bitcoin > Dollar
    bc ! bitcoin2dollar(bitcoin)
    //Bitcoin > Euro
    bc ! bitcoin2euro(bitcoin)
    // Dollar > Euro
    dc ! dollar2euro(dollar)
    // Dollar > Bitcoin
    dc ! dollar2bitcoin(dollar)
    //Euro > Dollar
    ec ! euro2dollar(euro)
    // Euro > Bitcoin
    ec ! euro2bitcoin(euro)


  } finally {
    system.terminate()
  }

}