package com.mhs.ast

import com.mhs.visitors.MHSVisitor

class Type

case object IntT extends Type
case object BooleanT extends Type
//case class FunctionT(val ty1: Type, val ty2: Type) extends Type
case object FunctionT extends Type
case object ErrorT extends Type

trait Expression {
  def evaluate() : Value
  def verifyType() : Type
  def accept[T](visitor : MHSVisitor[T]) : T

}