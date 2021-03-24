package com.adiacov.ocp.correct

// maybe not the best example with 'abstract class'
// I've tried to translate this example based on an example written in other programming language
abstract class OrderReport1(customer: String,
                            total: Double) {

  def printOrder: Unit
}

case class OrderReport2(customer: String, total: Double) extends OrderReport1(customer, total) {
  override def printOrder: Unit = {
    println(s"$customer bought items for $total dollars")
  }
}

case class OrderReport3(customer: String,
                        email: String,
                        total: Double) extends OrderReport1(customer, total) {
  override def printOrder: Unit = {
    println(s"$customer (email: $email) bought items for $total dollars")
  }
}
