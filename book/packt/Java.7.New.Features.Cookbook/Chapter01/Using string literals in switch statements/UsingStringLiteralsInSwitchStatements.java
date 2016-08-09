package packt;

public class UsingStringLiteralsInSwitchStatements {

    private static boolean verbose = false;
    private static boolean logging = false;
    private static boolean displayHelp = false;

    public static void main(String[] args) {
        for (String argument : args) {
            switch (argument) {
                case "-verbose":
                case "-v":
                    verbose = true;
                    break;
                case "-log":
                    logging = true;
                    break;
                case "-help":
                    displayHelp = true;
                    break;
                default:
                    System.out.println("Illegal command line argument");
            }
            displayApplicationSettings();
        }
    }

    private static void displayApplicationSettings() {
        System.out.println("Application Settings");
        System.out.println("Verbose: " + verbose);
        System.out.println("Logging: " + logging);
        System.out.println("Help: " + displayHelp);
    }
}
