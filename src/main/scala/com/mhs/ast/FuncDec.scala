package com.mhs.ast

<<<<<<< HEAD
/**
  */
class FuncDec(val name: String, val args: List[String], val body: Expression)
=======
/**          >> def inc(x: IntT):IntT = x + 1*/
class FuncDec(val name: String, val args: List[(String, Type)], val funcType: Type, val body: Expression)
>>>>>>> lambda_variation
