package packt;

import java.util.BitSet;

public class UsingTheNewBitSetMethodsInJava7 {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        long[] array = {1, 21, 3};
        bitSet = BitSet.valueOf(array);
        System.out.println(bitSet);

        long[] tmp = bitSet.toLongArray();
        for (long number : tmp) {
            System.out.println(number);
        }
        
        // There's more
        System.out.println(bitSet.previousSetBit(1));   
        System.out.println(bitSet.previousClearBit(66));
        
    }
}
