package packt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

//public abstract class Employee {
public class Employee {
    // instance variables
    private String name;
    private int zip;
//    private int age;
    protected int age;
    private float pay;

//    public abstract float computePay();
    
    public float getPay() {
        return pay;
    }

    public void setPay(float pay) {
        this.pay = pay;
    }
    

    public float computePay() {
        return pay;
    }
     
    public final int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
    
   public Employee() {
       this("Default name", 12345, 21);
   }

   public Employee(String name) {
       this(name, 12345, 21);
   }

   public Employee(String name, int zip) {
       this(name, zip, 21);
   }


   public Employee(String name, int age, int zip) {
       this.name = name;
       this.zip = zip;
       this.age = age;
       this.pay = 500.0f;
   }

   @Override
   public String toString() {
       return "Name: " + this.name +
              "  Age: " + this.age;
   }
   
}