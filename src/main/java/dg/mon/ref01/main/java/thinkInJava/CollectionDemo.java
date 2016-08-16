package thinkInJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

public class CollectionDemo {
	public static void main(String[] args) {

		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("1", "1");
		ht.put("2", "2");
		ht.put("3", "3");
		ht.put("4", "4");
		for (Entry<String, String> entry : ht.entrySet())
			System.out.println(entry.getKey() + "  " + entry.getValue());

		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("abc");
		list.add("xyz");
		list.add("xyz");
		HashMap<String, String> hm = new HashMap<String, String>();

		for (int i = 0; i < list.size(); i++) {
			hm.put(list.get(i), list.get(i));
		}

		for (Entry<String, String> entry : hm.entrySet())
			System.out.println(entry.getKey() + ":" + entry.getValue());

		if (hm.containsKey("abc"))
			System.out.println("contains abc");
		else
			System.out.println("not contains abc");
		
	}

}
