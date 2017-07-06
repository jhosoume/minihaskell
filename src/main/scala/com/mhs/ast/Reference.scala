package com.mhs.ast
import com.mhs.memory.ExpressionEnv
<<<<<<< HEAD

class Reference(val id: String) extends Expression{
  override def evaluate: Value = ExpressionEnv.search(id).evaluate()
=======
import com.mhs.visitors.MHSVisitor

class Reference(val id: String) extends Expression{
  override def evaluate: Value = ExpressionEnv.search(id).evaluate()

  override def verifyType(): Type = {
    val exp = ExpressionEnv.search(id)
    if(exp!= null)
      exp.verifyType()
    else
      ErrorT
  }

  override def accept[T](visitor : MHSVisitor[T]) : T = visitor.visit(this)
>>>>>>> lambda_variation

}
