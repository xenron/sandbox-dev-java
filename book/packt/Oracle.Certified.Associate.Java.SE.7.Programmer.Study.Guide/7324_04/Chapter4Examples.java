package packt;

import java.util.*;

public class Chapter4Examples {

    private static final int SIZE = 5;
    private static final int DIFFERENT_SIZE = 12;
    private static final int ROWS = 2;
    private static final int COLS = 3;

    public static void main(String[] args) {
//        initialStuff();
//        initializingArrayExamples();
//        arrayOfObjectsExamples();
//        multiDimensionalArrayExamples();

        // Comparing arrays
//        int arr1[];
//        int arr2[];
//        arr1 = new int[5];
//        arr2 = new int[5];
//
//        for (int i = 0; i < 5; i++) {
//            arr1[i] = 0;
//            arr2[i] = 0;
//        }
//
//        // Element-by-element comparison
//        boolean areEqual = true;
//
//        int i;
//        for (i = 0; i < 5; i++) {
//            if (arr1[i] != arr2[i]) {
//                areEqual = false;
//            }
//        }
//        System.out.println(areEqual);
//
//        // Using the equality operator
////        boolean areEqual = true;
//        for (i = 0; i < 5; i++) {
//            if (arr1[i] != arr2[i]) {
//                areEqual = false;
//            }
//        }
//        System.out.println(areEqual);
//
//        // Using the equality operator
//        System.out.println(arr1 == arr2);
//
//        // Using the equals method
//        System.out.println(arr1.equals(arr2));
//
//        // Using the deepEquals method
//        System.out.println(Arrays.equals(arr1, arr2));
//
//        int grades[][] = new int[ROWS][COLS];
//
//        grades[0][0] = 0;
//        grades[0][1] = 1;
//        grades[0][2] = 2;
//        grades[1][0] = 3;
//        grades[1][1] = 4;
//        grades[1][2] = 5;
//
//        int grades2[][];
//        grades2 = new int[ROWS][];
//        grades2[0] = new int[COLS];
//        grades2[1] = new int[COLS];
//
//        grades2[0][0] = 0;
//        grades2[0][1] = 1;
//        grades2[0][2] = 2;
//        grades2[1][0] = 3;
//        grades2[1][1] = 4;
//        grades2[1][2] = 5;
//
//
//        System.out.println(grades == grades2);
//        System.out.println(grades.equals(grades2));
//        System.out.println(Arrays.equals(grades, grades2));
//        System.out.println(Arrays.deepEquals(grades, grades2));

//        copyArraysExample();
//        arraysClassExamples();
//        arrayListExamples();
    }

    private static void initialStuff() {
        // One dimension arrays
//        int ages[];
//	ages = new int[5];

        int[] ages = new int[5];

        ages[0] = 35;
        System.out.println(ages[0]);

        int length = ages.length;
        System.out.println(length);

        // The placement of array brackets
//        ages = new [5]int;
//        [0]ages = 0;
    }

    private static void initializingArrayExamples() {
        // Initializing arrays
//        int ages[5] = {35, 10, 43, -5, 12};

//        int ages[] = {35, 10, 43, -5, 12};
//        System.out.println(ages.toString());
//
//        for (int i = 0; i < ages.length; i++) {
//            System.out.println(ages[i]);
//        }

        int ages[] = new int[SIZE];
        // initialize ages as needed

        for (int i = 0; i < ages.length; i++) {
            System.out.println(ages[i]);
        }

    }

    private static void arrayOfObjectsExamples() {
        String names[] = new String[5];
        names[2] = new String("Steve");

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }

    private static void multiDimensionalArrayExamples() {
        int grades[][] = new int[ROWS][COLS];

        grades[0][0] = 0;
        grades[0][1] = 1;
        grades[0][2] = 2;
        grades[1][0] = 3;
        grades[1][1] = 4;
        grades[1][2] = 5;

        for (int rows = 0; rows < ROWS; rows++) {
            for (int cols = 0; cols < COLS; cols++) {
                System.out.printf("%d  ", grades[rows][cols]);
            }
            System.out.println();
        }

        grades = new int[ROWS][];
        grades[0] = new int[COLS];
        grades[1] = new int[COLS];

        grades[0] = new int[4];
        grades[1] = new int[2];

    }

    private static void traversingArraysExamples() {

        int[] ages = new int[SIZE];

        // Using simple for loops
        for (int i = 0; i < ages.length; i++) {
            ages[i] = 5;
        }

//        int i=0;
//        while(i<ages.length) {
//            ages[i++] = 5;
//        }      

        ages = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            ages[i] = 5;
        }

