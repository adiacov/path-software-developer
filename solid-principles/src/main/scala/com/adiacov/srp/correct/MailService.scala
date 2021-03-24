package com.adiacov.srp.correct

trait MailService[T] {

  def sendMail(value: T): Unit

}
