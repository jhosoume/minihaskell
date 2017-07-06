import com.mhs.ast._
import com.mhs.visitors.TransformITE
import org.scalatest.{FlatSpec, Matchers}

class ITEExpressionTest extends FlatSpec with Matchers {

  "if x==2 then true else false" should "return x==2" in {
    val let = new LetExpression("x", IntValue(2), new Reference("x"))
    val ite = new ITEExpression(new EqualsExpression(let, IntValue(2)),BooleanValue(true), BooleanValue(false))
  ite.evaluate().asInstanceOf[BooleanValue].value should be (true)
  }

  "test of TransformITE" should "just Condition" in {
    val trans : TransformITE = new TransformITE
    val ite = new ITEExpression(new EqualsExpression(IntValue(2), IntValue(2)),BooleanValue(true), BooleanValue(false))
    assert(ite.accept(trans).isInstanceOf[EqualsExpression])
  }
}