package com.adiacov.dip.wrong

class MailService1 {
  def sendMail(): Unit = ???
}

class PhoneService1 {
  def call(): Unit = ???
}

case class CustomerService1(mailService: MailService1) {
  def contactCustomer(): Unit = {
    mailService.sendMail()
  }
}

// New requirement: contact customer by phone
case class CustomerService2(mailService: MailService1,
                            phoneService: PhoneService1) {
  val customerPrefersPhone: Boolean = true // some logic not shown here
  if (customerPrefersPhone) {
    phoneService.call()
  } else {
    mailService.sendMail()
  }
}

// CustomerService is a high level component
// It depends first on MailService, which is low level component
// When a new requirement was created, a new phoneService was added as a dependency

// DIP is violated by CustomerService depend on low level components
// Also, to accomplish the task, new code need to be added to CustomerService
