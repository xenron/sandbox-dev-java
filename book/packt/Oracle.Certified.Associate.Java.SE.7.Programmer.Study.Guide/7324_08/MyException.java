package packt;

public class MyException extends Exception {

    private String information;

    public MyException(String information) {
        this.information = information;
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}
