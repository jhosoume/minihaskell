package com.mhs.ast

import com.mhs.memory.ExpressionEnv
import com.mhs.visitors.MHSVisitor

class LambdaApplication(val lambdaExp: LambdaExpression, val arg: Expression) extends Expression{
  override def evaluate: Value = {
    ExpressionEnv.associate(lambdaExp.arg._1, arg)
    lambdaExp.evaluate()
  }

  override def verifyType(): Type = FunctionT

  override def accept[T](visitor: MHSVisitor[T]) : T = visitor.visit(this)
}
