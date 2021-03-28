package com.adiacov.ocp.wrong

case class OrderReport1(customer: String, total: Double) {

  def createReport(): String = {
    "Create report from details: customer, total"
  }
}

// a new requirement to print the customer email in the report
// The open-closed principle violated
// - a new 'email' field was added to constructor
// - the 'printOrder' method changed to use the 'email' field
case class OrderReport2(customer: String, email: String, total: Double) {
  def createOrder(): String = {
    "Create report from details: customer, total, email"
  }
}
