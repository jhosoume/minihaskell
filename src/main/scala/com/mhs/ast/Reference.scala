package com.mhs.ast
import com.mhs.memory.Env

class Reference(val id: String) extends Expression{
  override def evaluate: Value = Env.search(id).evaluate()

}
