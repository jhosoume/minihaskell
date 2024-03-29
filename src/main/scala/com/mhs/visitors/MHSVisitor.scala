package com.mhs.visitors

import com.mhs.ast._

/**
  * Defines a hierarchy of visitor classes
  * Requires a "accept" method for each
  * concreat class
  */
trait MHSVisitor[+T]{
  def visit(e: IntValue)          : T
  def visit(e: BooleanValue)      : T
  def visit(e: SumExpression)     : T
  def visit(e: SubExpression)     : T
  def visit(e: MultExpression)    : T
  def visit(e: ITEExpression)     : T
  def visit(e: Application)       : T
  def visit(e: LetExpression)     : T
  def visit(e: LambdaExpression)  : T
  def visit(e: Reference)         : T
  def visit(e: EqualsExpression)  : T
  def visit(e: LambdaApplication) : T

}
