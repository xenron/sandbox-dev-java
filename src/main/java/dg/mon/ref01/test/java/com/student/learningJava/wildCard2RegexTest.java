package com.student.learningJava;

 
import org.junit.Before; 
import org.junit.Test;

import  realWorldJava.wildCard2Regex;

public class wildCard2RegexTest {
 
	@Before
	public void setUp() throws Exception {
	 
	}

	@Test
	public void test1() { 
		System.out.println( wildCard2Regex.wildcardToRegex("/tmp/sysout.*") );
		System.out.println( wildCard2Regex.wildcardToRegex("/tmp/nums_{long,short}_file.txt") );
		System.out.println( wildCard2Regex.wildcardToRegex("/tmp/nums.???") );
		 
	}
    
	 
}
