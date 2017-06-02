package com.mhs.memory

import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet
import com.mhs.ast.Expression

import scala.collection.mutable

/**
  * Env to associate identifiers and expressions.
  */
object Env {
  private val context: HashMap[String, Expression] = new mutable.HashMap[String, Expression]()

  def associate(id: String, exp: Expression): Unit = {
    context += id -> exp
  }

  def search(id: String, x: Int): Expression = {
    context(id)
  }
}
