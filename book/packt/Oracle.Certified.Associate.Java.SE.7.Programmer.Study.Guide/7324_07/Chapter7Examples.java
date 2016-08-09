package packt;

public class Chapter7Examples {

    public static void main(String[] args) {
        //Employee employee1 = new Employee();
        Employee employee1 = new SalaryEmployee();
        SalaryEmployee employee2 = new SalaryEmployee();
        HourlyEmployee employee3 = new HourlyEmployee();

        employee1.setAge(25);
        employee1.setPay(500.00f);
        employee2.setAge(35);
        employee2.setStock(45);

        System.out.println("Employee1 age: " + employee1.getAge());
        System.out.println("Employee2 age: " + employee2.getAge());

//         employee2.age = 35;

        System.out.println("Employee1 pay: " + employee1.computePay());
        System.out.println("Employee3 pay: " + employee3.computePay());

        
        //employee1 = new Employee();
        employee1 = new SalaryEmployee();
        employee2 = new SalaryEmployee();
        employee1 = employee2;

        superExamples();
//        classTypeExamples();
//        castingExamples();
    }
    
    private static void polymorphicExamples() {
        Employee employees[] = new Employee[10];
        float sum = 0;
        
        employees[0] = new Employee();
        employees[0] = new SalaryEmployee();
        employees[0] = new HourlyEmployee();
        // ...
        
        for(Employee employee : employees) {
            sum += employee.computePay();
        }
        
    }
    
    private static void superExamples() {
        Employee employee1 = new Employee("Paula", 23, 12345);
        SalaryEmployee employee2 = new SalaryEmployee("Phillip", 31, 54321, 32);
        
        System.out.println(employee1);
        System.out.println(employee2);
        employee2.display();
        
//        super.super.toString();	// illegal
    }
    
    private static void castingExamples() {
        Employee employee1 = new Employee();
        SalaryEmployee employee2 = new SalaryEmployee();
        
        employee1 = new SalaryEmployee();
//        employee2 = new Employee(); // Syntax error
//        employee2 = (SalaryEmployee) new Employee(); // Runtime exception
//        employee1.setStock(35.0f);
    }

    private static void classTypeExamples() {
        Employee employee1 = new Employee();
        SalaryEmployee employee2 = new SalaryEmployee();
        HourlyEmployee employee3 = new HourlyEmployee();

        Class object = employee1.getClass();

        System.out.println("Employee1 type: " + object.getName());
        object = employee2.getClass();
        System.out.println("Employee2 type: " + object.getName());
        
        System.out.println("Employee1 is an Employee: " + (employee1 instanceof Employee));
        System.out.println("Employee1 is a SalaryEmployee: " + (employee1 instanceof SalaryEmployee));   
        System.out.println("Employee1 is an HourlyEmployee: " + (employee1 instanceof HourlyEmployee));  
        System.out.println("Employee2 is an Employee: " + (employee2 instanceof Employee));
        System.out.println("Employee2 is a SalaryEmployee: " + (employee2 instanceof SalaryEmployee));   
//        System.out.println("Employee2 is an HourlyEmployee: " + (employee2 instanceof HourlyEmployee));
        
        System.out.println("Employee1 is an Object: " + (employee1 instanceof Object)); 
    }
}
