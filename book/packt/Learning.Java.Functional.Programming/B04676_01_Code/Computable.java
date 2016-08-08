package packt;

public interface Computable {
    public int compute();
    
    public default int doubleNumber(int num) {
        return 2*num;
    }
    
    public default int negateNumber(int num) {
        return -1*num;
    }
}
