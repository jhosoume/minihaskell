package com.mhs.ast
import com.mhs.memory.Env

class LetExpression(id: String, namedExp: Expression, body: Expression) extends Expression {
  override def evaluate: Value = {
    Env.associate(id, namedExp)
    return body.evaluate()
  }

}