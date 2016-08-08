package packt;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import packt.Compose.CompositionFunction;

public class Chapter3 {

    public static void main(String[] args) {
        composeExamples();
        methodCascadingAndFluentExamples();
        defaultMethodExamples();
    }

    private static void composeExamples() {
        compositionFunctionExamples();
        demonstration();
        customerExamples();
    }

    private static void compositionFunctionExamples() {
        // Used prior to Java 8
        CompositionFunction<Double, Double> doubleNumber
                = new CompositionFunction<Double, Double>() {
                    public Double call(Double x) {
                        return 2 * x;
                    }
                };
        CompositionFunction<Double, Double> negateNumber
                = new CompositionFunction<Double, Double>() {
                    public Double call(Double x) {
                        return -x;
                    }
                };

        CompositionFunction<Double, Double> doubleThenNegate;
        doubleThenNegate = Compose.compose(doubleNumber, negateNumber);
        System.out.println(-(2 * 5.0));
        System.out.println(doubleThenNegate.call(5.0));

        // Java 8 approach
        Function<Double, Double> doubleFunction = x -> 2 * x;
        Function<Double, Double> second
                = doubleFunction.compose(x -> -x);
        System.out.println(second.apply(5.0));

        Function<Integer, Integer> baseFunction = t -> t + 2;
        System.out.println(baseFunction.apply(5));

        Function<Integer, Integer> afterFunction
                = baseFunction.andThen(t -> t * 3);
        System.out.println(afterFunction.apply(5));

        Function<Integer, Integer> beforeFunction
                = baseFunction.compose(t -> t * 3);
        System.out.println(beforeFunction.apply(5));

        System.out.println(baseFunction.compose((Integer t) -> t * 3).apply(5));
    }

    private static void customerExamples() {
        //
        Customer customer = new Customer("bestcustomer@thebestcustomer.com");
        Salesman salesman = new Salesman(customer);

        Function<Customer, String> customerToEmailAddress
                = Customer::getEmailAddress;
        Function<Salesman, Customer> salesmanToBestCustomer
                = Salesman::getBestCustomer;
        Function<Salesman, String> toEmailAddress
                = salesmanToBestCustomer.andThen(customerToEmailAddress);
        
        System.out.println(toEmailAddress.apply(salesman));
        System.out.println(salesman.getBestCustomer().getEmailAddress());
        
        Function<Manager, String> managerToEmailAddress
                = Manager::getEmailAddress;
        Function<Salesman, Manager> salesmanToManager
                = Salesman::getManager;
        Function<Salesman, String> toManagerEmailAddress
                = salesmanToManager.andThen(managerToEmailAddress);
        
        Manager manager = new Manager("manager@thecompany.com");
        Salesman salesman2 = new Salesman(manager);
        
        System.out.println(toManagerEmailAddress.apply(salesman2));
        System.out.println(salesman2.getManager().getEmailAddress());
        
        processEmailAddress(salesman,toEmailAddress);
        processEmailAddress(salesman2,toManagerEmailAddress);
    }
    
    private static void processEmailAddress(
            Salesman salesman,
            Function<Salesman, String> toEmailAddress) {
        System.out.println(toEmailAddress.apply(salesman));        
    }

    private static void demonstration() {
        System.out.println("------- deomonstration ------");
        Function<Integer, Integer> baseFunction = t -> {
            t = t + 2;
            System.out.println("baseFunction: " + t);
            return t;
        };

        System.out.println(baseFunction.apply(5));

        Function<Integer, Integer> afterFunction = baseFunction.andThen(t -> {
            t = t * 3;
            System.out.println("afterFunction: " + t);
            return t;
        });
        System.out.println(afterFunction.apply(5));

        Function<Integer, Integer> beforeFunction = (t -> {
            t = t * 2;
            System.out.println("beforeFunction: " + t);
            return t;
        });
        System.out.println(beforeFunction.apply(5));

        System.out.println("-- and then ----");
        System.out.println(afterFunction.compose(beforeFunction).apply(5));
        // This does it in the wrong order
        System.out.println(beforeFunction.compose(afterFunction).apply(5));
    }

    private static void methodCascadingAndFluentExamples() {
        bindingFluentExample();
        fluentInterfacesInJava8();
        stringClassChainingExample();
        fluentBoatExample();
        connectionPropertiesExample();
        fluentRandonNumberGeneratorExample();
        extendingAFluentInterface();
    }

