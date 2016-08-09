package packt;

public class HourlyEmployee extends Employee {
    private float hoursWorked;
    private float payRate;
    
    public HourlyEmployee() {
        this.hoursWorked = 40.0f;
        this.payRate = 22.25f;
    }
    
    @Override
    public float computePay() {
        return hoursWorked * payRate;
    }
    
}
