package com.adiacov.lsp.wrong

import com.adiacov.model.Order

trait DeliveryBad {
  def deliver(order: Order): Unit

  def scheduleDelivery(): Unit
}

class CarDelivery() extends DeliveryBad {
  override def deliver(order: Order): Unit = {
    println("delivering by Car")
  }

  override def scheduleDelivery(): Unit = {
    println("Next delivery at ...")
  }
}

class SelfPickUp extends DeliveryBad {
  override def deliver(order: Order): Unit = {
    throw new NotImplementedError("SelfPickUp doesn't support delivery")
  }

  override def scheduleDelivery(): Unit = {
    println("Will pick up at ...")
  }
}

case class OrderDeliveryService1(deliveryMode: DeliveryBad) {

  def deliver(order: Order): Unit = {
    deliveryMode.deliver(order)
  }
}

// OrderDeliveryService breaks the Liskov Substitution Principle,
// if SelfPickUp subtype to be used instead of Delivery super type,
// Clients relies on Delivery functionality which is not totally fulfilled by subtype
case class OrderDeliveryService2(deliveryMode: SelfPickUp) {
  def deliver(order: Order): Unit = {
    deliveryMode.deliver(order) // throws NotImplementedError
  }
}
