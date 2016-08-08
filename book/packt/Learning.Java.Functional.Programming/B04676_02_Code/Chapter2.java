package packt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Chapter2 {

    private static List<String> list = Arrays.asList("Huey", "Duey", "Luey");

    public static void main(String[] args) {
        lambdaExpressionsRevisited();
        highOrderFunctionExamples();
        returnFunctionExample();
        firstClassExamples();

        pureFunctionExamples();
        memoizationExample();
        eliminatingDependenciesExample();
        closureExamples();
        curryingExample();
        sampleLambdaExpressions();
        typeInferenceExample();
        exceptionHandlingExample();
        functionalInterfaceExamples();
    }

    private static void lambdaExpressionsRevisited() {
        list.forEach(new ConsumerImpl<>());
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.println(t);
            }
        });

        list.forEach(t -> System.out.println(t));

        Consumer consumer = t -> System.out.println(t);
        list.forEach(consumer);
    }

    private static String processString(
            Function<String, String> operation,
            String target) {
        return operation.apply(target);
    }

    private static void highOrderFunctionExamples() {
        // Imperative approach
        for (String element : list) {
            System.out.println(element.toLowerCase());
        }

        // High-order function approach
        list.forEach(s -> System.out.println(
                processString(t -> t.toLowerCase(), s)));

        // Using a method reference
        list.forEach(s -> System.out.println(
                processString(String::toLowerCase, s)));

        System.out.println();

        List<String> numberString = Arrays.asList("12", "34", "82");
        List<Integer> numbers = new ArrayList<>();
        List<Integer> doubleNumbers = new ArrayList<>();

        for (String num : numberString) {
            numbers.add(Integer.parseInt(num));
        }
        System.out.println(numbers);

        numbers.clear();
        numberString
                .stream()
                .forEach(s -> numbers.add(Integer.parseInt(s)));
        System.out.println(numbers);

        numbers.clear();
        Function<List<String>, List<Integer>> singleFunction = s -> {
            s.stream()
                    .forEach(t -> numbers.add(Integer.parseInt(t)));
            return numbers;
        };
        System.out.println(singleFunction.apply(numberString));

        Function<List<String>, List<Integer>> doubleFunction = s -> {
            s.stream()
                    .forEach(t -> doubleNumbers.add(Integer.parseInt(t) * 2));
            return doubleNumbers;
        };
        System.out.println(doubleFunction.apply(numberString));

        doubleNumbers.clear();
//        Arrays.asList(numberString);
        System.out.println("Last example");
        
        Arrays.asList(numberString).stream()
                .map(doubleFunction)
                .forEach(s -> System.out.println(s));
    }

    enum EmployeeType {

        Hourly, Salary, Sales
    };

    private static float calculatePay(int hoursWorked, float payRate, EmployeeType type) {
        switch (type) {
            case Hourly:
                return hoursWorked * payRate;
            case Salary:
                return 40 * payRate;
            case Sales:
                return 500.0f + 0.15f * payRate;
            default:
                return 0.0f;
        }
    }

    private static BiFunction<Integer, Float, Float> calculatePayFunction(EmployeeType type) {
        switch (type) {
            case Hourly:
//                return (hours, payRate) -> hours * payRate;
                return (hours, payRate) -> {
                    if (hours <= 40) {
                        return hours * payRate;
                    } else {
                        return hours * payRate + (hours - 40) * 1.5f * payRate;
                    }
                };
            case Salary:
                return (hours, payRate) -> 40 * payRate;
            case Sales:
                return (hours, payRate) -> 500f + 0.15f * payRate;
            default:
                return null;
        }
    }

    private static void returnFunctionExample() {
        int hoursWorked[] = {8, 12, 8, 6, 6, 5, 6, 0};
        // Calculate sum imperatively
        int totalHoursWorked = 0;
        for (int hour : hoursWorked) {
            totalHoursWorked += hour;
        }

        // Calculate sum using stream
        totalHoursWorked = Arrays.stream(hoursWorked).sum();

        System.out.println(
                calculatePay(totalHoursWorked, 15.75f, EmployeeType.Hourly));

        System.out.println(
                calculatePayFunction(EmployeeType.Hourly)
                .apply(totalHoursWorked, 15.75f));
    }

    private static void firstClassExamples() {
        BiFunction<Integer, Float, Float> calculateFunction;
        int hoursWorked = 51;
        calculateFunction = calculatePayFunction(EmployeeType.Hourly);
        System.out.println(calculateFunction.apply(hoursWorked, 15.75f));

        if (hoursWorked <= 40) {
            calculateFunction = (hours, payRate) -> 40 * payRate;
        } else {
            calculateFunction = (hours, payRate) -> hours * payRate + (hours - 40) * 1.5f * payRate;
        }
        System.out.println(calculateFunction.apply(hoursWorked, 15.75f));

        // Consumer example
        Consumer<String> consumer;
        Function<String, String> toLowerFunction;
//        function = t -> t.toLowerCase();
        toLowerFunction = String::toLowerCase;
        consumer = s -> System.out.println(toLowerFunction.apply(s));
//        consumer = s -> System.out::println(s);

        list.forEach(consumer);
    }

    private static void pureFunctionExamples() {
        System.out.println(SimpleMath.square(5));
        Function<Integer, Integer> squareFunction = x -> x * x;
        System.out.println(squareFunction.apply(5));
    }

    private final static Map<Integer, Integer> memoizationCache = new HashMap<>();

    public static Integer computeExpensiveSquare(Integer input) {
        if (!memoizationCache.containsKey(input)) {
            memoizationCache.put(input, doComputeExpensiveSquare(input));
        }
        return memoizationCache.get(input);
    }

    private static Integer doComputeExpensiveSquare(Integer input) {
        System.out.println("Computing square");
        return input * input;
    }

    private static void memoizationExample() {
        // Simple memoization
        System.out.println(computeExpensiveSquare(4));
        System.out.println(computeExpensiveSquare(4));
        System.out.println();

        // Better memoization
        Function<Integer, Integer> squareFunction = x -> {
            System.out.println("In function");
            return x * x;
        };

        Function<Integer, Integer> memoizationFunction = Memoizer.memoize(squareFunction);
        System.out.println(memoizationFunction.apply(2));
        System.out.println(memoizationFunction.apply(2));
        System.out.println(memoizationFunction.apply(2));

        Function<Double, Double> memoizationFunction2 = Memoizer.memoize(x -> x * x);
        System.out.println(memoizationFunction2.apply(4.0));
    }

    static int num = 5;

    private static void eliminatingDependenciesExample() {
        BiFunction<Integer, Double, Double> computeHourly = (hours, rate) -> hours * rate;
        Function<Double, Double> computeSalary = rate -> rate * 40.0;
        BiFunction<Double, Double, Double> computeSales = (rate, commission) -> rate * 40.0 + commission;

        double hourlyPay = computeHourly.apply(35, 12.75);
        double salaryPay = computeSalary.apply(25.35);
        double salesPay = computeSales.apply(8.75, 2500.0);

        System.out.println(computeHourly.apply(35, 12.75)
                + computeSalary.apply(25.35)
                + computeSales.apply(8.75, 2500.0));

        double total = 0.0;
        boolean hourly = true;
        if (hourly) {
            total = hourlyPay;
        } else {
            total = salaryPay + salesPay;
        }
        System.out.println(total);

        Function<Double, Double> pureFunction = t -> 3 * t;
        num = 6;
        Function<Double, Double> impureFunction = t -> 3 * t + num;
    }

    private static void closureExamples() {
        ClosureExample ce = new ClosureExample();
        final Function<String, String> function = ce.getStringOperation();
        System.out.println(function.apply("Closure"));

//        function = String::toLowerCase;
//        Consumer<String> consumer = s -> System.out.println(function.apply(s));
    }

    private static void curryingExample() {
        // Simple BiFunction
        BiFunction<String, String, String> biFunctionConcat = (a, b) -> a + b;
        System.out.println(biFunctionConcat.apply("Cat", "Dog"));

        // 
        Function<String, Function<String, String>> curryConcat;
        curryConcat = (a) -> (b) -> biFunctionConcat.apply(a, b);
        Function<String, String> intermediateFunction;
        intermediateFunction = curryConcat.apply("Cat");
        // Displays the lambda expression reference
        System.out.println(intermediateFunction);
        System.out.println(curryConcat.apply("Cat"));
        System.out.println(intermediateFunction.apply("Dog"));

        // Other usage
        System.out.println(curryConcat.apply("Cat").apply("Dog"));
        System.out.println(curryConcat.apply("Flying ").apply("Monkeys"));

        Function<Double, Function<Double, Double>> curryAdd
                = (a) -> (b) -> a * b;
        System.out.println(curryAdd.apply(3.0).apply(4.0));

    }

    private static void sampleLambdaExpressions() {
        // Sample lambda expressions
        Function<Integer, Integer> s = x -> {
            Integer y;
            y = x + 1;
            return y;
        };

        BiFunction<Integer, Double, Double> bi = (Integer x, Double y) -> x + y;
        System.out.println(bi.apply(2, 2.0));
    }

    private static void typeInferenceExample() {
        StringConcatenation sc = (s, t) -> s + ":" + t;
        IntegerConcatenation ic = (m, n) -> m + ":" + n;
        DoubleConcatenation dc = (m, n) -> m + ":" + n;

        System.out.println(sc.concatenate("Cat", "Dog"));
        System.out.println(ic.concatenate(23, 45));
        System.out.println(dc.concatenate(23.12, 45.12));

        Concatenation<String> stringConcatenate = (s, t) -> s + ":" + t;
        Concatenation<Integer> integerConcatenate = (s, t) -> s + ":" + t;
        System.out.println(stringConcatenate.concatenate("Cat", "Dog"));
        System.out.println(integerConcatenate.concatenate(23, 45));
    }

    private static void exceptionHandlingExample() throws IllegalArgumentException {
        IntegerConcatenation ic = (m, n) -> {
            if (m == 0) {
                throw new IllegalArgumentException();
            } else {
                return m + ":" + n;
            }
        };
        System.out.println(ic.concatenate(0, 45));
    }

    private static void functionalInterfaceExamples() {
//        Predicate<Integer> tooLarge = s -> s>100;
        IntPredicate tooLarge = s -> s > 100;
        System.out.println(tooLarge.test(45));
        List<Integer> list = Arrays.asList(230, 45, 13, 563, 4);
        Stream<Integer> stream = list.stream();
        stream.forEach(s -> System.out.println(tooLarge.test(s)));

        Supplier<Integer> randomIntegers = () -> {
            Random random = new Random();
            int number = random.nextInt(10);
            while (number >= 5 && number <= 8) {
                number = random.nextInt(10);
            }
            return number;
        };
        for (int i = 0; i < 10; i++) {
            System.out.print(randomIntegers.get() + " ");
        }
        System.out.println();

        BinaryOperator<String> stringConcatenate = (s, t) -> s + ":" + t;
        System.out.println(stringConcatenate.apply("Cat", "Dog"));
    }
}
