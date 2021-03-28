package com.adiacov.isp.wrong

import com.adiacov.model.Order

trait OrderReportBad {
  def generateReport(order: Order): String

  def send(): Unit
}

// Interface Segregation Principle violated
// This class need to implement or VOID the 'sendReport' method
// This class doesn't need the 'sendReport' method but it forced by interface
class CsvOrderReportBad extends OrderReportBad {
  override def generateReport(order: Order): String = ???

  override def send(): Unit =
    throw new UnsupportedOperationException("Send report not supported")
}

class MailOrderReportBad extends OrderReportBad {
  override def generateReport(order: Order): String = ???

  override def send(): Unit = ???
}
