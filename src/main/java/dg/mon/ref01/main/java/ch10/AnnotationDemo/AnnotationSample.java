package ch10.AnnotationDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationSample {
	
	public static class Student{
		private String name;
		private int age;
		
		public Student(){}
		public Student(String _name,int _age)
		{
			this.name=_name;
			this.age=_age;
		}
		@AutoRunMethod
		public int getAge() {
			return age;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		@AutoRunMethod
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		@AutoRunMethod
		public String toString()
		{
			System.out.println("this is test, string for Student");
			return "Test this is Student";
		}
		
	}
	
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			Student A = new Student("studentyao",22);
			Method[] mts = A.getClass().getMethods();
			for(Method mt:mts){
				AutoRunMethod arm = mt.getAnnotation(AutoRunMethod.class);
				if(arm==null) continue; 
				System.out.println(mt.invoke(A));
			}
	}
	
}
