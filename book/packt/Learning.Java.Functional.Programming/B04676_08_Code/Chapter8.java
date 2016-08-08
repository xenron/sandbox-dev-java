package packt;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Chapter8 {

    public static void main(String[] args) {
        debuggingExamples();
//        testingExamples();
//        recursionExample();
    }

    private static void refactoringExamples() {
        // Before conversion
        List<String> list = Arrays.asList("Huey", "Dewey", "Louie");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.println(t);
            }
        });

        //After conversionn to lambda expressions
        list.forEach((Object t) -> {
            System.out.println(t);
        });

        list.forEach((t) -> {
            System.out.println(t);
        });

        list.forEach((String t) -> {
            System.out.println(t);
        });

        //After conversionn to method reference
        list.forEach(System.out::println);

        Button button = new Button("Ok");
        // Before conversion
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Ok button clicked.");
            }
        });

        //After conversion
        button.setOnAction((ActionEvent e) -> {
            System.out.println("Ok button clicked.");
        });

    }

    private static String toLower(String token) {
        String lowerCase;
        lowerCase = token + "-" + token.toLowerCase();
        System.out.println("Thread: " + Thread.currentThread()
                + " token: " + token);
        return lowerCase;
    }

    private static void debuggingExamples() {
        List<String> list = Arrays.asList("Huey", "Dewey", "Louie");

        // Old School
        System.out.println("Old School");
        list.stream()
                .map(s -> {
                    System.out.println("Before: " + s);
                    s += "-" + s.toLowerCase();
                    System.out.println("After: " + s);
                    return s;
                })
                .forEach(s -> System.out.println(s));

        // Using the peek method
        System.out.println("Using the peek method");
        list.stream()
                .peek(s -> System.out.println("First peek-" + s))
                .map(s -> s + "-" + s.toLowerCase())
                .peek(s -> System.out.println(
                                "Second peek-" + s + ":" + s.length()))
                .forEach(s -> System.out.println(s));

        // Using the debugger
        System.out.println("Using the debugger");
        list.stream()
                .map(s -> s + "-" + s.toLowerCase())
                .forEach(s -> System.out.println(s));

        list.stream()
                .map(Chapter8::toLower)
                .forEach(s -> System.out.println(s));

        list.stream().map(s -> s + "-" + s.toLowerCase()).forEach(s -> System.out.println(s));

        System.out.println("Using a parallel stream");
        list.parallelStream()
                .map(Chapter8::toLower)
                .forEach(s -> System.out.println(s));

    }

    private static void testingExamples() {
        IntStream stream = IntStream.of(3, 15, 16, 12, 3);
        int result;
        result = stream
                .map(n -> {
                    if (n % 2 == 0) {
                        return n * 2;
                    } else {
                        return n * n;
                    }
                })
                .sum();

        System.out.println(result);
    }

    static Consumer<Node> inorder; // Instance variable

    private static void recursionExample() {

        System.out.println();
        inorder = (Node node) -> {
            if (node == null) {
                return;
            } else {
                inorder.accept(node.left());
                System.out.print(node.getValue() + " ");
                inorder.accept(node.right());
            }
        };
        Node root = new Node(12);
        root.addLeft(8).addRight(9);
        root.addRight(18).addLeft(14).addRight(17);
        inorder.accept(root);

        System.out.println();
    }
}
