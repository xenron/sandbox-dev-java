package packt;

public class Compose {
    public interface CompositionFunction<T, R> {
        R call(T x);
    }

    public static <T, U, R> CompositionFunction<T, R> compose(
            final CompositionFunction<U, R> f,
            final CompositionFunction<T, U> g) {
        return new CompositionFunction<T, R>() {
            public R call(T x) {
                return f.call(g.call(x));
            }
        };
    }
}
