package com.mhs.parser

import com.mhs.ast.{IntValue, MultExpression, SubExpression, SumExpression}

object ExpressionParser {
  "4*3+2*5"

  def eval(exp: String): Int = {
    //finds procedence
    var i = exp.length-1
    var parentCount = 0
    var opLoc = -1 //operator Locator

    while(i>0){
      if(exp(i)==')') parentCount += 1
      else if(exp(i) == '(') parentCount -= 1
      else if(parentCount == 0 && exp(i) == '+' || exp(i) == '-' ){
        opLoc = i
        i = -1
      }else if(parentCount==0 && opLoc<0 && (exp(i)=='*')){
        opLoc = i
      }
      i -= 1
    }
    //deal with it
    if(opLoc<0) {
      if(exp.trim()(0) == '('){
        eval(exp.trim.substring(1,exp.length-1))
      }else{
        exp.toInt
      }
    }else{
      exp(opLoc) match{
        case '+' =>new SumExpression(IntValue(eval(exp.substring(0,opLoc))),
                    IntValue(eval(exp.substring(opLoc+1)))).evaluate().asInstanceOf[IntValue].value
        case '-' =>new SubExpression(IntValue(eval(exp.substring(0,opLoc))),
                    IntValue(eval(exp.substring(opLoc+1)))).evaluate().asInstanceOf[IntValue].value
        case '*' =>new MultExpression(IntValue(eval(exp.substring(0,opLoc))),
                    IntValue(eval(exp.substring(opLoc+1)))).evaluate().asInstanceOf[IntValue].value
      }
    }
  }
  //quick test
  def main(args:Array[String]): Unit ={
    println(eval("4*3+2*5"))
  }
}
