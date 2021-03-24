package com.adiacov.ocp.wrong

case class OrderReport1(customer: String,
                        total: Double) {

  def printOrder(): Unit = {
    println(s"$customer bought items for $total dollars")
  }
}

case class OrderReport2(customer: String,
                        email: String,
                        total: Double) {
  // a new requirement to print the customer email in the report
  // The open-closed principle violated
  // - a new 'email' field was added to constructor
  // - the 'printOrder' method changed to use the 'email' field

  def printOrder(): Unit = {
    println(s"$customer (email: $email) bought items for $total dollars")
  }
}
