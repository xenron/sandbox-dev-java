package packt;

import java.beans.Expression;

public class JavaBeanExample {
    
    public static void main(String args[]) {
        Person person = new Person();
        String arguments[] = {"Peter"};
        Expression expression = new Expression(null, person, "setName", arguments);
        
        try {
            System.out.println("Name: " + person.getName());
            expression.execute();
            System.out.println("Name: " + person.getName());
            
            System.out.println();
            expression = new Expression(null, person, "getName", null);
            System.out.println("Name: " + person.getName());
            expression.execute();
            System.out.println("getValue: " + expression.getValue());            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}

