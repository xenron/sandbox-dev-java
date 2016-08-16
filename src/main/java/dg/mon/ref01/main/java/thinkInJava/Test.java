package thinkInJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test {
	private static int i;
	static private int counter;

	public Test(int _i) {
		i = _i;
		counter++;
	}

	public void printMsg() {
		System.out.println(i);
		System.out.println("total number of class Test is " + counter);
	}

	public static Properties getProperty(String filepath, Integer method)
			throws IOException {
		Properties p = new Properties();
		if (method.equals(1)) {
			InputStream is = Test.class.getResourceAsStream(filepath);
			// InputStream is =
			// Thread.currentThread().getContextClassLoader().getResourceAsStream(filepath);
			p.load(is);
		} else {
			FileInputStream fis = new FileInputStream(new File(filepath));
			p.load(fis);
		}
		System.out.println(p.get("key2"));
		return p;
	}

	public static void main(String[] args) throws IOException {
		 File f = new File("/home/student/Desktop/reference.txt");
		 long lastModifyTS = f.lastModified();
		 System.out.println(lastModifyTS);
		 
		 long  x = 1466028845000L;
		 
		 System.out.println( x ==lastModifyTS);
		 

	}
}
