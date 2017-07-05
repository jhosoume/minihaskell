package com.mhs.memory

import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet
import com.mhs.ast.{Expression, FuncDec}

import scala.collection.mutable

/**
  * Env to associate identifiers and expressions.
  */
class Env[T] {
  private val context: HashMap[String, T] = new HashMap()

  def associate(id: String, exp: T): Unit = {
    context += id -> exp
  }

  def search(id: String): T = {
    context(id)
  }
}

object ExpressionEnv extends Env[Expression]
object FuncEnv extends Env[FuncDec]
