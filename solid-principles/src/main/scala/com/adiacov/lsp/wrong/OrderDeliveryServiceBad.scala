package com.adiacov.lsp.wrong

import com.adiacov.model.Order

trait DeliveryBad {
  def deliver(order: Order): Unit = {
    // if order items more than 5 - deliver items to customer by car for example
  }
}

class SelfPickUp extends DeliveryBad {
  override def deliver(order: Order): Unit = {
    // if order items less than 10 - customer self pickup
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
// In example below, SelfPickUp.deliver method introduces a more restrictive condition than in super type
// In that case a component which uses a super type will fail to behave the same,
// if sub type will be used instead
case class OrderDeliveryService2(deliveryMode: SelfPickUp) {
  def deliver(order: Order): Unit = {
    deliveryMode.deliver(order) // throws NotImplementedError
  }
}
