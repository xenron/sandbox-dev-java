package packt;

import static java.lang.System.out;
import java.sql.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter9Examples {

    public static void main(String[] args) {
//        staticImportExample();
//        garbageCollectionExample();
//        localeExamples();
//        resourceBundleExample();
        jdbcExamples();
//        questionExamples();
    }

    private static void questionExamples() {
        String s = "Java";
        String s2 = "java";
        if (s == s2) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }

        int i;
        int j;
        for (i = 1; i < 4; i++) {
            for (j = 2; j < 4; j++) {
                if (j == 3) {
                    continue;
                }
                System.out.println("i: " + i + " j: " + j);
            }
        }

        switch (1) {
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("one");
            default:
                System.out.println("default");
            case 2:
                System.out.println("two");
        }

        int arr[] = {1, 2, 3, 4, 5};

        for (int n : arr) {
            System.out.println(n);
        }

        i = 5;
        j = 10;

//        while ((i = 12) != 5) {
//        }

        i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i < 5);

//        int k = 6;
//        if(i>j) {}
//        if(i>j>k) {}
//        if(i>j && i>k) {}
//        if(i>j && >k) {}

        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.add("frog");

        for (String n : list) {
            System.out.println(n);
        }
        for (int n = 0; n < list.size(); n++) {
            System.out.println(list.get(n));
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println(list.contains("cat"));
        System.out.println(list.indexOf("cat"));

        s = "string 1";
        i = 5;
        someMethod1(i);
        System.out.println(i);
        someMethod2(s);
        System.out.println(s);


        s = "Hello";
        if (s instanceof String) {
            System.out.println("is a String");
        }

        int num1 = 5;
        float num2 = 2.3f;
        num1 = (int) num2;


    }

    public static void someMethod1(int i) {
        System.out.println(++i);
    }

    public static void someMethod2(String s) {
        s = "string 2";
        System.out.println(s);
    }
//    public int[] someMethod(int i, float f) { return new int[i];}

    private class xyz {
    }

    private static void jdbcExamples() {

        // The commented code is not needed for JDBC 4.0 drivers
//        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//        } catch (InstantiationException |
//                IllegalAccessException |
//                ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        try (Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/", "root", "explore");
                Statement statement = connection.createStatement()) {
            String query = "select first_name, last_name"
                    + " from sakila.customer "
                    + "where address_id < 10";
            try (ResultSet resultset = statement.executeQuery(query)) {
                while (resultset.next()) {
                    String firstName = resultset.getString("first_name");
                    String lastName = resultset.getString("last_name");
                    System.out.println(firstName + " " + lastName);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try (Connection connection = DriverManager.getConnection(
//                        "jdbc:mysql://localhost:3306/", "root", "explore")) {
//            try (Statement statement = connection.createStatement()) {
//                String query = "select first_name, last_name"
//                        + " from sakila.customer "
//                        + "where address_id < 10";
//                ResultSet resultset = statement.executeQuery(query);
//                while (resultset.next()) {
//                    String firstName = resultset.getString("first_name");
//                    String lastName = resultset.getString("last_name");
//                    System.out.println(firstName + " " + lastName);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    private static void resourceBundleExample() {
        ResourceBundle bundle = ResourceBundle.getBundle("ResourceExamples");

        System.out.println("UNKNOWN" + ":" + bundle.getString("UNKNOWN"));

        System.out.println("Default");
        Enumeration keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            System.out.println(key + ":" + bundle.getString(key));
        }
        System.out.println();

        bundle = ResourceBundle.getBundle("ResourceExamples",
                new Locale("en_US"));

        System.out.println("en_US");
        keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            System.out.println(key + ":" + bundle.getString(key));
        }
        System.out.println();
//        String list[] = bundle.getStringArray("FILE_NOT_FOUND");
//        System.out.println(list.length);
//        System.out.println(list[0]);
        bundle = ResourceBundle.getBundle("ResourceExamples",
                new Locale("en"));
        System.out.println("en");
        keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            System.out.println(key + ":" + bundle.getString(key));
        }
        System.out.println();

        System.out.println("en - Using getString");
        System.out.println(bundle.getString("WINDOW_CAPTION"));
        System.out.println(bundle.getString("FILE_NOT_FOUND"));
        System.out.println(bundle.getString("FILE_EXISTS"));
        System.out.println(bundle.getString("UNKNOWN"));
        System.out.println();

        bundle = ResourceBundle.getBundle("ResourceExamples",
                new Locale("sp"));
        System.out.println("sp - Using getString");
        System.out.println(bundle.getString("WINDOW_CAPTION"));
        System.out.println(bundle.getString("FILE_NOT_FOUND"));
        System.out.println(bundle.getString("FILE_EXISTS"));
        System.out.println(bundle.getString("UNKNOWN"));
        System.out.println();

        System.out.println("ListResource");
        ListResource listResource = new ListResource();
        System.out.println(listResource.getString("FILE_NOT_FOUND"));
        System.out.println(listResource.getString("FILE_EXISTS"));
        System.out.println(listResource.getString("UNKNOWN"));
        ArrayList<String> salutations = (ArrayList) listResource.getObject("PREFIXES");
        for (String salutation : salutations) {
            System.out.println(salutation);
        }
    }

    private static void localeExamples() {
        Locale locale;

        locale = Locale.GERMANY;
//        locale = Locale.US;
        System.out.println(locale);

//        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println(currencyFormatter.format(23.45));

        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
        System.out.println(dateFormatter.format(new Date()));
        dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
        System.out.println(dateFormatter.format(new Date()));
    }

    private static void garbageCollectionExample() {
        String s1 = new String("A string object");
        String s2 = s1;

        s1 = null;
        s2 = null;
    }

    private static void staticImportExample() {
        System.out.println("Employee Information");
        System.out.println("Name: ");
        System.out.println("Department: ");
        System.out.println("Pay grade: ");

        out.println("Employee Information");
        out.println("Name: ");
        out.println("Department: ");
        out.println("Pay grade: ");
    }
}
