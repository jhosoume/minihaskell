package com.mhs.ast

import com.mhs.memory.{ExpressionEnv, FuncEnv}
<<<<<<< HEAD

class Application(name: String, args: Expression*) extends Expression {
  override def evaluate(): Value = {
    val function = FuncEnv.search(name)
    for (indx <- 0 until function.args.size) {
      ExpressionEnv.associate(function.args(indx), args(indx))
=======
import com.mhs.visitors.MHSVisitor

class Application(val name: String, val args: Expression*) extends Expression {
  override def evaluate(): Value = {
    val function = FuncEnv.search(name)
    for (indx <- 0 until function.args.size) {
      ExpressionEnv.associate(function.args(indx)._1, args(indx))
>>>>>>> lambda_variation
    }
    function.body.evaluate()
  }

<<<<<<< HEAD
=======
  override def verifyType() : Type = FunctionT

  override def accept[T](visitor: MHSVisitor[T]): T = visitor.visit(this)

>>>>>>> lambda_variation
}
