package com.mhs.ast

import com.mhs.visitors.MHSVisitor

class EqualsExpression(val is: Expression, val should: Expression) extends Expression {

  override def evaluate() : Value = {
    val v1 = is.evaluate().asInstanceOf[IntValue]
    val v2 = should.evaluate().asInstanceOf[IntValue]

    BooleanValue(v1.value == v2.value)
  }

  override def verifyType(): Type = {
    val t1 = is.verifyType()
    val t2 = should.verifyType()

    if(t1.equals(BooleanT) && t2.equals(BooleanT)) BooleanT else ErrorT
  }

  override def accept[T](visitor : MHSVisitor[T]) : T = visitor.visit(this)
}
