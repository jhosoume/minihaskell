<<<<<<< HEAD
import org.scalatest.{FlatSpec, Matchers, Assertions}
import com.mhs.ast.{Application, FuncDec, IntValue, Reference, SumExpression}
import com.mhs.memory.FuncEnv
/**
  */
class ApplicationTest extends FlatSpec with Matchers {
  "a application inc 4 (where inc x = x + 1)" should "take to value 5" in {
    val inc = new FuncDec("inc", List("x"), new SumExpression(new Reference("x"), new IntValue(1)))
=======
import org.scalatest.{Assertions, FlatSpec, Matchers}
import com.mhs.ast._
import com.mhs.memory.FuncEnv

class ApplicationTest extends FlatSpec with Matchers {

  "a application inc 4 (where inc x = x + 1)" should "take to value 5" in {
    /**
      * >> def inc(x: IntT): IntT = x + 1
      * >> inc 4
      * >> 5
      */
    val inc = new FuncDec("inc", List(("x",IntT)), IntT, new SumExpression(new Reference("x"), new IntValue(1)))
>>>>>>> lambda_variation
    val app = new Application("inc", new IntValue(4))

    FuncEnv.associate("inc", inc)

    app.evaluate().asInstanceOf[IntValue].value should be (5)
  }

  "application inc x (where x = 4) summed with its own return value ((inc x) + x)" should "return 9" in {
    val refX = new Reference("x")
<<<<<<< HEAD
    val inc = new FuncDec("inc", List("x"), new SumExpression(refX, new IntValue(1)))
=======
    val inc = new FuncDec("inc", List(("x",IntT)), IntT, new SumExpression(refX, new IntValue(1)))
>>>>>>> lambda_variation
    val app = new Application("inc", new IntValue(4))
    FuncEnv.associate("inc", inc)
    val sum = new SumExpression(app, refX)

    sum.evaluate().asInstanceOf[IntValue].value should be (9)
  }

<<<<<<< HEAD
  "application dumbSum 5 (where dumbSum x = x + y)" should "raise error" in {
    val dumbSum = new FuncDec("dumbSum", List("x"), new SumExpression(new Reference("x"), new Reference("y")))
=======
  //TODO: dinamic scope
  "supondo (def f y = x + y), e avaliamos let x = 10 in f 5 " should " levar ao 15" in {
    val refX = new Reference("x")
    val f    = new FuncDec("f", List(("y", IntT)), IntT, new SumExpression(refX, new Reference("y")))
    val let  = new LetExpression("x", new IntValue(10), new Application("f", new IntValue(5)))

    FuncEnv.associate("f", f)

    let.evaluate().asInstanceOf[IntValue].value should be (15)
  }

  "application dumbSum 5 (where dumbSum x = x + y)" should "raise error" in {
    val dumbSum = new FuncDec("dumbSum", List(("x", IntT)), IntT, new SumExpression(new Reference("x"), new Reference("y")))
>>>>>>> lambda_variation
    val appOne = new Application("dumbSum", new IntValue(5))

    FuncEnv.associate("dumbSum", dumbSum)

    //appOne.evaluate().asInstanceOf[IntValue].value shouldNot compile

<<<<<<< HEAD
    val inc = new FuncDec("inc", List("y"), new SumExpression(new Reference("y"), new IntValue(1)))
=======
    val inc = new FuncDec("inc", List(("y", IntT)), IntT, new SumExpression(new Reference("y"), new IntValue(1)))
>>>>>>> lambda_variation
    val appTwo = new Application("inc", new IntValue(4))

    FuncEnv.associate("inc", inc)

    appOne.evaluate().asInstanceOf[IntValue].value shouldNot be (9)

  }

  "application inc double inc 4 (where double x = x + x)" should "return value 11" in {
    val refX = new Reference("x")
<<<<<<< HEAD
    val inc = new FuncDec("inc", List("x"), new SumExpression(refX, new IntValue(1)))
=======
    val inc = new FuncDec("inc", List(("x", IntT)), IntT, new SumExpression(refX, new IntValue(1)))
>>>>>>> lambda_variation
    FuncEnv.associate("inc", inc)
    val appIncOne = new Application("inc", new IntValue(4))
    appIncOne.evaluate().asInstanceOf[IntValue].value should be (5)

<<<<<<< HEAD
    val mult = new FuncDec("mult", List("x"), new SumExpression(refX, refX))
    FuncEnv.associate("mult", mult)
    val appMult = new Application("mult", appIncOne)
    appMult.evaluate().asInstanceOf[IntValue].value should be (10)

    val appIncTwo = new Application("inc", appMult)
=======
    val mult = new FuncDec("mult", List(("x", IntT)), IntT, new SumExpression(refX, refX))
    FuncEnv.associate("mult", mult)
    val appMult = new Application("mult", appIncOne.evaluate())
    appMult.evaluate().asInstanceOf[IntValue].value should be (10)

    val appIncTwo = new Application("inc", appMult.evaluate())
>>>>>>> lambda_variation

    appIncTwo.evaluate().asInstanceOf[IntValue].value should be (11)
  }

<<<<<<< HEAD
=======
  "application sqr x (where x = 10)" should "return 100" in {
    val refX = new Reference("x")
    val sqr = new FuncDec("sqr", List(("x", IntT)), IntT, new LambdaExpression(("x", IntT), IntT, new MultExpression(refX,refX)))
    FuncEnv.associate("sqr", sqr)
    val appSqr = new Application("sqr", IntValue(10))

    appSqr.evaluate().asInstanceOf[IntValue].value should be (100)
  }

>>>>>>> lambda_variation
}
