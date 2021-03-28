package com.adiacov.lsp.correct

import com.adiacov.model.Order


trait Delivery {
  def deliver(order: Order): Unit = {
    // if order items more than 5 - deliver items to customer by car for example
  }
}

class SelfPickUp extends Delivery {
  override def deliver(order: Order): Unit = {
    // if order items more than 3 - deliver items to customer by car for example
  }
}

case class OrderDeliveryServiceGood1(deliveryMode: Delivery) {
  def deliver(order: Order): Unit = {
    deliveryMode.deliver(order)
  }
}

// Now a subtype can substitute it's supertype by keeping same behaviour
case class OrderDeliveryServiceGood2(deliveryMode: SelfPickUp) {
  def deliver(order: Order): Unit = {
    deliveryMode.deliver(order)
  }
}

