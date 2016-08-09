package packt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Chapter5Examples {

    public static void main(String[] args) {
//        forLoopExamples();
//        theCommaOperator();
//        forLoopVariations();
//        forEachLoopArraysExample();
//        forEachLoopCollectionExample();
//        forEachUsageIssues();

        // Variable number of arguments example
//        int result;
//        Chapter5Examples example = new Chapter5Examples();
//        result = example.total(1, 2, 3, 4, 5);
//        System.out.println(result);
//        result = example.total();
//        System.out.println(result);
////        result = c.total(null);
//        System.out.println(result);

//        whileLoopExamples();
//        doWhileLoopExamples();
//        breakStatementExample();
//        continueStatementExample();
//        nestedLoopExample();
//        infiniteLoopExample();
//        pitfallExamples();
//        summationExample();
    }

    private static void summationExample() {
        final int size = 5;
        int age[] = new int[size];
        int total;
        float average;

        age[0] = 23;
        age[1] = 18;
        age[2] = 19;
        age[3] = 18;
        age[4] = 21;

        total = 0;
        for (int number : age) {
            total = total + number;
        }
        average = total / (age.length * 1.0f);
        System.out.println("The average is " + average);
    }

    private static void pitfallExamples() {
        float x = 0.1f;
//        while (x != 1.1) {
        while (x <= 1.009) {            
            System.out.printf("x = %f%n", x);
            x = x + 0.1f;
        }
        System.out.printf("x = %f%n", x);

        int sum = 0;
        int product = 0;
        for(int i = 1; i <= 5; i++) //{
            product = i * i;;
            sum += product;
//        }
        System.out.println(sum);
    }

    private static void infiniteLoopExample() {
        int age;
        age = 1;
        Scanner scanner = new Scanner(System.in);
        while (age > 0) {
            System.out.print("Enter an age: ");
            age = scanner.nextInt();
            // use the age
        }


        System.out.print("Enter an age: ");
        age = scanner.nextInt();
        while (age > 0) {
            System.out.print("Enter an age: ");
            age = scanner.nextInt();
            // use the age
        }

        while (true) {
            System.out.print("Enter an age: ");
            age = scanner.nextInt();
            if (age < 0) {
                break;
            }
            // use the age
        }

    }

    private static void nestedLoopExample() {
        final int numberOfRows = 2;
        final int numberOfColumns = 3;
        int matrix[][] = new int[numberOfRows][numberOfColumns];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i + j;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int element : matrix[i]) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int element : matrix[i]) {
                sum += element;
            }
            System.out.println("Sum of row " + i + " is " + sum);
        }

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int element : matrix[i]) {
                sum += element;
                if (sum > 2) {
                    break;
                }
            }
            System.out.println("Sum of row " + i + " is " + sum);
        }

        outerLoop:
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int element : matrix[i]) {
                sum += element;
                if (i > 0) {
                    break outerLoop;
                }
            }
            System.out.println("Sum of row " + i + " is " + sum);
        }
    }

    private static void breakStatementExample() {
        String command;
        while (true) {
            System.out.print("Enter a command: ");
            Scanner scanner = new Scanner(System.in);
            command = scanner.next();
            if ("Add".equals(command)) {
                // Process Add command
            } else if ("Subtract".equals(command)) {
                // Process Subtract command
            } else if ("Quit".equals(command)) {
                break;
            } else {
                System.out.println("Invalid Command");
            }
        }

    }

    private static void continueStatementExample() {
        int i = 0;
        int j = 0;

//        while (i < j) {
//            //…
//            if (i < 0) {
//                continue;
//            }
//            //…
//        }
//
//        while (i < j) {
//            // …
//            if (i < 0) {
//                ;
//            } else {
//                // …
//            }
//        }

        System.out.println("Before the loop");
        outerOuterLabel:
        while (i < 10) {
            i++;
            System.out.println(i);
            outerLabel:
            for (int k = 0; k < 10; k++) {
                if (i == 4) {
                    System.out.println("Going to outerLabel");
                    break outerLabel;
                }
                if (i == 6) {
                    System.out.println("Going to outerOuterLabel");
                    break outerLabel;
                }
            }
        }
    }

    private static void doWhileLoopExamples() {
        int number;
        int sum = 0;

        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        while (number > 0) {
            sum += number;
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
        }
        System.out.println("The sum is " + sum);

//        Scanner scanner = new Scanner(System.in);
        sum = 0;
        do {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
            if (number > 0) {
                sum += number;
            }
        } while (number > 0);
        System.out.println("The sum is " + sum);

        int numOfDigits;
        System.out.print("Enter a number: ");
        number = scanner.nextInt();
        numOfDigits = 0;
        do {
            number /= 10;
            numOfDigits++;
        } while (number != 0);

        System.out.printf("Number of digits: %d%n", numOfDigits);

    }

    private static void whileLoopExamples() {
        int i = 1;
        while (i <= 10) {
            System.out.print(i++ + " ");
        }
        System.out.println();

        int number;
        int divisor = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        number = scanner.nextInt();
        while (number >= divisor) {
            if ((number % divisor) == 0) {
                System.out.printf("%d%n", divisor);
            }
            divisor++;
        }

        int sum = 0;

        System.out.print("Enter a number: ");
        number = scanner.nextInt();
        while (number > 0) {
            sum += number;
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
        }
        System.out.println("The sum is " + sum);


    }

    public int total(int... array) {
        int sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum;
    }

    private static void forEachUsageIssues() {
        // For-each statement usage issues
        String names[] = new String[5];

        names[0] = "Will Turner";
        names[1] = "Captain Jack Sparrow";
        names[3] = "Barbossa";
        names[4] = "Elizabeth Swann";

        for (String name : names) {
            System.out.println(name);
        }

        // Generates null pointer exception
//        for (String name : names) {
//            System.out.println(name.toString());
//        }

    }

    private static void forEachLoopCollectionExample() {
        ArrayList<String> list = new ArrayList<String>();

        list.add("Lions and");
        list.add("tigers and");
        list.add("bears.");
        list.add("Oh My!");

        for (String word : list) {
            System.out.print(word + " ");
        }
        System.out.println();


        for (String word : list) {
            if (word.equals("bears.")) {
                word = "kitty cats";
//                list.add("kitty cats");
//                list.remove(word);
//                System.out.println(word + " removed");
            }
        }

        for (String word : list) {
            System.out.print(word + " ");
        }
        System.out.println();



        MyIterable iterable = new MyIterable();

        for (Integer number : iterable) {
            System.out.print(number + " ");
        }
        System.out.println();


//        iterable = new MyIterable();
//        
//        for(Object number : iteratable) {
//            if(number == 5) {
//                iteratable.iterator().remove();
//            }
//        }
//        System.out.println();

//        System.out.println("Iterator");
//        iterable = new MyIterable();
//        Iterator iterator = iteratable.iterator();
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }

    private static void forEachLoopArraysExample() {
        int numbers[] = new int[10];

        for (int i = 0; i < 10; i++) {
            numbers[i] = i;
        }

        for (int element : numbers) {
            if (element == 5) {
                element = -5;
            }
        }
        numbers[5] = -5;
        for (int element : numbers) {
            System.out.print(element + " ");
        }
        System.out.println();

        int source[] = new int[5];
        int destination[] = new int[5];

        for (int number : source) {
            number = 100;
        }

        for (int i = 0; i < 5; i++) {
            destination[i] = source[i];
        }

    }

    private static void forLoopExamples() {
        // For statement
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

        for (int i = 1; i <= 64; i++) {
            System.out.println(i + " squared is = " + i * i);
        }
        for (int i = 10; i > 0; i--) {
            System.out.print(i + "  ");
        }
        System.out.println();

        // For statement and scope
        int i;
        for (i = 1; i <= 10; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        System.out.println(i);

        int sum = 0;
        for (i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    private static void forLoopVariations() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        for (int i = 0; number >= 0; i++) {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
            System.out.printf("%d%n", number);
        }

        int i = 0;
        for (; i < 5;) {
            i++;
        }
        System.out.print(i);

        // Infinite loop
//        for (;; i++)
// 	      ;

        // Infinite loop
//        for (;;) ;


    }

    private static void theCommaOperator() {
        // The comma operator
        for (int i = 0, j = 10; j > 5; i++, j--) {
            System.out.printf("%3d  %3d%n", i, j);
        }

        for (int i = 0, j = 10; j > 5 && i < 3; i++, j--) {
            System.out.printf("%3d  %3d%n", i, j);
        }

    }
}
