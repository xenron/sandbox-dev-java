package packt;

public class UsingUnderscoresInLiteralsToImproveCodeReadability {

    public static void main(String[] args) {
        long debitCard = 1234_5678_9876_5432L;
        System.out.println("The card number is: " + debitCard);
        System.out.print("The formatted card number is:");
        printFormatted(debitCard);

        float minAmount = 5_000F;
        float currentAmount = 5_250F;
        float withdrawalAmount = 500F;

        if ((currentAmount - withdrawalAmount) < minAmount) {
            System.out.println("Minimum amount limit exceeded " + minAmount);
        }
        
        //There's More: Using underscores with binary literals
//        byte initializationSequence = (byte) 0b01_110_010;
//        byte inputValue = (byte) 0b101_11011;
//
//        byte result = (byte) (inputValue & (byte) 0b000_11111);
//        System.out.println("initializationSequence: " + 
//                Integer.toBinaryString(initializationSequence));
//        System.out.println("result: " + Integer.toBinaryString(result));


    }

    private static void printFormatted(long cardNumber) {
        String formattedNumber = Long.toString(cardNumber);
        for (int i = 0; i < formattedNumber.length(); i++) {
            if (i % 4 == 0) {
                System.out.print(" ");
            }
            System.out.print(formattedNumber.charAt(i));
        }
        System.out.println();
    }
}
