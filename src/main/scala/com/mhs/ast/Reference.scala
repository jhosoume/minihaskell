package com.mhs.ast
import com.mhs.memory.ExpressionEnv

class Reference(val id: String) extends Expression{
  override def evaluate: Value = ExpressionEnv.search(id).evaluate()

}
