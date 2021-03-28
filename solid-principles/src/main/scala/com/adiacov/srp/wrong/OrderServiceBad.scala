package com.adiacov.srp.wrong

import com.adiacov.model.Order

// SRP violated
// OrderServiceBad does multiple operations not related to each other

class OrderServiceBad {

  def createOrder(): Unit = {
    // create new Order logic
  }

  def save(order: Order): Unit = {
    // DB logic
    // create session, persist...
  }

  def sendMail(order: Order): Unit = {
    // create mail logic
    // create mail body, send...
  }

}
