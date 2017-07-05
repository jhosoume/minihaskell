import com.mhs.ast._
import com.mhs.visitors.Metrics
import org.scalatest.{FlatSpec, Matchers}

class MetricsTest extends FlatSpec with Matchers{
  "the total expressions 3 + (4 + 5)" should "return value 5" in {
    val sum1 = new SumExpression(new IntValue(4), new IntValue(5))
    val sum2 = new SumExpression(new IntValue(3), sum1)

    val m : Metrics = new Metrics()
    sum2.accept(m) should be (5)
  }

  "the total expressions " should "return" in {
    val lamb = new LambdaExpression(("x", IntT), IntT, new SumExpression(new Reference("x"), IntValue(1)))

    val m : Metrics = new Metrics()
    lamb.accept(m) should be (4)
  }

}
