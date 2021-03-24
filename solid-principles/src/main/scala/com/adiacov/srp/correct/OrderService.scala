package com.adiacov.srp.correct

import com.adiacov.model.Order

case class OrderService(orderRepository: Repo[Order],
                        notificationService: MailService[Order]) {

  def createOrder(): Unit = {
    val order: Order = new Order()
    orderRepository.save(order)
    notificationService.sendMail(order)
  }
}
