package com.adiacov.isp.correct

import com.adiacov.isp.correct.report.Worker

trait OrderReportGood {
  def generateReport(): String
}

trait ReportDelivery {
  def send(): Unit
}

class CsvOrderReportGood extends OrderReportGood {
  override def generateReport(): String = {
    "Do some work"
  }
}

class MailOrderReportGood extends OrderReportGood with ReportDelivery {
  override def generateReport(): String = {
    "Do som work"
  }

  override def send(): Unit = {
    println("Sending report by mail...")
  }
}

package object report {
  type Worker = OrderReportGood with ReportDelivery
}

// Usage
case class ReportService(worker: Worker) {
  def doSomething(): Unit = {
    worker.generateReport()
    worker.send()
  }
}
