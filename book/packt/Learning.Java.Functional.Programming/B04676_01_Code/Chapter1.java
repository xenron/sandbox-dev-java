package packt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

public class Chapter1 {

    public static void main(String[] args) {
        highOrderFunctionExamples();
        fluentInterfacesExamples();
        lazyEvaluationExample();
        concurrentExamples();
        composeExample();
        recursionExamples();
        defaultInterfaceExamples();
        functionalInterfaceExample();
        methodReferenceExample();
        collectionExamples();
    }

    // High-order and first-class functions
    private static void highOrderFunctionExamples() {

        Integer arr[] = {1, 2, 3, 4, 5};
        List<Integer> numbers = Arrays.asList(arr);
        numbers.forEach(x -> System.out.println(x));
    }

    private static void fluentInterfacesExamples() {
        // Date and time example
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusYears(2);
        futureDate = today.minusMonths(1);
        futureDate = today.plusDays(3);
        System.out.println(LocalDate.now());
        System.out.println(futureDate);

        futureDate = LocalDate.now()
                .plusYears(2)
                .minusMonths(1)
                .plusDays(3);

        System.out.println(LocalDate.now());
        System.out.println(futureDate);

        // Stream example
        Stream<String> names = Stream.of("George", "Mary", "Karen", "Jim");
        Function<String, String> toLower = (String name) -> name.toLowerCase();
        names.map(toLower).sorted().forEach(x -> System.out.println(x));

    }

    private static void lazyEvaluationExample() {
        Random random = new Random();
        random.ints().limit(5).sorted().forEach(x -> System.out.println(x));
        System.out.println("---");
    }

    private static void concurrentExamples() {
        Stream<Integer> stream = Stream.of(12, 52, 32, 74, 25);
        stream.map(x -> x * 2).forEach(x -> System.out.println(x));
        System.out.println("---");
        stream = Stream.of(12, 52, 32, 74, 25);
        stream.parallel().map(x -> x * 2).forEach(x -> System.out.println(x));
    }

    private static void composeExample() {
        Function<Integer, Integer> absThenNegate
                = ((Function<Integer, Integer>) Math::negateExact).compose(Math::abs);
        Function<Integer, Integer> negateThenAbs
                = ((Function<Integer, Integer>) Math::negateExact).andThen(Math::abs);

        System.out.println(absThenNegate.apply(-25));
        System.out.println(absThenNegate.apply(25));
        System.out.println(negateThenAbs.apply(-25));
        System.out.println(negateThenAbs.apply(25));

    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    private static void recursionExamples() {
        // Iterative solution to factorial problem
        int result = 1;
        int num = 5;
        for (int i = 5; i >= 1; i--) {
            result = result * i;
        }
        System.out.println(result);

        // Recursive solution
        result = factorial(num);
        System.out.println(result);
    }

    class Customer {

    }

    public static Optional<Customer> findCustomerWithID(long id) {
        //...
        return Optional.empty();
    }

    private static void optionalExamples() {
        Optional<Customer> optionalCustomer = findCustomerWithID(123);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            // Use customer
        } else {
            // handle missing value
        }
    }

    private static void lambdaExpressionExamples() {
        Random random = new Random();
        random.ints().limit(5).map(x -> 2 * x).forEach(System.out::println);
        random.ints().limit(5).map(x -> {
            int y = 2 * x;
            return y;
        }).forEach(System.out::println);
        random.ints().limit(5).map(x -> 2 * x).forEach(System.out::println);
    }

    private static void defaultInterfaceExamples() {
        ComputeImpl computeImpl = new ComputeImpl();
        System.out.println(computeImpl.doubleNumber(2));

        ArrayList<String> list = new ArrayList();
        list.add("Apple");
        list.add("Peach");
        list.add("Banana");
        list.forEach(f -> System.out.println(f));
    }

    private static void functionalInterfaceExample() {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread!");
            }
        }).start();
    }

    private static void methodReferenceExample() {
        Stream<Integer> stream = Stream.of(12, 52, 32, 74, 25);
        stream.map(x -> x * 2).forEach(x -> System.out.println(x));
        stream = Stream.of(12, 52, 32, 74, 25);
        stream.map(x -> x * 2).forEach(System.out::println);
        stream = Stream.of(12, 52, 32, 74, 25);
        stream.map(Math::sin).forEach(System.out::println);

    }

    private static void collectionExamples() {
        String names[] = {"Sally", "George", "Paul"};
        List<String> list = Arrays.asList(names);
        Stream<String> stream = list.stream();
        stream.forEach(name -> System.out.println(name + " - " + name.length()));

        list.forEach(name -> System.out.println(name + " - " + name.length()));
    }
}
