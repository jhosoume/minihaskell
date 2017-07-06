package com.mhs.ast

import com.mhs.visitors.MHSVisitor

class SubExpression(lhs : Expression,rhs : Expression) extends BinaryExpression(lhs, rhs) {
  override def evaluate() : Value = {
    val v1 = lhs.evaluate().asInstanceOf[IntValue]
    val v2 = rhs.evaluate().asInstanceOf[IntValue]

    IntValue(v1.value - v2.value)
  }

  override def verifyType(): Type = {
    val t1 = lhs.verifyType()
    val t2 = rhs.verifyType()

    if(t1.equals(IntT) && t2.equals(IntT)) IntT else ErrorT
  }

  override def accept[T](visitor : MHSVisitor[T]) : T = visitor.visit(this)

}
