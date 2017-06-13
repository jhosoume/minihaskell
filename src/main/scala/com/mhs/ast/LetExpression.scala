package com.mhs.ast
import com.mhs.memory.ExpressionEnv

class LetExpression(id: String, namedExp: Expression, body: Expression) extends Expression {
  override def evaluate: Value = {
    ExpressionEnv.associate(id, namedExp)
    return body.evaluate()
  }

}