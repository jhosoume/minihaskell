package com.mhs.ast

/**          >> def inc(x: IntT):IntT = x + 1*/
class FuncDec(val name: String, val args: List[(String, Type)], val funcType: Type, val body: Expression)
