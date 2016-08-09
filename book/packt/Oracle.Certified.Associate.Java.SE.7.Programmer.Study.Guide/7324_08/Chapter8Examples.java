package packt;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter8Examples {

    public static void main(String... args) throws MyException {

//        try (BufferedReader reader = Files.newBufferedReader(
//                        Paths.get(new URI("file:///E:/data.txt")),
//                        Charset.defaultCharset());
//                BufferedWriter writer = Files.newBufferedWriter(
//                        Paths.get(new URI("file:///E:/data.bak")),
//                        Charset.defaultCharset())) {
//
//            String input;
//            while ((input = reader.readLine()) != null) {
//                writer.write(input);
//                writer.newLine();
//            }
//            System.out.println("Copy complete!");
//        } catch (URISyntaxException | IOException ex) {
//            ex.printStackTrace();
//        }

        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Chapter8Examples.class.getName()).log(Level.SEVERE, null, ex);
        }
        losingStackTrace();
//        simpleFinallyBlockExample();
//        catchingMultipleExceptionExample();

    }

    public static void catchingMultipleExceptionExample() {
        boolean processing =true;
        while(processing) {
            System.out.print("Enter a number: ");
            try {
                Scanner scanner = new Scanner(System.in);
                int number = scanner.nextInt();
                if (number < 0) {
                    throw new InvalidParameter();
                }
                System.out.println("The number is: " + number);
                break;
            } catch (InputMismatchException | InvalidParameter e) {
                System.out.println("Invalid input, try again");
            }
        }
    }


    

    private static void simpleFinallyBlockExample() {
        // Simply display a file
        BufferedReader reader = null;
        try {
            File file1 = new File("e:\\File11.txt");

            reader = new BufferedReader(new FileReader(file1));
            // Copy file
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());

            System.out.println("---e.getCause(): " + e.getCause());
            System.out.println("---e.getMessage(): " + e.getMessage());
            System.out.println("---e.getLocalizedMessage(): " + e.getLocalizedMessage());
            System.out.println("---e.toString(): " + e.toString());
        } finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                // Handle close exception
//                e.printStackTrace();
                System.out.println("---e.getCause(): " + e.getCause());
                System.out.println("---e.getMessage(): " + e.getMessage());
                System.out.println("---e.getLocalizedMessage(): " + e.getLocalizedMessage());
                System.out.println("---e.toString(): " + e.toString());
//                System.out.println("---e.toString(): " + e);
            }
        }
    }

    private static void finallyBlockExample() {
        // Copy a file to another
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File file1 = new File("c:\\File1.txt");
            File file2 = new File("c:\\File2.txt");

            br = new BufferedReader(new FileReader(file1));
            bw = new BufferedWriter(new FileWriter(file2));
            // Copy file
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                bw.close();
            } catch (IOException ex) {
                // Handle close exception
            }
        }
    }

    private static void losingStackTrace() {
        try {
            File file = new File("c:\\NonExistentFile.txt");
            FileReader fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
              (new MyException(e)).printStackTrace();
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Chapter8Examples.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println();
            System.out.println("---e.getCause(): " + e.getCause());
            System.out.println("---e.getMessage(): " + e.getMessage());
            System.out.println("---e.getLocalizedMessage(): " + e.getLocalizedMessage());
            System.out.println("---e.toString(): " + e.toString());

            System.out.println();
            StackTraceElement traces[] = e.getStackTrace();
            for (StackTraceElement ste : traces) {
                System.out.println(ste);
            }
        }
    }
}
