package packt;

import java.util.Scanner;

public class Chapter3Examples {

    private static enum Directions {

        NORTH, SOUTH, EAST, WEST
    };
    private static int state;

    public static void main(String[] args) {
        comparisonExamples();
//        floatingPointExamples();
//        calculate();
//        enumerationExample();
//        shortCircuitExamples();
    }

    private static boolean evaluateThis() {
        System.out.println("evaluateThis executed");
        return true;
    }

    private static boolean evaluateThat() {
        System.out.println("evaluateThat executed");
        state = 10;
        return false;
    }

    private static void shortCircuitExamples() {
        int sum = 1100;
        int amount = 300;
        if (sum > 1200 && amount < 500) {
            //
        }

        if (evaluateThis() || evaluateThat()) {
            System.out.println("The result is true");
        } else {
            System.out.println("The result is false");
        }
    }

    private static void floatingPointExamples() {
        float num1 = 0.0f;

        System.out.println(num1 / 0.0f);
        System.out.println(Math.sqrt(-4));
        System.out.println(Double.NaN + Double.NaN);
        System.out.println(Float.NaN + 2);
        System.out.println((int) Double.NaN);

        System.out.println();
        System.out.println(Float.NEGATIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Float.POSITIVE_INFINITY);
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Float.POSITIVE_INFINITY + 2);
        System.out.println(1.0 / 0.0);
        System.out.println((1.0 / 0.0) - (1.0 / 0.0));
        System.out.println(23.0f / 0.0f);
        System.out.println((int) (1.0 / 0.0));
        System.out.println(Float.NEGATIVE_INFINITY == Double.NEGATIVE_INFINITY);

        System.out.println();
        System.out.println(0 == -0);

        System.out.println(-1.0f / Float.POSITIVE_INFINITY);
        System.out.println(1.0f / Float.NEGATIVE_INFINITY);

        num1 = -0.0f;
        if (num1 >= 0.0f) {
            System.out.println(num1 + " is greater than or equal to zero");
        } else {
            System.out.println(-num1 + " is now greater than or equal to zero");
        }
        System.out.println(0.0f - num1);
        System.out.println(Math.abs(num1));
        System.out.println((new Float(-2.0)).compareTo(-0.0f));


        System.out.println();
        double num2 = 1.2f;
        double num3 = 0.2f;
        System.out.println((num2 / num3) == 6);
        float e = 0.000001f;
        if (Math.abs((num2 / num3) - 6) < e) {
            System.out.println("They are effectively equal");
        } else {
            System.out.println("They are not equal");
        }


    }

    private static void comparisonExamples() {
        int rate;
        rate = 100;
        boolean errorPresent = rate == 100;
        System.out.println(errorPresent);

        if (rate == 100) {
            System.out.println("rate is equal to 100");
        } else {
            System.out.println("rate is not equal to 100");
        }
//        if(rate = 100) {
//            
//        }   
        final int LEGAL_AGE = 21;
        int age = 12;

        if (age > LEGAL_AGE) {
            // Process
        } else {
            // Do not process
        }

        if (age <= LEGAL_AGE) {
            // Do not process
        } else {
            // Process
        }

        boolean isLegalAge = age >= LEGAL_AGE;
        boolean isNotLegalAge = age < LEGAL_AGE;
        if (isLegalAge) {
            System.out.println("Of legal age");
            System.out.println("Also of legal age");
        } else {
            System.out.println("Not of legal age");
        }

        if (!isLegalAge) {
            // Do not process
        } else {
            // Process
        }

        if (!isNotLegalAge) {
            // Process
        } else {
            // Do not process
        }

        float result = computeShippingCost(6,20);
        System.out.println(result);
    }

    private static float computeShippingCost(int zone, float weight) {
        float shippingCost;

        if (zone == 5) {
            shippingCost = weight * 0.23f;
        } else if (zone == 6) {
            shippingCost = weight * 0.23f;
        } else if (zone == 15) {
            shippingCost = weight * 0.35f;
        } else if (zone == 18) {
            shippingCost = weight * 0.17f;
        } else {
            shippingCost = weight * 0.25f;
        }

        switch (zone) {
            case 5:
                shippingCost = weight * 0.23f;
                break;
            case 6:
                shippingCost = weight * 0.23f;
                break;
            case 15:
                shippingCost = weight * 0.35f;
                break;
            case 18:
                shippingCost = weight * 0.17f;
                break;
            default:
                shippingCost = weight * 0.25f;
        }
        return shippingCost;
    }
    
    private static void enumerationExample() {
        Directions direction = Directions.NORTH;

        switch (direction) {
            case NORTH:
                System.out.println("Going North");
                break;
            case SOUTH:
                System.out.println("Going South");
                break;
            case EAST:
                System.out.println("Going East");
                break;
            case WEST:
                System.out.println("Going West");
                break;
        }

    }

    private static void calculate() {

        String zone = "East";
        float weight = 0;
        float shippingCost;


        if (zone.equals("East")) {
            shippingCost = weight * 0.23f;
        } else if (zone.equals("NorthCentral")) {
            shippingCost = weight * 0.35f;
        } else if (zone.equals("SouthCentral")) {
            shippingCost = weight * 0.17f;
        } else {
            shippingCost = weight * 0.25f;
        }
        System.out.println(shippingCost);

        switch (zone) {
            case "East":
                shippingCost = weight * 0.23f;
                break;
            case "NorthCentral":
                shippingCost = weight * 0.35f;
                break;
            case "SouthCentral":
                shippingCost = weight * 0.17f;
                break;
            default:
                shippingCost = weight * 0.25f;
        }
        System.out.println(shippingCost);
    }
}
