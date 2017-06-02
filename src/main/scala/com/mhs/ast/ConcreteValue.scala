package com.mhs.ast

/**
  * Abstract class was chosen so it cannot be instanciated
  *
  * @param value
  * @tparam T
  */
abstract class ConcreteValue[T](val value : T) extends Value {
  override def evaluate() : Value = this
}

class IntValue(value: Int) extends ConcreteValue[Int](value)

class BooleanValue(value : Boolean) extends ConcreteValue[Boolean](value)