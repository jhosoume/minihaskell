import com.mhs.ast._
import com.mhs.visitors.CheckType
import org.scalatest.{FlatSpec, Matchers}

class CheckTest extends FlatSpec with Matchers{

  "a let expression x = 3 in x + 1" should "return value 4" in {
    val let = (new LetExpression("x", new IntValue(3),
      new SumExpression(new Reference("x"), new IntValue(1)))).evaluate()

    val c : CheckType = new CheckType()
    let.accept(c) should be (IntT)
  }

  "lambda expression (x->1+1)" should "return 2" in {
    val lambda = new LambdaExpression(("x", IntT), IntT, new SumExpression(IntValue(1), IntValue(1)))

    val c : CheckType = new CheckType()
    lambda.accept(c) should be (FunctionT)
  }

  "Lambda Application (x->x+x)2" should "return 4" in {
    val lambda = new LambdaExpression(("x", IntT), IntT, new SumExpression(new Reference("x"),new Reference("x")))
    val lamApp = new LambdaApplication(lambda, IntValue(2))

    val ss = new SumExpression(lamApp, IntValue(1))

    val c : CheckType = new CheckType()
    ss.accept(c) should be (ErrorT)
  }
}
