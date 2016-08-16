package thinkInJava;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet; 
public class ContainerDemo {

/*
* Collection 接口
 * @see     Set
	 * @see     HashSet
	 * @see     TreeSet
 * @see     List
	 * @see     ArrayList
	 * @see     LinkedList
 * @see     Map
 * @see     SortedSet
 * @see     SortedMap

 * @see     Vector
 * @see     Collections
 * @see     Arrays
 * @see     AbstractCollection
 * add addAll remove removeAll isEmpty Contains toArray
* */
	class Plant implements Serializable,Comparable<Plant> {
	    public int compareTo(Plant p)
	    {
	    	return this.age.compareTo(p.age);
	    }

		public Plant() {
			name = "untitled";
			age = 0;
		}

		public Plant(String _name) {
			name = _name;
			age = 0;
		}

		public Plant(String _name, int _i) {
			name = _name;
			age = _i;
		}

		private static final long serialVersionUID = 1L;
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		private Integer age;

	}

	class Flower extends Plant
	{ 
		private static final long serialVersionUID = 2L;
		
	}
	
	 static void display(Iterator<Integer> it)
	{
System.out.println("start .....");
		while (it.hasNext())
System.out.println(it.next());
System.out.println("finished....");
	}
	 static void randColl(Collection<Integer> c,Integer limit)
	 {
		 Random rand = new Random(47);
		 for(int i=0;i<limit;i++)
			 c.add(rand.nextInt(1000));
	 }
	public static void main(String[] args) {
		Flower f = new ContainerDemo().new Flower();
		f.setName("YueJie");
		f.setAge(1);
		Flower f2 = new ContainerDemo().new Flower();
		f2.setName("MeiGui");
		f2.setAge(3);
		Plant px = new ContainerDemo().new Plant();
		List<Plant> plants =
				//new ArrayList<Plant>();
				new LinkedList<Plant>();
		plants.add(f);
		plants.add(f2);
		plants.add(px);
		//custome sort by name
		Collections.sort(plants);
		for(Plant p : plants)
System.out.println(p + " :" + p.getName());
		plants.clear();
	 
		Set<Integer> set1 = new HashSet<Integer>();
			 randColl(set1,10);
			display(set1.iterator());
			SortedSet<Integer> ss = new TreeSet<Integer>();
			ss.addAll(set1);
			display(ss.iterator());
		 Queue<Integer> q = new LinkedList<Integer>();
		  randColl(q,5);
		 display(q.iterator());
		 
		 Stack<Integer> st = new Stack<Integer>();
		 randColl(st, 5);
		 while(!st.isEmpty())
System.out.println(st.pop());
		 HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		 Random rand = new Random(47);
		 for(int i=0;i<100;i++)
		 {
			 int r = rand.nextInt(10);
			 Integer freq = hm.get(r);
			 hm.put(r, null==freq? 1 : freq+1);
		 }
System.out.println(hm);
		 for(Entry<Integer,Integer> item :hm.entrySet())
System.out.println(item.getKey() +" : " +  item.getValue());
		  
		
	}

}
