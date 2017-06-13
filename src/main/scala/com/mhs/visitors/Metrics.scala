package com.mhs.visitors

import com.mhs.ast._

class Metrics extends MHSVisitor[Int] {
  def visit(e: IntValue)        = 1
  def visit(e: BooleanValue)    = 1
  def visit(e: SumExpression)   = 1 + e.lhs.accept(this) + e.rhs.accept(this)
  def visit(e: ITEExpression)   = 1 + e.condition.accept(this) + e.thenClause.accept(this) + e.elseClause.accept(this)
  def visit(e: Application)     = 1 + e.args.map(e => e.accept(this)).sum
  def visit(e: LetExpression)   = 1 + e.namedExp.accept(this) + e.body.accept(this)
  def visit(e: Reference)       = 1

}
