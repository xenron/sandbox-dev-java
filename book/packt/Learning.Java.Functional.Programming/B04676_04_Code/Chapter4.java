package packt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chapter4 {

    public static void main(String[] args) {
        simpleExample();
        fixedLengthStreamExamples();
        infiniteStreamsExample();
        mapExamples();
        flatMapExamples();
        filterExamples();
        usingTheSkipMethod();
        sortingStreamExamples();
        lazyEvaluationExamples();
        parallelStreamExamples();
    }

    private static void simpleExample() {
        int[] numbers = {3, 6, 8, 8, 4, 6, 3, 3, 5, 6, 9, 4, 3, 6};

//        Arrays.sort(numbers);
        // find distinct
        Set<Integer> numberSet = new HashSet<>();
        for (int number : numbers) {
            numberSet.add(number);
        }

        // Compute total
        int total = 0;
        for (int number : numberSet) {
            total += number;
            System.out.println(number);
        }
        System.out.println(total);

        total = Arrays
                .stream(numbers)
                .distinct()
                .sum();

        IntStream stream = Arrays.stream(numbers);
        total = stream
                .distinct()
                .sum();

        stream = Arrays.stream(numbers);
        total = stream.sum();
        System.out.println(total);
    }

    private static void fixedLengthStreamExamples() {
        int[] numbers = {3, 6, 8, 8, 4, 6, 3, 3, 5, 6, 9, 4, 3, 6};
//    IntStream stream = Arrays.stream(numbers);

        Rectangle[] rectangles = {
            new Rectangle(10, 10, 50, 75),
            new Rectangle(30, 40, 30, 45),
            new Rectangle(110, 70, 70, 15),
            new Rectangle(50, 10, 45, 35)
        };
        Stream<Rectangle> stream = Arrays.stream(rectangles);

        List<String> cities = new ArrayList<>();
        cities.add("London");
        cities.add("Paris");
        cities.add("Cairo");
        cities.add("Manila");
        Stream<String> cityStream = cities.stream();
    }

    private static void infiniteStreamsExample() {
        // Iterative approach
//        Random random = new Random();
//        while (true) {
//            int number = random.nextInt();
//            // process number
//        }

        // Simple integer stream iteration
        System.out.println("Simple integer iteration");
        IntStream.iterate(0, n -> n + 1)
                .limit(10)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("Filter the output");
        IntStream.iterate(0, n -> n + 1)
                .filter(n -> n > 10 && n < 100)
                .limit(10)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Infinite stream
        System.out.println("Infinite stream");
//        IntStream.iterate(0, n -> (n+1)%2)
//         .distinct()
//         .limit(10)
//         .forEach(System.out::println);

        // Infinte stream using the Scanner class
//        Scanner scanner = new Scanner(System.in);
//        Stream.iterate(scanner.next(), s -> scanner.next())
//                .limit(5)
//                .forEach(System.out::println);
        // Simple string iterate        
        System.out.println("String itertation example");
        Stream.iterate("Going", m -> m + "...")
                .limit(5)
                .forEach(System.out::println);

        // Madlibs
        String[] subject = {"cat", "dog", "monkey", "bat"};
        String[] verb = {"chased", "ate", "lost", "swatted"};
        String[] object = {"ball", "rat", "doughnut", "tamale"};
        Random random = new Random();

        Stream.iterate("", m -> subject[random.nextInt(3)]
                + " " + verb[random.nextInt(3)]
                + " the " + object[random.nextInt(3)])
                .limit(5)
                .forEach(System.out::println);

        Stream.iterate(subject[random.nextInt(3)]
                + " " + verb[random.nextInt(3)]
                + " the " + object[random.nextInt(3)], m -> subject[random.nextInt(3)]
                + " " + verb[random.nextInt(3)]
                + " the " + object[random.nextInt(3)])
                .limit(5)
                .forEach(System.out::println);

        // generate examples
        System.out.println("Repeating values example");
        Supplier intSupplier = () -> 0;
        Stream.generate(intSupplier)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("Reusing previous values example");
        Stream.generate(() -> nextInt())
                .limit(5)
                .forEach(System.out::println);

        // Cannot use a lambda expression
//        int number = 0;
//        Stream.generate(()->number++)
//                .limit(5)
//                .forEach(System.out::println);        
        System.out.println("Random generate example");
        Supplier<Double> randomSupplier = Math::random;
        System.out.println();
        Stream.generate(randomSupplier)
                .limit(4)
                .forEach(System.out::println);

    }

    static int number = 0;

    private static int nextInt() {
        return number++;
    }

    private static void mapExamples() {
        Rectangle[] rectangles = {
            new Rectangle(10, 10, 50, 75),
            new Rectangle(30, 40, 30, 45),
            new Rectangle(110, 70, 70, 15),
            new Rectangle(50, 10, 45, 35)
        };
        int total = 0;

        for (Rectangle rectangle : rectangles) {
            rectangle.scale(0.25);
            System.out.println(total + " - " + rectangle.getArea());
            total += rectangle.getArea();
        }
        System.out.println(total);
        // Iterative approach
        System.out.println("Iterative mapping");
        for (Rectangle rectangle : rectangles) {
            rectangle.scale(0.25);
        } 
        for (Rectangle rectangle : rectangles) {
            total += rectangle.getArea();
        }
        System.out.println(total);
        // Stream map
        System.out.println("Stream mapping");
        Stream<Rectangle> stream = Arrays.stream(rectangles);

        // Approach 1
//        System.out.println();
//        total = stream
//                .map(r -> r.scale(0.25))
//                .mapToInt(Rectangle::getArea)
//                .map(Rectangle::getArea)
//                .sum();
//        System.out.println(total);
        // Approach 2
        System.out.println();
        stream = Arrays.stream(rectangles);
        total = stream
                .map(r -> r.scale(0.25))
                .map(Rectangle::getArea)
                //                .mapToInt(Rectangle::getArea)
                //                .reduce(0,(r, s) -> r + s);
                .reduce(0, (r, s) -> {
                    System.out.println(r + " - " + s);
                    return r + s;
                });
        System.out.println(total);

    }

    private static void flatMapExamples() {
        // concat example
        System.out.println("concat example");
        List<Rectangle> list1 = Arrays.asList(new Rectangle(10, 10, 20, 20),
                new Rectangle(10, 20, 30, 40),
                new Rectangle(40, 30, 20, 20));
        List<Rectangle> list2 = Arrays.asList(new Rectangle(50, 50, 30, 30),
                new Rectangle(60, 60, 20, 20));
        Stream<Rectangle> list1Stream = list1.stream();
        Stream<Rectangle> list2Stream = list2.stream();
        Stream<Rectangle> concatenatedStream
                = Stream.concat(list1Stream, list2Stream);
        concatenatedStream.forEach(System.out::println);

        // Imperative approach        
        List<List<Rectangle>> rectangleLists = Arrays.asList(
                Arrays.asList(new Rectangle(10, 10, 20, 20),
                        new Rectangle(10, 20, 30, 40),
                        new Rectangle(40, 30, 20, 20)),
                Arrays.asList(new Rectangle(50, 50, 30, 30),
                        new Rectangle(60, 60, 20, 20)),
                Arrays.asList(new Rectangle(100, 100, 30, 40),
                        new Rectangle(110, 10, 20, 20),
                        new Rectangle(120, 10, 50, 60))
        );

        System.out.println("Imperative approach");
        List<Rectangle> flatList = new ArrayList<>();
        for (List<Rectangle> rectangleList : rectangleLists) {
            flatList.addAll(rectangleList);
        }

        for (Rectangle rectangle : flatList) {
            System.out.println(rectangle);
        }

        // Stream approach
        System.out.println("Stream approach");
        Stream<List<Rectangle>> rectangleListStream = rectangleLists.stream();

        Stream<Rectangle> rectangleStream = rectangleListStream
                .flatMap((list) -> list.stream());
        rectangleStream.forEach(System.out::println);

        System.out.println("Stream shorter approach");
        rectangleLists.stream()
                .flatMap((list) -> list.stream())
                .forEach(System.out::println);

        rectangleLists
                .stream()
                .flatMap(
                        (list) -> list.stream()
                        .map(r -> {
                            r.setHeight(30);
                            return r;
                        })
                        .filter(r -> r.getArea() > 900)
                )
                .map(r -> r.getArea())
                .distinct()
                .forEach(System.out::println);
    }

    private static void filterExamples() {
        String[] animals = {"cats", "dog", "ox", "bats", "horses", "mule"};
        System.out.println("Imperative implementation");
        List<String> list = new ArrayList<>();
        for (String name : animals) {
            if (!name.matches(".*s$")) {
                list.add(name);
            }
        }
        list.sort(null);
        for (String name : list) {
            System.out.println(name);
        }

        System.out.println("Stream implementation");
        Stream<String> animalStream = Arrays.stream(animals);
        animalStream
                .filter(x -> !x.matches(".*s$"))
                .sorted()
                .forEach(x -> System.out.println(x));

        // Minic SQL statement
        System.out.println("SQL example");
        Rectangle[] rectangles = {
            new Rectangle(10, 10, 50, 75),
            new Rectangle(30, 40, 30, 45),
            new Rectangle(110, 70, 70, 15),
            new Rectangle(50, 10, 45, 35)
        };
        Stream<Rectangle> stream = Arrays.stream(rectangles);
        // Select * from rectangles where x>10
        stream.filter(r -> r.getX() > 10)
                .forEach(r -> System.out.println(r));
    }

    private static void usingTheSkipMethod() {
        int[] numbers = {3, 6, 8, 8, 4, 6, 3, 3, 5, 6, 9, 4, 3, 6};
        IntStream stream = Arrays.stream(numbers);
        IntSummaryStatistics stats = stream.skip(5).summaryStatistics();
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Count: " + stats.getCount());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Sum: " + stats.getSum());
    }

    private static void sortingStreamExamples() {
        int[] numbers = {3, 6, 8, 8, 4, 6, 3, 3, 5, 6, 9, 4, 3, 6};
        IntStream stream = Arrays.stream(numbers);
        stream.sorted().forEach(n -> System.out.print(n + " "));
        System.out.println();

        stream = Arrays.stream(numbers);
        stream.sorted().distinct().forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static void lazyEvaluationExamples() {
        IntUnaryOperator sampleMap = num -> {
            System.out.println("number: " + num);
            return num;
        };
        Random random = new Random();
        IntStream randomStream = random.ints()
                .limit(5)
                .map(sampleMap)
                .sorted();
        System.out.println(randomStream);
        randomStream.forEach(System.out::println);

        // Divide by zero example
        Function<Integer, Integer> divide = n -> 1 / 0;
        Function<Integer, Integer> add = n -> n + 3;
        Function<Integer, Integer> multiply = n -> n * 5;
        Function<Integer, Integer> subtract = n -> n - 4;

        Function[] arr = {divide, add, multiply, subtract};
        Stream<Function> stream = Arrays.stream(arr);
        stream.skip(1)
                .forEach(operation -> System.out.println(operation.apply(2)));
    }

    private static void parallelStreamExamples() {
//        int[] pay = {40, 45, 54, 35, 48, 40, 40, 23, 54, 45, 44};
//        IntStream payStream = Arrays.stream(pay);
//        payStream.map(h->getRate(h)).forEach(p -> System.out.println(p));

        List<Integer> hours
                = Arrays.asList(32, 40, 24, 23, 35, 18, 40, 30, 23, 
                        54, 35, 34, 25, 15, 34, 35, 42, 44, 40, 35, 
                        35, 45, 35, 31, 12, 56);
        // 26610
        // 26250         
        System.out.println("Total hours");
        int sumHours = hours
                .parallelStream()
                .map(h -> h * 30)
                .reduce(0, (r, s) -> r + s);
        System.out.println(sumHours);

        // Non-interference Examples
        System.out.println("Non-interference Examples");
        // ArrayList Version
//        System.out.println("ArrayList Version");
//        Stream<Integer> hoursStream;
//        hoursStream = hours.parallelStream();
//        int totalHours = hoursStream
//                .map(h -> {
//                    int amount = h*30;
//                    if (amount > 40) {
//                        hours.add(h + 10);
//                    }
//                    return amount;
//                })
//                .reduce(0, (r, s) -> r + s);
//        System.out.println(totalHours);

        // CopyOnWriteArrayList List Example
        System.out.println("CopyOnWriteArrayList List Example");
        CopyOnWriteArrayList<Integer> concurrentHours
                = new CopyOnWriteArrayList(
                        Arrays.asList(32, 40, 54, 23, 35, 48, 40, 40, 23, 54, 45, 44,
                                45, 65, 34, 35, 42, 42, 50, 45, 35, 45, 35, 31, 12, 56));
        Stream<Integer> hoursStream;
        hoursStream = concurrentHours.parallelStream();
        int totalHours = hoursStream
                .map(h -> {
                    int amount = h * 30;
                    if (amount > 40) {
                        concurrentHours.add(h + 10);
                    }
                    return amount;
                })
                .reduce(0, (r, s) -> r + s);
        System.out.println(totalHours);

        // Stateful operation
        System.out.println("Stateful Operation Example");
//        rate = 30;
        for (int i = 0; i < 2; i++) {
            rate = 30;
            int total = hours
                    .parallelStream()
                    .map(h -> getPay(h))
                    .reduce(0, (r, s) -> r + s);
            System.out.println(total);
        }

        // Side effects
        System.out.println("Side Effect Example");
        List<Integer> overtimeList = new ArrayList<>();
//        hours
//                .parallelStream()
//                .filter(s -> s > 40)
//                .forEach(s -> overtimeList.add(s));

        overtimeList = hours
                .parallelStream()
                .filter(s -> s > 40)
                .collect(Collectors.toList());
        // ArrayList is not thread safe
        for (Integer hour : overtimeList) {
            System.out.print(hour + " ");
        }
        System.out.println();

        // Ordering
        System.out.println("Unsorted Example");
        hours
                .parallelStream()
                .filter(s -> s > 40)
                .sorted()
                .forEach(h -> System.out.print(h + " "));
        System.out.println();

        System.out.println("Sorted Example");
        hours
                .parallelStream()
                .filter(s -> s > 40)
                .sorted()
                .forEachOrdered(s -> System.out.print(s + " "));
        System.out.println();
    }

    static int rate = 30;

    private static int getPay(int hours) {
        if (hours > 40) {
            rate = 25;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } else {
            rate = 30;
        }
        return rate * hours;
    }
}
