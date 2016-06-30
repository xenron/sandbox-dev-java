package dg.mon.hw.ch05;

import java.io.File;

public class TakeFilePathAndName {

    public static void main(String[] args) {
        // This is the path where the file's name you want to take.
        String path = "D://tmp";
        getFile(path);
    }

    private static void getFile(String path) {
        // get file list where the path has
        File file = new File(path);
        // get the folder list
        File[] array = file.listFiles();

        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                // only take file name
                System.out.println("^^^^^" + array[i].getName());
                // take file path and name
                System.out.println("#####" + array[i]);
                // take file path and name
                System.out.println("*****" + array[i].getPath());
            } else if (array[i].isDirectory()) {
                getFile(array[i].getPath());
            }
        }
    }
}
