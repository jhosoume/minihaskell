import com.mhs.ast
import com.mhs.ast._
import com.mhs.memory.FuncEnv
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by luisa on 01/07/2017.
  */
class TypeTest extends FlatSpec with Matchers {

  "lambda expression type" should "FunctionT" in {
    val lam = new LambdaExpression("x", new SumExpression(IntValue(1), IntValue(1)))

    lam.verifyType() should be (FunctionT)
  }

  "lambda application type" should "IntT" in {
    val refX = new Reference("x")
    val lam = new LambdaExpression("x", new SumExpression(refX, IntValue(1)))

    val lambApp = new LambdaApplication(lam, IntValue(4))

    lambApp.verifyType() should be (FunctionT)
  }

  "ITEExpression type" should "BooleanT" in {
    val let = new LetExpression("x", IntValue(2), new Reference("x"))
    val ite = new ITEExpression(new EqualsExpression(let, IntValue(2)), BooleanValue(true), BooleanValue(false))

    println(let.verifyType())

    ite.evaluate().verifyType() should be (BooleanT)
  }

  "application inc x (where x = 4) summed with its own return value ((inc x) + x)" should "return 9" in {
    val refX = new Reference("x")
    val inc = new FuncDec("inc", IntT, List(("x", IntT)), new SumExpression(refX, new IntValue(1)))
    val app = new Application("inc", new IntValue(4))
    FuncEnv.associate("inc", inc)
    val sum = new SumExpression(app, refX)

  }
}