        // Array redefined
        ages = new int[DIFFERENT_SIZE];
//			...
        for (int i = 0; i < SIZE; i++) {
            ages[i] = 5;
        }

        // Using the for each statement
        for (int number : ages) {
            number = 5;
        }
    }


    private static void arrayListExamples() {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList(20);

//        int arr1[] = new int[5];
//        Arrays.fill(arr1,5);
//        ArrayList list3 = new ArrayList(arr1);

        ArrayList<String> creatures = new ArrayList<String>();
        creatures.add("Mutant");
        creatures.add("Alien");
        creatures.add("Zombie");
        System.out.println(creatures);

        creatures.add(1, "Godzilla");
        System.out.println(creatures);

        ArrayList<String> cuddles = new ArrayList<String>();
        cuddles.add("Tribbles");
        cuddles.add("Ewoks");

        creatures.addAll(2, cuddles);
        System.out.println(creatures);

        String element = creatures.get(2);
        System.out.println(element);
        System.out.println(creatures.indexOf("Tribbles"));
        System.out.println(creatures.indexOf("King Kong"));

        String[] complete = new String[0];
        complete = creatures.toArray(complete);
        for (String item : complete) {
            System.out.print(item + " ");
        }
        System.out.println();

        for (String creature : creatures) {
            System.out.print(creature + " ");
        }
        System.out.println();

        for (int i = 0; i < creatures.size(); i++) {
            System.out.print(creatures.get(i) + " ");
        }
        System.out.println();

        Iterator<String> iterator = creatures.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        ListIterator<String> listIterator = creatures.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();

        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println(creatures);
        creatures.remove(0);
        System.out.println(creatures);

        creatures.remove("Alien");
        System.out.println(creatures);

        creatures.removeAll(cuddles);
        System.out.println(creatures);

        creatures.clear();
        System.out.println(creatures);

//        creatures.set(0,"Ghoul");
//        System.out.println(creatures);
//        
//        Collections.sort(creatures);
//        System.out.println(creatures);
    }

    private static void arraysClassExamples() {
        int arr1[] = new int[5];
        ArrayList list = new ArrayList();
        list.add("item 1");
        list.add("item 2");
        Object arr2[] = {"item 3", new Integer(5), list};
        String arr3[] = {"Pine", "Oak", "Maple", "Walnut"};

        Arrays.fill(arr1, 5);

        System.out.println(Arrays.asList(arr3));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.deepToString(arr2));



        List list2 = Arrays.asList(arr3);
        arr3[0] = "Birch";
        System.out.println(Arrays.toString(arr3));

    }

    private static void copyArraysExample() {
        int arr1[] = new int[5];
        int arr2[] = new int[5];

        // Initialize arr1 elements to their index
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i;
        }

        // Simple array copy
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }

        System.arraycopy(arr1, 0, arr2, 0, 5);

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = 0;
        }
        System.arraycopy(arr1, 0, arr2, 2, 3);
        displayArray(arr2);

        StringBuilder arr3[] = new StringBuilder[4];
        arr3[0] = new StringBuilder("Pine");
        arr3[1] = new StringBuilder("Oak");
        arr3[2] = new StringBuilder("Maple");
        arr3[3] = new StringBuilder("Walnut");

        StringBuilder arr4[] = new StringBuilder[4];
        System.arraycopy(arr3, 0, arr4, 0, 4);

        for (int i = 0; i < arr3.length; i++) {
            arr4[i] = new StringBuilder(arr3[i]);
        }

//        System.arraycopy(arr1, 0, arr1, 3, 2);
//        displayArray(arr1);

        arr2 = Arrays.copyOf(arr1, 10);
        displayArray(arr2);

        arr2 = Arrays.copyOfRange(arr1, 3, 8);
        displayArray(arr2);

        arr2 = arr1.clone();
        displayArray(arr2);

        System.out.println("Length of arr2: " + arr2.length);
        changeArray(arr2);
        System.out.println("Length of arr2: " + arr2.length);
    }

    private static void changeArray(int arr[]) {
        arr = new int[100];
        System.out.println("Length of arr: " + arr.length);
    }

    private static void displayArray(int arr[]) {
        for (int number : arr) {
            System.out.print(number + "  ");
        }
        System.out.println();
    }

    private static void zeroOutArray(int arr[]) {
        for (int number : arr) {
            number = 0;
        }
    }
}
