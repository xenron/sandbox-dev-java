package packt;

public class CommandLineDemo {

    public static void main(String args[]) {
        System.out.println("The command line has "
                + args.length + " arguments");
        for (int i = 0; i < args.length; i++) {
            System.out.println("\tArgument Number " + i + ": " + args[i]);
        }
    }
}
