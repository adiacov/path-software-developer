package com.adiacov.isp.correct

trait OrderReportGood {
  def generateReport(): Unit
}

trait ReportDelivery {
  def send(): Unit
}

class CsvOrderReportGood extends OrderReportGood {
  override def generateReport(): Unit = {
    println("Do some work")
  }
}

class MailOrderReportGood extends OrderReportGood with ReportDelivery {
  override def generateReport(): Unit = {
    println("Do som work")
  }

  override def send(): Unit = {
    println("Sending report by mail...")
  }
}
