package com.student.learningJava;

import static org.junit.Assert.*;
 
import org.junit.Test;

public class FindSingleTest {

	@Test
	public void test() { 
		 assertEquals(5, FindSingle.findSingle(new int[]{1,2,3,5,1,2,3}));
		 assertEquals(5, FindSingle.findSingle(new int[]{1,2,3,4,4,5,1,2,3}));
		 assertEquals(5, FindSingle.findSingle(new int[]{1,2,3,5,1,3,2,6,7,7,6}));
		 assertEquals(5, FindSingle.findSingle(new int[]{1,2,1,2,3,3,5})); 
		 
		 assertEquals(5, FindSingle.findSingle2(new int[]{1,2,3,5,1,2,3}));
		 assertEquals(5, FindSingle.findSingle2(new int[]{1,2,3,4,4,5,1,2,3}));
		 assertEquals(5, FindSingle.findSingle2(new int[]{1,2,3,5,1,3,2,6,7,7,6}));
		 assertEquals(5, FindSingle.findSingle2(new int[]{1,2,1,2,3,3,5})); 
	}

}	
