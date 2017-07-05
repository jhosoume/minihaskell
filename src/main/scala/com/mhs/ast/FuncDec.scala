package com.mhs.ast

class FuncDec(val name: String, val funcType: Type, val args: List[(String, Type)], val body: Expression)
