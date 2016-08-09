package packt;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Employee {
    // static variables
    private static int minimumAge;

    // instance variables
    private String name;
    private int zip;
    private int age;
    private Employee instance = null;

    public static int getMinimumAge() {
        return minimumAge;
    }

    public static void setMinimumAge(int minimumAge) {
        Employee.minimumAge = minimumAge;
    }

    public int getAge() {
        return age;
    }

//    public void setAge(final int age) {
//        age = age;
//    }
//   public Employee() {
//       this("Default name", 12345, 21);
//   }
//
//   public Employee(String name) {
//       this(name, 12345, 21);
//   }
//
//   public Employee(String name, int zip) {
//       this(name, zip, 21);
//   }
//
//
//   public Employee(String name, int zip, int age) {
//       this.name = name;
//       this.zip = zip;
//       this.age = age;
//   }
    public Employee() {
        this.name = "Default name";
        this.zip = 12345;
        this.age = 21;
    }

    public Employee(String name) {
        this.name = name;
        this.zip = 12345;
        this.age = 21;
    }

    public Employee(String name, int zip) {
        this.name = name;
        this.zip = zip;
        this.age = 21;
    }

    public Employee(String name, int zip, int age) {
        this.name = name;
        this.zip = zip;
        this.age = age;
    }

    private Date getDefaultDate() {
        Date date = null;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = df.parse("01/01/2000");

            //this.dob = new Date();
        } catch (ParseException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }

    public Employee getInstance() {
        if (instance == null) {
            instance = new Employee();
        }
        return instance;
    }
}
