package com.mhs.visitors

import com.mhs.ast.{LambdaApplication, LambdaExpression, LetExpression}


class TransformLet extends GTransformation{
  override def visit(e: LetExpression) = {
    val body = e.body.accept(this)

    val lambdaExp = new LambdaExpression(e.id, body)
    new LambdaApplication(lambdaExp, e.namedExp)
  }
}
