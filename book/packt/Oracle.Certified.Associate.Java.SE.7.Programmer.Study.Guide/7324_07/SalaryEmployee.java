package packt;

public class SalaryEmployee extends Employee {

    private float stock;

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public SalaryEmployee() {
        super();
        age = 35;
    }

    public SalaryEmployee(String name, int age, int zip, float stock) {
//        super(name, age, zip);
        this.setName(name);
        this.setAge(age);
        this.setZip(zip);
        this.stock = stock;
    }

    @Override
    public float computePay() {
        return 0.0f;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
//        return "Name: " + this.getName() +
//                "  Age: " + this.getAge() +
        return super.toString() + "  Stock: " + this.stock;
    }

    public void display() {
        System.out.println("Employee Base Data");
        System.out.println(super.toString());
        System.out.println("SalaryEmployee Data");
        System.out.println("Stock: " + this.stock);
    }
     
//    public int getAge() {
//        return age;
//    }    
}
