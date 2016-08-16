package thinkInJava; 
public class BasicTypeDemo {

	public static void stringdemo()
	{
		String str1 = "abc"; //stored in consant pool?
		String str2 = new String("abc"); // two objects one in stack one in heap
		System.out.println("\"abc\" compare with new String(\"abc\")" + str1==str2);
		
		String str3 = "abc";
		System.out.println(" two string constant \"abc\" compare is " + str3==str1);
		String str4 = "ab" + "c";
		System.out.println("\"abc\" compare with \"ab\" + \"c\" " + str3==str4);
		
		String str5 = new StringBuilder().append("a").append("bc").toString();
		System.out.println(str5.intern()==str2.intern());
		System.out.println(str3.equals(str4) + " string content compare use equals method , same content is same, return true");
		System.out.println("abc".equalsIgnoreCase("ABC"));
		  
		 
	}
	
	public static void strinbBufferDemo()
	{
		StringBuffer sb = new StringBuffer();
		//append delete update replace search
		sb.append("abc");
		sb.delete(1, 2);
		System.out.println("abc delete 1,2 then become is " + sb.toString());
		sb.insert(1,"b");
		System.out.println("ac insert 1,b is " + sb.toString());
		System.out.println("sb revere is " + sb.reverse());
		System.out.println("stringbuffer and stringbuilder is most same, the former is thread synchronized \n"
				+ "can use multiple threads case, the later is used in single thread case.");
	}
	
	public static void basicTypeDemo()
	{
		Integer i = Integer.valueOf("5");
		Double  d = Double.valueOf("100.20");
		Float f = Float.valueOf("100.2222");
		
		System.out.println(i.toString());
		System.out.println(d);
		System.out.println(f);
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toHexString(i));
		System.out.println(Integer.toOctalString(i));
		
		Double dd = new Double(0.0/0.0);
		System.out.println(dd.isNaN());
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//stringdemo();	
		//strinbBufferDemo();
		basicTypeDemo();
		
	}
 
} 
