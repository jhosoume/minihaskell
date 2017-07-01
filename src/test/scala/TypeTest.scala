import com.mhs.ast
import com.mhs.ast._
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by luisa on 01/07/2017.
  */
class TypeTest extends FlatSpec with Matchers {

  "lambda expression type" should "FunctionT" in {
    val lam = new LambdaExpression("x", new SumExpression(IntValue(1), IntValue(1)))

    lam.verifyType() should be (FunctionT)

  }
}
