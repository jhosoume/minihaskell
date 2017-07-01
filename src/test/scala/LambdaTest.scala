import com.mhs.ast._
import com.mhs.visitors.TransformLet
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by luisa on 01/07/2017.
  */
class LambdaTest extends FlatSpec with Matchers {

  "lambda expression (x->1+1)" should "return 2" in {
    val lambda = new LambdaExpression("x", new SumExpression(IntValue(1), IntValue(1)))

    lambda.evaluate().asInstanceOf[IntValue].value should be (2)
  }
  "let x=2 in (x->x+x)" should "return 4" in {
    val lambda = new LambdaExpression("x", new SumExpression(new Reference("x"), new Reference("x")))
    val let = new LetExpression("x", IntValue(2),lambda)

    let.evaluate().asInstanceOf[IntValue].value should be (4)
  }

  "Lambda Application (x->x+x)2" should "return 4" in {
    val lambda = new LambdaExpression("x", new SumExpression(new Reference("x"),new Reference("x")))
    val lamApp = new LambdaApplication(lambda, IntValue(2))

    lamApp.evaluate().asInstanceOf[IntValue].value should be (4)
  }

  "test TransformLet of let x=2 in x+x" should "(x->x+x)2" in {
    val trans : TransformLet = new TransformLet
    val let = new LetExpression("x", IntValue(2), new SumExpression(new Reference("x"),new Reference("x")))
    assert(let.accept(trans).isInstanceOf[LambdaApplication])
  }
}
