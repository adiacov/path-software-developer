package com.adiacov.srp.correct

trait Repo[T] {
  def save(value: T): Unit
}
