package com.adiacov.srp.wrong

import com.adiacov.model.Order

class OrderServiceBad {

  def createOrder(): Unit = {
    // create new Order
  }

  def save(order: Order): Unit = {
    // open DB session
    // persist Order
    // close DB session
  }

  def sendMail(order: Order): Unit = {
    // create mail header, body
    // send mail
  }

}
