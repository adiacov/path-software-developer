package com.adiacov.lsp.correct

import com.adiacov.model.Order


trait Delivery {
  def scheduleDelivery(): Unit
}

trait TransportableDelivery extends Delivery {
  def deliver(order: Order): Unit
}

class CarDelivery() extends TransportableDelivery {
  override def deliver(order: Order): Unit = {
    println("delivering by Car")
  }

  override def scheduleDelivery(): Unit = {
    println("Next delivery at ...")
  }
}

class SelfPickUp extends Delivery {
  override def scheduleDelivery(): Unit = {
    println("Will pick up at ...")
  }
}

case class OrderDeliveryServiceGood1(deliveryMode: TransportableDelivery) {
  def deliver(order: Order): Unit = {
    deliveryMode.deliver(order)
  }
}

// Now a subtype can substitute it's supertype by keeping same behaviour
case class OrderDeliveryServiceGood2(deliveryMode: CarDelivery) {
  def deliver(order: Order): Unit = {
    deliveryMode.deliver(order)
  }
}

