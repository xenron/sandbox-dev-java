package packt;

interface FirstBaseInterface {
    default void display() {
        System.out.println("From FirstBaseInterface");
    }
}

interface SecondBaseInterface {
    default void display() {
        System.out.println("From SecondBaseInterface");
    }
}

public class DerivedClass implements SecondBaseInterface, FirstBaseInterface {

    public void display() {
        FirstBaseInterface.super.display();
    }

    public static void main(String... args) {
        new DerivedClass().display();
    }
}
