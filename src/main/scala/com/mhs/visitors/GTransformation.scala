package com.mhs.visitors

import com.mhs.ast._

/**
  * Abstract class with the implementation of MHSVisitor
  * for transformations that preserve the AST. Concrete classes
  * from this abstract class must only redefine methods of interest.
  */
trait GTransformation extends MHSVisitor[Expression] {
  override def visit(bv: BooleanValue)  : Expression = bv
  override def visit(iv: IntValue)      : Expression = iv
  override def visit(e: SumExpression)  : Expression = new SumExpression(e.lhs.accept(this),e.rhs.accept(this))
  override def visit(e: ITEExpression)  : Expression = new ITEExpression(e.condition.accept(this), e.thenClause.accept(this), e.elseClause.accept(this))
  override def visit(e: Application)    : Expression = new Application(e.name, e.args.map(exp => exp.accept(this)): _*)
  override def visit(e: LetExpression)  : Expression = new LetExpression(e.id, e.namedExp.accept(this), e.body.accept(this))
  override def visit(e: Reference)      : Expression = e

}
