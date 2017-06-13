package com.mhs.visitors

import com.mhs.ast.{BooleanValue, ITEExpression}

class TransformITE extends GTransformation {
  override def visit(e: ITEExpression) = {
    val condition = e.condition.accept(this)
    val tuple = (e.thenClause, e.elseClause)
    tuple match {
      case (BooleanValue(true), BooleanValue(false)) => condition
      case _ => new ITEExpression(condition, e.thenClause.accept(this), e.elseClause.accept(this))
    }
  }

}
