import org.scalatest.{FlatSpec, Matchers}
import com.mhs.ast.{IntValue, SumExpression}

class SumExpressionTest extends FlatSpec with Matchers {
  "Sum between values 3 and 4" should "return 7" in {
    val sum = new SumExpression(new IntValue(3), new IntValue(4))
    sum.evaluate().asInstanceOf[IntValue].value should be (7)
  }

}
