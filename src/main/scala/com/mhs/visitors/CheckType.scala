package com.mhs.visitors

import com.mhs.ast._
import com.mhs.memory.{ExpressionEnv, FuncEnv}

class CheckType extends MHSVisitor[Type]{
  def visit(e: IntValue)          = IntT
  def visit(e: BooleanValue)      = BooleanT
  def visit(e: SumExpression)     = {
    val t1 = e.lhs.accept(this)
    val t2 = e.rhs.accept(this)

    if(t1.equals(IntT) && t2.equals(IntT)) IntT else ErrorT
  }
  def visit(e: SubExpression)     = {
    val t1 = e.lhs.accept(this)
    val t2 = e.rhs.accept(this)

    if(t1.equals(IntT) && t2.equals(IntT)) IntT else ErrorT
  }
  def visit(e: MultExpression)    = {
    val t1 = e.lhs.accept(this)
    val t2 = e.rhs.accept(this)

    if(t1.equals(IntT) && t2.equals(IntT)) IntT else ErrorT
  }
  def visit(e: ITEExpression)     = {
    if (e.condition.accept(this) == BooleanT && e.thenClause.accept(this) == e.elseClause.accept(this))
      e.thenClause.accept(this)
    else
      ErrorT
  }

  def visit(e: EqualsExpression)  = {
    val t1 = e.is.accept(this)
    val t2 = e.should.accept(this)

    if(t1.equals(BooleanT) && t2.equals(BooleanT)) BooleanT else ErrorT
  }
  def visit(e: Application)       = {
    var correct: Boolean = true
    val function = FuncEnv.search(e.name)
    for (indx <- 0 until function.args.size) {
      correct = function.args(indx)._2 == e.args(indx).accept(this)
    }
    if (correct) function.body.accept(this) else ErrorT
  }
  def visit(e: LambdaApplication) = FunctionT

  def visit(e: LetExpression)     = {
    if (e.namedExp.accept(this).equals(ErrorT))
      ErrorT
    else e.body.accept(this)
  }
  def visit(e: LambdaExpression)  = FunctionT

  def visit(e: Reference)         = {
    val exp = ExpressionEnv.search(e.id)
    if(exp!= null)
      exp.accept(this)
    else
      ErrorT
  }

}
