package com.adiacov.srp.correct

trait Repository[T] {
  def save(value: T): Unit
}