    private static void bindingFluentExample() {
        IntegerProperty n1 = new SimpleIntegerProperty(5);
        IntegerProperty n2 = new SimpleIntegerProperty(2);
        IntegerProperty n3 = new SimpleIntegerProperty(3);
        NumberBinding sum = n1.add(n2).multiply(n3);
        System.out.println(sum.getValue());
        n1.set(2);
        System.out.println(sum.getValue());
    }

    private static void fluentInterfacesInJava8() {
        // Stream example
        int hoursWorked[] = {8, 12, 8, 6, 6, 5, 6, 0};
        int totalHoursWorked = Arrays.stream(hoursWorked).filter(n -> n > 6).sum();
        System.out.println(totalHoursWorked);

        // Date and time example
        LocalDateTime timeInstance = LocalDateTime.now()
                .plusDays(3)
                .minusHours(4)
                .plusWeeks(1)
                .plusYears(2);
        System.out.println(timeInstance);
        
        // Needed ?????????????????????????????????????????????????????????
        Map<String,String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        map.put("c", "C");
        String word = "cat";
        String result = map.computeIfAbsent(word, x->x).concat("s").toUpperCase();
        System.out.println(result);
    }

    private static void stringClassChainingExample() {
        String animal = "Cat";
        System.out.println(animal.concat("Dog").toLowerCase());
        System.out.println(animal.concat("Dog").toLowerCase().length());

        String concat = animal.concat("Dog");
        String lower = concat.toLowerCase();
        int length = lower.length();
        System.out.println(lower);
        System.out.println(length);
    }

    private static void fluentBoatExample() {
        Boat boat = new Boat();
        boat.setName("Albatross");
        boat.setCountry("Panama");
        boat.setTonnage(12000);
        boat.setDraft(25);

        boat.setName("Albatross")
                .setCountry("Panama")
                .setTonnage(12000)
                .setDraft(25);

        boat.named("Albatross")
                .country("Panama")
                .tonnage(12000)
                .draft(25);

        System.out.println(boat);

        Properties properties = new Properties();
        properties.setProperty("name", "Albatross");
        properties.setProperty("country", "Panama");
        properties.setProperty("tonnage", "1500");
        properties.setProperty("draft", "35");

        properties = boat.getProperties();
        System.out.println(properties);

        // Port example
        Port port = new Port();
        Boat newBoat = port.add("Cloud");

        boat.named("Albatross")
                .country("Panama")
                .tonnage(12000)
                .draft(25);
        port.add(boat);

        port.add(new Boat() {
            {
                named("Albatross");
                country("Panama");
                tonnage(1500);
                draft(35);
            }
        });

        port.add(new Boat() {
            {
                this.named("Albatross");
                this.country("Panama");
                this.tonnage(1500);
                this.draft(35);
            }
        });
        System.out.println(boat);
    }

    private static void connectionPropertiesExample() {
        ConnectionProperties cp = new ConnectionProperties();
        cp.user("user").password("password");
        cp.properties();
    }

    private static void fluentRandonNumberGeneratorExample() {
        FluentRandom fr = new FluentRandom();
        for (int i = 0; i < 5; i++) {
            System.out.println(fr.nextInt());
        }

        fr = new FluentRandom()
                .asLower(5)
                .asUpper(25)
                .useAsSeed(35);
        for (int i = 0; i < 5; i++) {
            System.out.println(fr.nextInt());
        }
    }

    private static void extendingAFluentInterface() {
        // Sailboat
        SailBoat sailBoat = new SailBoat()
                .named("Endeavour")
                .country("United Kingdom")
                .sails(3)
                .tonnage(15)
                .hulls(2);
        System.out.println(sailBoat);

        sailBoat = new SailBoat()
                .tonnage(15)
                .hulls(2)
                .tonnage(15)
                .country("United Kingdom")
                .named("Endeavour")
                .sails(3);
        System.out.println(sailBoat);
    }
    
    private static void defaultMethodExamples() {
        List<String> list = Arrays.asList(
                "Io", "Europa", "Ganymede", "Callisto");
        list.forEach(s->System.out.println(s + " "));
    }
}
