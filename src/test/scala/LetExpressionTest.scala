import com.mhs.ast._
import org.scalatest.{FlatSpec, Matchers}

class LetExpressionTest extends FlatSpec with Matchers {
  "a let expression x = 3 in x + 1" should "return value 4" in {
    val let = new LetExpression("x", new IntValue(3),
        new SumExpression(new Reference("x"), new IntValue(1)))
    let.evaluate().asInstanceOf[IntValue].value should be (4)
  }

  "a let expression x = 3 in y = 5 in x + y" should "return a value 8" in {
    val value3 = new IntValue(3)
    val value5 = new IntValue(5)
    val refY = new Reference("y")
    val refX = new Reference("x")

    val letOne = new LetExpression("y", value5, new SumExpression(refX, refY))
    val letSec = new LetExpression("x", value3, letOne)

    letSec.evaluate().asInstanceOf[IntValue].value should be (8)
  }

  "a let expression x = 3 in (let x = 5 in x + 1) + x" should "return a value 9" in {
    val value1 = new IntValue(1)
    val value3 = new IntValue(3)
    val value5 = new IntValue(5)
    val refY = new Reference("y")
    val refX = new Reference("x")

    val letOne = new LetExpression("x", value5, new SumExpression(refX, value1))
    val letSec = new LetExpression("x", value3, new SumExpression(letOne, refX))
  }

  "let y = 5 in (x->y+y)2" should "10" in {
    val let = new LetExpression("y", IntValue(5), new LambdaExpression(("y", IntT), IntT, new SumExpression(new Reference("y"),new Reference("y"))))

    let.evaluate().asInstanceOf[IntValue].value should be (10)
  }

  "let x=2 in x" should "return 2" in {
    val let = new LetExpression("x", IntValue(2), new Reference("x"))
    println(let.evaluate())
    let.evaluate().asInstanceOf[IntValue].value should be (2)
  }

}
