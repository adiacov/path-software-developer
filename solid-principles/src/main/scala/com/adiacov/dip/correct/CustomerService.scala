package com.adiacov.dip.correct

trait Contactable {
  def makeContact(): Unit
}

class MailService extends Contactable {
  override def makeContact(): Unit = {
    // send mail
  }
}

class PhoneService extends Contactable {
  override def makeContact(): Unit = {
    // make a call
  }
}

class CustomerService(contactable: Contactable) {
  def contactCustomer: Unit = {
    contactable.makeContact()
  }
}

// DIP
// CustomerService is high level - it has Contactable component
// MailService and PhoneService - implements Contactable
// CustomerService no more depends on low level components
