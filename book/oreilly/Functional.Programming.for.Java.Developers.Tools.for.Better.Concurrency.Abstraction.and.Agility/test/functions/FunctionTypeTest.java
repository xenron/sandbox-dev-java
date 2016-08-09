package functions;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Exercises the Function1Void and Function3 representations of
 * "anonymous functions".
 */
public class FunctionTypeTest {

  static boolean called = false;

  @Before
  public void setup() {
    called = false;
  }

  private void invokeCallback1Void(Function1Void<String> f) {
    f.apply("hello!");
  }

  @Test
  public void function1VoidTakesOneArgumentAndReturnsVoid() {
    invokeCallback1Void(new Function1Void<String>() {
      public void apply(String message) {
        called = true;
      }
    });
    assertTrue(called);
  }

  private Boolean invokeCallback1(Function1<String, Boolean> f) {
    return f.apply("hello!");
  }

  @Test
  public void function1TakesOneArgumentAndReturnsAValue() {
    called = invokeCallback1(new Function1<String, Boolean>() {
      public Boolean apply(String message) {
        return true;
      }
    }).booleanValue();
    assertTrue(called);
  }

  private Boolean invokeCallback1ContravariantArg(
      Function1<? super String, Boolean> f) {
    return f.apply("hello!");
  }

  @Test
  public void functionsWithContravariantArgumentsAreValid() {
    called = invokeCallback1ContravariantArg(
      new Function1<Object, Boolean>() {
        public Boolean apply(Object message) {
          return true;
        }
      }).booleanValue();
    assertTrue(called);
  }

  private Object invokeCallback1ConvariantReturn(
      Function1<String, ? extends Object> f) {
    return f.apply("hello!");
  }

  @Test
  public void functionsWithCovariantReturnssAreValid() {
    Object result = invokeCallback1ConvariantReturn(
      new Function1<String, Object>() {
        public Object apply(String message) {
          return true;
        }
      });
    assertTrue(result instanceof Boolean);
    called = ((Boolean) result).booleanValue();
    assertTrue(called);
  }

  private Boolean invokeCallback2(
      Function2<String, Integer, Boolean> f) {
    return f.apply("hello3!", 1);
  }

  @Test
  public void function2TakesThreeArgumentsAndReturnsAValue() {
    called = invokeCallback2(
      new Function2<String, Integer, Boolean>() {
        public Boolean apply(String message, Integer i) {
          return true;
        }
      }).booleanValue();
    assertTrue(called);
  }

}