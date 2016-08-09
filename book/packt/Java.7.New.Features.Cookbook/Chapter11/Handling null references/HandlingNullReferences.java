package packt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class HandlingNullReferences {

    public static void main(String[] args) {
        Item item1 = new Item("Eraser", 2200);
        Item item2 = new Item("Eraser", 2200);
        Item item3 = new Item("Pencil", 1100);
        Item item4 = null;

        System.out.println("item1 equals item1: " + item1.equals(item1));
        System.out.println("item1 equals item2: " + item1.equals(item2));
        System.out.println("item1 equals item3: " + item1.equals(item3));
        System.out.println("item1 equals item4: " + item1.equals(item4));
 
        item2.setName(null);
        System.out.println("item1 equals item2: " + item1.equals(item2));

        // Additional Objects class methods
//        item4 = null;
//        System.out.println("toString: " + Objects.toString(item4));
//        System.out.println("toString: " + Objects.toString(item4,"Item is null"));
        
        // Using empty iterators to avoid null pointer exceptions
//        ListIterator<String> list = returnEmptyListIterator();
//        while(list.hasNext()) {
//            String item = list.next();
//            System.out.println(item);
        }

    
    // Using empty iterators to avoid null pointer exceptions
    public static ListIterator<String> returnEmptyListIterator() {
        boolean someConditionMet = false;
        if(someConditionMet) {
            ArrayList<String> list = new ArrayList<>();
 				// Add elements
            ListIterator<String> listIterator = list.listIterator();
            return listIterator;
        } else {
            return Collections.emptyListIterator();
        }
    }
    
}
