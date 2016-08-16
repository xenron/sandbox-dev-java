package dg.mon.hw.ch02;

import java.util.HashMap;
import java.util.Map;

public class SeekAloneElement {

    /**
     * O(n^2)
     */
    public static String getAloneElement01(String[] arr) {
        boolean flag;
        for (int i = 0; i < arr.length; i++) {
            // display first time
            flag = false;
            for (int j = 0; j < arr.length; j++) {
                if (j != i && arr[i] == arr[j]) {
                    // display second time
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return arr[i];
        }
        return "";
    }

    /**
     * O((n^2)/2)
     */
    public static String getAloneElement02(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (Integer.parseInt(entry.getValue().toString()) == 1) {
                return entry.getKey().toString();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] testArr = new String[]{"a", "b", "b", "a", "c"};

        System.out.println(getAloneElement01(testArr));
        System.out.println(getAloneElement02(testArr));
    }
}
