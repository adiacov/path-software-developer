package com.adiacov.srp.correct

import com.adiacov.model.Order

case class OrderService(repository: Repository[Order],
                        notificationService: NotificationService) {

  def createOrder(): Unit = {
    val order: Order = new Order()
    repository.save(order)
    notificationService.notify()
  }
}
