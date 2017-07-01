package com.mhs.ast

import com.mhs.memory.ExpressionEnv
import com.mhs.visitors.MHSVisitor

/**
  * Lambda (\x -> x + 1)
  * LambdaExpression("x", IntValue, SumExpression(Reference("X"), IntValue(1)), Int )
  * class LambdaExpression (val arg: String, val argType: Type, val body: FunctionValue, val bodyType: Type) extends Expression
  */

class LambdaExpression (val arg: String, val body: Expression) extends Expression{

  override def evaluate : Value = body.evaluate()

  override def verifyType(): Type = FunctionT

  override def accept[T](visitor: MHSVisitor[T]) : T = visitor.visit(this)

}
