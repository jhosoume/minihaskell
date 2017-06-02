import com.mhs.ast.{IntValue, LetExpression, Reference, SumExpression}
import org.scalatest.{FlatSpec, Matchers}[]

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
    val let = new LetExpression("x", value3, letOne)

    let.evaluate.asInstanceOf[IntValue]
  }

}
