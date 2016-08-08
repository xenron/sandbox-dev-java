package packt;

import java.util.function.Function;

// Adapted from http://mttkay.github.io/blog/2014/01/25/your-app-as-a-function/
public class Monad<T> {
  private T value;

  private Monad(T value) {
    this.value = value;
  }

  public static <T> Monad<T> unit(T value) {
    return new Monad<T>(value);
  }

  public <R> Monad<R> flatMap(Function<T, Monad<R>> func) {
    return func.apply(this.value);
  }

  public T get() {
    return value;
  }
}

