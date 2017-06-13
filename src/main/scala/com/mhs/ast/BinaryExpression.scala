package com.mhs.ast

/**
  *
  * @param lhs Expression
  * @param rhs Expression
  */
abstract class BinaryExpression(val lhs : Expression, val rhs : Expression) extends Expression
