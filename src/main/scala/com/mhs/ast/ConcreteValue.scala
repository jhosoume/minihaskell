package com.mhs.ast

import com.mhs.visitors.MHSVisitor

abstract class ConcreteValue[T](val value : T) extends Value {
  override def evaluate() : Value = this
}

case class IntValue(v: Int) extends ConcreteValue[Int](v) {
  override def verifyType(): Type = IntT
  override def accept[T](visitor: MHSVisitor[T]) : T = visitor.visit(this)
}

case class BooleanValue(v : Boolean) extends ConcreteValue[Boolean](v) {
  override def verifyType(): Type = BooleanT
  override def accept[T](visitor: MHSVisitor[T]) : T = visitor.visit(this)
}

case class FunctionValue(v :Expression) extends ConcreteValue[Expression](v) {
  override def verifyType(): Type = FunctionT
  override def accept[T](visitor: MHSVisitor[T]) : T = visitor.visit(this)
}