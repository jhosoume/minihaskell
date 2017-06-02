package com.mhs.ast

class SumExpression(lhs : Expression, rhs : Expression) extends BinaryExpression(lhs, rhs) {
  /* Shoudl verify type */
  override def evaluate() : Value = {
    /**
      * Cast to a type that has a closed sum implemented
      */
    val v1 = lhs.evaluate().asInstanceOf[IntValue]
    val v2 = rhs.evaluate().asInstanceOf[IntValue]
      
    return new IntValue(v1.value + v2.value);
  }
}