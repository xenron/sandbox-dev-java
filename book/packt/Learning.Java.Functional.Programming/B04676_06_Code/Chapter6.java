package packt;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Chapter6 {

    public static void main(String[] args) {
        usingOptional();
        usingOptionalPrimitives();
        imperativePartSolution();
        usingMonads();
        monadPartSolution();
        serializationTest();
    }

    private static void serializationTest() {
        Customer customer1 = new Customer(123, "Sue");
        Customer customer2 = new Customer(456, "Bob");
        Customer customer3 = new Customer(789, "Mary");
        Optional<Customer> c1 = Optional.of(customer1);
        Optional<Customer> c2 = Optional.of(customer2);
        Optional<Customer> c3 = Optional.of(customer3);
        List<Optional<Customer>> list = new ArrayList();
        list.add(c1);
        list.add(c2);
        list.add(c3);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("test");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(list);
//            oos.writeObject(obj);

//            FileInputStream fis = new FileInputStream("test");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            list = (List<Optional<Customer>>)ois.readObject();
//            ois.close();
            System.out.println("Serialized!");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } //        catch (ClassNotFoundException ex) {
        //            ex.printStackTrace();
        //        } 
        finally {
            try {
                fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();;
            }
        }

        // Sorting
        Optional<Integer> arr[] = new Optional[5];
        arr[0] = Optional.of(5);
        arr[1] = Optional.of(6);
        arr[2] = Optional.of(9);
        arr[3] = Optional.of(2);
        arr[4] = Optional.of(1);
        // Throws java.lang.ClassCastException: java.util.Optional cannot be cast to java.lang.Comparable
//        Arrays.sort(arr);
//        for(Optional<Integer> number : arr) {
//            System.out.println(number);
//        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i].get() < arr[j].get()) {
                    Optional<Integer> tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println();
        for (Optional<Integer> number : arr) {
            System.out.println(number);
        }

    }

    private static void usingOptional() {
        Customer customer1 = new Customer(123, "Sue");
        Customer customer2 = new Customer(456, "Bob");
        Customer customer3 = new Customer(789, "Mary");
        Customer defaultCustomer = new Customer(0, "Default");
        Customers customers = new Customers();
        customers.addCustomer(defaultCustomer.getId(), defaultCustomer);
        customers.addCustomer(customer1.getId(), customer1);
        customers.addCustomer(customer2.getId(), customer2);
        customers.addCustomer(customer3.getId(), customer3);

        // Creating Optional instances
        System.out.println("Creating Optional instances");
        String animal = "cat";
        Optional<String> opt;
        opt = Optional.of(animal);
        System.out.println(opt);

//        animal = null;
//        opt = Optional.of(animal);
//        System.out.println(opt);
        animal = "cat";
        opt = Optional.ofNullable(animal);
        System.out.println(opt);

        animal = null;
        opt = Optional.ofNullable(animal);
        System.out.println(opt);

//        animal = null;
//        opt = Optional.of(animal);
//        System.out.println(opt);
        //
        System.out.println();
        Customer customer;
        System.out.println("findCustomerWithID");
        int id = 234;
//        id = 456;
        customer = customers.findCustomerWithID(id);

        if (customer != null) {
            if (customer.getName().equals("Mary")) {
                System.out.println("Processing Mary");
            } else {
                System.out.println(customer);
            }
        } else {
            System.out.println(defaultCustomer);
        }

        System.out.println();
        System.out.println("findOptionalCustomerWithID");
        Optional<Customer> optionalCustomer = customers.findOptionalCustomerWithID(id);
        if (optionalCustomer.isPresent()) {
            if (optionalCustomer.get().getName().equals("Mary")) {
                System.out.println("Processing Mary");
            } else {
                System.out.println(optionalCustomer.get());
            }
        } else {
            System.out.println(defaultCustomer);
        }

        System.out.println();
        System.out.println("Using ifPresent");
        Consumer<Customer> consume = o -> {
            if (o.getName().equals("Mary")) {
                System.out.println("Processing Mary");
            } else {
                System.out.println(optionalCustomer.get());
            }
        };

        optionalCustomer.ifPresent(consume);

        optionalCustomer.ifPresent(o -> {
            if (o.getName().equals("Mary")) {
                System.out.println("Processing Mary");
            } else {
                System.out.println(optionalCustomer.get());
            }
        });

        System.out.println();
        System.out.println("Using orElse");
        Customer current = customers
                .findOptionalCustomerWithID(id)
                .orElse(defaultCustomer);
        System.out.println(current);

        System.out.println();
        System.out.println("Using orElseGet");
        current = customers
                .findOptionalCustomerWithID(id)
                .orElseGet(() -> customers.findOptionalCustomerWithID(0).get());
        System.out.println(current);

        System.out.println();
//        System.out.println("Using orElseThrow");
//        try {
//            current = customers
//                    .findOptionalCustomerWithID(id)
//                    .orElseThrow(NoCustomerFoundException::new);
//            System.out.println(current);
//        } catch (NoCustomerFoundException ex) {
//            ex.printStackTrace();
//        }
        System.out.println();
        System.out.println("---Complete solution");
        Function<? super Customer, Customer> processMary =
                x -> {
                    if (x.getName().equals("Mary")) {
                        System.out.println("Processing Mary");
                    } 
                    return x;
                };
        Function<? super Customer, Customer> processNotMary =
                x -> {
                    if (!x.getName().equals("Mary")) {
                        System.out.println(x);
                    }
                    return x;
                };
        
        Function<? super Customer, Customer> processCustomer
                = x -> {
                    if (x.getName().equals("Mary")) {
                        System.out.println("Processing Mary");
                    } else {
                        System.out.println(optionalCustomer.get());
                    }
                    return x;
                };
//        Function<? super Part, Part> selectCustomerMap
//                = x -> x.setPartName(x.getPartName() + "-Out-of-stock");
        try {
            id = 789;
            customer3.setName("Mary Sue");
//            id = 123; // 123 blows up!!!
            current = customers
                    .findOptionalCustomerWithID(id)
//                    .map(processCustomer)
                    .map(processMary)
                    .map(processNotMary)
                    .orElseThrow(NoCustomerFoundException::new);
            System.out.println(current);
        } catch (NoCustomerFoundException ex) {
            ex.printStackTrace();
        }

        // Using filter method
        System.out.println();
        System.out.println("---Using Optional filter");
        id = 456;
        current = customers
                .findOptionalCustomerWithID(id)
                .filter(i -> i.getId() > 400)
                .orElseGet(()
                        -> customers.findOptionalCustomerWithID(0).get());
        System.out.println(current);

        // Using Stream filter method
        System.out.println();
        System.out.println("Using Stream filter");
        OptionalInt result = IntStream.of(1, 5, 12, 7, 5, 24, 6)
                .filter(n -> n > 10)
                .max();
        result.ifPresent(o -> System.out.println(o));

        // Using filter map method
        System.out.println();
        System.out.println("Using filter map");
        id = 456;
        String name;
        Optional<Customer> optCustomer = customers.findOptionalCustomerWithID(id);
        if (optCustomer.isPresent()) {
            name = optCustomer.get().getName().trim();
        } else {
            name = "No Name";
        }
        System.out.println(name);
        name = customers
                .findOptionalCustomerWithID(id)
                .map(o -> o.getName().trim())
                .orElse("No Name");

        System.out.println(name);

        // Returning a List
        System.out.println();
        System.out.println("Returning a list");
        List<Customer> list = customers
                .findOptionalCustomerWithID(id)
                .map(Collections::singletonList)
                .orElse(Collections.emptyList());
        for (Customer c : list) {
            System.out.println(c);
        }

        System.out.println("Optional Parameter Example");
        Customer customerOptional = new Customer(123);
        System.out.println(customerOptional);
        customerOptional = new Customer(123, "Steve");
        System.out.println(customerOptional);
        customerOptional = new Customer(123, Optional.of("Steve"));
        System.out.println(customerOptional);
        customerOptional = new Customer(123, Optional.empty());
        System.out.println(customerOptional);
    }

    private static void usingOptionalPrimitives() {
        // Stream and Optional
        Optional<Integer> anyInteger
                = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
                .stream()
                .filter(i -> i % 2 == 0)
                .findAny();
        anyInteger.ifPresent(System.out::println);

        // IntStream and OptionalInt
        OptionalInt anyInt
                = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8})
                .filter(i -> i % 2 == 0)
                .findAny();
        anyInt.ifPresent(System.out::println);
    }

    private static void replicatePart(Part part) {
        // Replicate part
        System.out.println("Part replicated: " + part);
    }

    private static void imperativePartSolution() {
        Map<Integer, Part> parts = new HashMap<>();
        parts.put(123, new Part(123, "bolt"));
        parts.put(456, new Part(456, "nail"));
        parts.put(789, new Part(789, "wire"));

        int partId = 123; // Some source
        Part part = parts.get(partId);
        part.setOutOfStock(true);
        part.setPartName(part.getPartName() + "-Out-Of-Stock");
        replicatePart(part);
    }

    private static void monadPartSolution() {
        Map<Integer, Part> parts = new HashMap<>();
        parts.put(123, new Part(123, "bolt"));
        parts.put(456, new Part(456, "nail"));
        parts.put(789, new Part(789, "wire"));

        System.out.println("---Parts Monad Example");
        Function<? super Part, Optional<Part>> toUpperParts
                = x -> Optional.of(new Part(123, x.getPartName().toUpperCase()));
        Function<? super Part, ? extends Part> outOfStock
                = x -> new Part(234, x.getPartName() + "-Out-of-stock");

        Optional<Part> optPart = Optional.of(new Part(111, "Mirror"));
        Optional<Part> partResult = optPart.flatMap(toUpperParts);
        System.out.println(optPart + " " + optPart.get());
        System.out.println(partResult + " " + partResult.get());

//        Optional<Parts>  xw = partResult.map(outOfStock);
//        System.out.println(xw + " " + xw.get());
        System.out.println(optPart.flatMap(toUpperParts).map(outOfStock));

        System.out.println("---The Part Example");
        // The part example
        Function<? super Part, Optional<Part>> setOOSState
                = x -> x.outOfStock(true);
        Function<? super Part, Optional<Part>> setOOSName
                = x -> x.partName(x.getPartName() + "-Out-of-stock");
        Function<? super Part, Part> setOOSNameMap
                = x -> x.setPartName(x.getPartName() + "-Out-of-stock");
        optPart = Optional.of(parts.get(123));
        try {
            optPart = Optional.of(parts.get(456));
//            optPart = Optional.ofNullable(parts.get(111));
            System.out.println("lambda expressions");
            System.out.println(
                    optPart
                    .flatMap(x -> x.outOfStock(true))
                    .flatMap(x -> x.partName(x.getPartName() + "-Out-of-stock"))
                    .flatMap(Part::replicatePartMonad)
                    .orElseThrow(() -> new RuntimeException())
            );

            System.out.println("lambda variables");
            optPart = Optional.of(parts.get(456));
            System.out.println(
                    optPart
                    .flatMap(setOOSState)
                    .map(setOOSNameMap)
                    //                    .flatMap(setOOSName)
                    .flatMap(Part::replicatePartMonad)
                    .orElseThrow(() -> new RuntimeException())
            );
            System.out.println(optPart);
        } catch (RuntimeException ex) {
            System.out.println("Exception: " + optPart);
        }
    }

    private static void usingMonads() {
        System.out.println("---Integer flatMap Example");
        Optional<Integer> one = Optional.of(1);

        Optional<Integer> plusOne = one.flatMap(n -> Optional.of(n + 1));
        System.out.println(plusOne.get());

        Function<? super Integer, Optional<Integer>> plusOneFunction
                = n -> Optional.of(n + 1);
        plusOne = one.flatMap(plusOneFunction);
        System.out.println(plusOne.get());

        System.out.println("---Integer map Example");
        Function<? super Integer, ? extends Integer> plusOneMapFunction
                = n -> n + 1;
        plusOne = one.map(x -> x + 1);
        System.out.println(plusOne.get());
        plusOne = one.map(plusOneMapFunction);
        System.out.println(plusOne.get());

        System.out.println("---Integer flatMap and map Example");
        plusOne = one
                .map(x -> x.intValue() + 1)
                .flatMap(n -> Optional.of(n + 1));
        System.out.println(plusOne.get());

        System.out.println("---Integer to String Example");
        Optional<String> result = one.flatMap(n -> Optional.of((++n).toString()));
        System.out.println(result + " " + result.get());

        //
        System.out.println("---String Monad Example");
        String iterative = "go".toUpperCase().concat("ing");
        System.out.println("Iterative: " + iterative);
        iterative = "go".concat("ing").toUpperCase();
        System.out.println("Iterative: " + iterative);
        Function<? super String, Optional<String>> toConcatString = x -> Optional.of(x + "ing");
        Function<? super String, Optional<String>> toUpperString = x -> Optional.of(x.toUpperCase());
        Optional<String> ostring = Optional.of("go");
        // The order of the flatMap methods is important
        ostring = Optional.of("go");
        result = ostring
                .flatMap(toConcatString)
                .flatMap(toUpperString);
        System.out.println(ostring.get());
        System.out.println(result.get());

        // flatMap method order reversed
        result = ostring
                .flatMap(toUpperString)
                .flatMap(toConcatString);
        System.out.println(ostring.get());
        System.out.println(result.get());
        //
        System.out.println("---Left Identity Example");
        ostring = Optional.of("go");
        Optional<String> monad1;
        monad1 = ostring.flatMap(toConcatString);
        result = toUpperString.apply(monad1.get());
        System.out.println(result.get());
        //
        System.out.println("---Right Identity Example");
        ostring = Optional.of("right");
        System.out.println(ostring.flatMap(s -> Optional.of(s)) == ostring);
        System.out.println(ostring.flatMap(s -> Optional.of(s)).equals(ostring));
        System.out.println(ostring.flatMap(s -> Optional.of(s)) + "==" + ostring);

//        jdk8_optional_monad_laws laws = new jdk8_optional_monad_laws();
//        try {
//            laws.test();
//        } catch (Exception ex) {
//            ex.printStackTrace();
 //       }
    }
}
