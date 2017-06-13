package com.mhs.ast

import com.mhs.visitors.MHSVisitor

/**
  * Created by luisa on 01/07/2017.
  */
class ITEExpression(val condition: Expression, val thenClause: Expression, val elseClause: Expression) extends Expression{
  override def evaluate(): Value =
    if (condition.evaluate().asInstanceOf[BooleanValue].value)
      thenClause.evaluate()
    else elseClause.evaluate()

  override def verifyType(): Type =
    if (condition.verifyType() == BooleanT && thenClause.verifyType() == elseClause.verifyType())
      thenClause.verifyType()
    else
      ErrorT

  override def accept[T](visitor : MHSVisitor[T]) : T = visitor.visit(this)


}
