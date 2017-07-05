package com.mhs.ast

import com.mhs.memory.{ExpressionEnv, FuncEnv}

class Application(name: String, args: Expression*) extends Expression {
  override def evaluate(): Value = {
    val function = FuncEnv.search(name)
    for (indx <- 0 until function.args.size) {
      ExpressionEnv.associate(function.args(indx), args(indx))
    }
    function.body.evaluate()
  }

}
