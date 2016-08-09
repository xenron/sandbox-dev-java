package packt;

public class Chapter2Examples {

    public enum Directions {

        NORTH, SOUTH, EAST, WEST
    }

    public static void main(String[] args) {

        // Example variable names
        int numberWheels;
        int numberCylinders;
        float mileage;
        boolean engineOn;
        String ownerName;
        int $newValue;
        String _byline;


        // Using underscores
        long ssn = 111_22_3333L;
        String formattedSsn = Long.toString(ssn);
        for (int i = 0; i < formattedSsn.length(); i++) {
            System.out.print(formattedSsn.charAt(i));
            if (i == 2 || i == 4) {
                System.out.print('-');
            }
        }
        System.out.println();


        // Using a mask
        byte value = (byte) 0b0111_1010;
        byte result = (byte) (value & 0b0000_1111);
        System.out.println("result: " + Integer.toBinaryString(result));

        // char literals
        char letter = 'a';
        letter = 'F';

        // String literals
        String errorMessage = "Error – bad input file name";
        String columnHeader = "\tColumn 1\tColumn2\n";

        // Constants examples
        final double PI = 3.14159;
        final int NUMSHIPS = 120;
        final float RATEOFRETURN = 0.125F;

        // Enumeration example
        Directions direction;
        direction = Directions.EAST;
        System.out.println(direction);

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

        // Operator issues
        int total;

        total = 0;
        total += 2;	// Increments total by 2
        total = +2;	// Valid but simply assigns a 2 to total!

        // Cast examples
        int i;
        float f = 1.0F;
        double d = 2.0;

        i = (int) f;	// Cast a float to an int
        i = (int) d;	// Cast a double to an int
        f = (float) d;	// Cast a double to a float

        // String class examples
        String s = "Constant";
        s = s + " and Changeable";
        System.out.println(s);

        s = "Constant";
        s = s.concat(" and Changeable");
        System.out.println(s);

        String firstString = new String();
        String secondString = new String("The second string");
        String thirdString = "The third string";

        // StringBuffer examples
        StringBuffer stringBuffer = new StringBuffer("A StringBuffer string");
        StringBuilder stringBuilder = new StringBuilder("A StringBuilder string");
        String stringBufferBasedString = new String(stringBuffer);
        String stringBuilderBasedString = new String(stringBuilder);

        // Comparison example
        String s1 = "street";
        String s2;

        s2 = "street";

        if (s1 == s2) {
            // False
        }

        String firstLiteral = "Albacore Tuna";
        String secondLiteral = "Albacore Tuna";
        String firstObject = new String("Albacore Tuna");

        if (firstLiteral == secondLiteral) {
            System.out.println("firstLiteral and secondLiteral are the same object");
        } else {
            System.out.println("firstLiteral and secondLiteral are not the same object");
        }
        if (firstLiteral == firstObject) {
            System.out.println("firstLiteral and firstObject are the same object");
        } else {
            System.out.println("firstLiteral and firstObject are not the same object");
        }

        String location = "Iceberg City";
        if (location.equals("iceberg city")) {
            System.out.println(location + " equals ' city'!");
        } else {
            System.out.println(location + " does not equals 'iceberg city'");
        }

        if (location.equals("Iceberg City")) {
            System.out.println(location + " equals 'Iceberg City'!");
        } else {
            System.out.println(location + " does not equals 'Iceberg City'!");
        }

        if (location.endsWith("City")) {
            System.out.println(location + " ends with 'City'!");
        } else {
            System.out.println(location + " does not end with 'City'!");
        }


        String firstIrene = "Irène";
        String secondIrene = "Ire\u0300ne";

        if (firstIrene.equals(secondIrene)) {
            System.out.println("The strings are equal.");
        } else {
            System.out.println("The strings are not equal.");
        }


        String Sample = "catalog";
        i = Sample.length(); 			// 7

        String sample = "catalog";
        String resultString = "";
        char charValue;


        System.out.println(Sample.length());
        System.out.println(Sample.charAt(0));
        System.out.println(Sample.charAt(sample.length() - 1));
        System.out.println(Sample.substring(0, 3));
        System.out.println(Sample.substring(4));

        location = "Iceberg City";
        System.out.println(location.indexOf('I'));
        System.out.println(location.lastIndexOf('e'));
        System.out.println(location.indexOf('e'));

        // String conversion examples
        s1 = String.valueOf(304);
        s2 = String.valueOf(778.204);

        int num1 = Integer.valueOf("540").intValue();
        double num2 = Double.valueOf("3.0654").doubleValue();

        num1 = Integer.parseInt("540");
        num2 = Double.parseDouble("3.0654");

        // Misc string methods
        String oldString = " The gray fox ";
        String newString;

        newString = oldString.replace(' ', '.');
        System.out.println(newString);

        newString = oldString.toLowerCase();
        System.out.println(newString);

        newString = oldString.toUpperCase();
        System.out.println(newString);

        newString = oldString.trim();
        System.out.println("[" + newString + "]");

        // StringBuffer examples
	StringBuffer buffer;
	buffer = new StringBuffer();
	buffer.append("World lass");
	buffer.append(" buffering mechanism!");
	buffer.insert(6,"C");
	System.out.println(buffer.toString());


    }
}
