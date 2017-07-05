package com.mhs.ast

import com.mhs.memory.ExpressionEnv
import com.mhs.visitors.MHSVisitor

/**
  * Class represents a Let expression
  * Allows declarations like let x = 10 in x + 1
  * Which would lead to value 11
  */

class LetExpression(val id: String, val namedExp: Expression, val body: Expression) extends Expression {

  override def evaluate: Value = {
    ExpressionEnv.associate(id, namedExp)
    body.evaluate()
  }

  override def verifyType(): Type =
    if(namedExp.verifyType().equals(ErrorT))
      ErrorT
    else body.verifyType()

  override def accept[T](visitor: MHSVisitor[T]) : T = visitor.visit(this)

}