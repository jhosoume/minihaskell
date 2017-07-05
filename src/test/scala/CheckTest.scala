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

}
