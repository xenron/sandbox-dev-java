package com.student.learningJava;

import java.util.HashSet; 
 
public class FindSingle {

	public static int findSingle(int[] is) { 
		int re = 0;
		for (int i = 0; i < is.length; i++) {
			re ^= is[i];
		}
		return re;
	}
	
	public static int findSingle2(int[] is){
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < is.length; i++) {
			if(hs.contains(is[i]))
				hs.remove(is[i]);
			else hs.add(is[i]);
		}
		return (Integer) hs.toArray()[0];
	}

}
