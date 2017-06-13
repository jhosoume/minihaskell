package com.mhs.ast

import com.mhs.memory.{ExpressionEnv, FuncEnv}
import com.mhs.visitors.MHSVisitor

class Application(val name: String, val args: Expression*) extends Expression {
  override def evaluate(): Value = {
    val function = FuncEnv.search(name)
    for (indx <- 0 until function.args.size) {
      ExpressionEnv.associate(function.args(indx), args(indx))
    }
    function.body.evaluate()
  }

  override def verifyType() : Type = ErrorT

  override def accept[T](visitor: MHSVisitor[T]): T = visitor.visit(this)

}
