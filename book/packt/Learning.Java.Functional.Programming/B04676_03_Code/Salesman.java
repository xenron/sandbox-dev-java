package packt;

public class Salesman {
    private Customer bestCustomer;
    private Manager manager;

    public Salesman(Customer bestCustomer) {
        this.bestCustomer = bestCustomer;
    }

    public Salesman(Manager manager) {
        this.manager = manager;
    }

    public Customer getBestCustomer() {
        return bestCustomer;
    }

    public Manager getManager() {
        return manager;
    }
}
