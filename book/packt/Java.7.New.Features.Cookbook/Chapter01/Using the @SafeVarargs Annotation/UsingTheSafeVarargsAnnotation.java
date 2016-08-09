package packt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsingTheSafeVarargsAnnotation {

    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(new Integer(1));
        a1.add(2);
        ArrayList<Float> a2 = new ArrayList<>();
        a2.add(new Float(3.0));
        a2.add(new Float(4.0));
        displayElements(a1, a2, 12);

        //There's More: An example of heap pollution
//        List<String> list1 = new ArrayList<>();
//        list1.add("One");
//        list1.add("Two");
//        list1.add("Three");
//        List<String> list2 = new ArrayList<>();
//        list2.add("Four");
//        list2.add("Five");
//        list2.add("Six");
//
//        merge(list1, list2);

    }

    @SafeVarargs
    public static <T> void displayElements(T... array) {
        for (T element : array) {
            System.out.println(element.getClass().getName() + ": " + element);
        }
    }

//    @SafeVarargs // Not actually safe!
//    static void merge(List<String>... stringLists) {
//        Object[] array = stringLists;
//        List<Integer> tmpList = Arrays.asList(42);
//        array[0] = tmpList; // Semantically invalid, but compiles without warnings
//        String element = stringLists[0].get(0); // runtime  ClassCastException
//    }
}
