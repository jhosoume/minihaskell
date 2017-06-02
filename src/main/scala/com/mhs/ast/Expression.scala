package com.mhs.ast

trait Expression {
  def evaluate() : Value
}