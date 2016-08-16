package ch4;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
 

import Models.Student;

public class ReflectionExample {
	//convert map to java bean key is the javabean's field name
	//convert java bean to map : filed name is key
	
	public Object map2bean(Map<String,Object> map,String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		Class<?> clz = Class.forName(className);
		Object obj = clz.newInstance();
		Field[] fields = clz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if(map.containsKey(fields[i].getName()))
			{
				fields[i].setAccessible(true);
				fields[i].set(obj, map.get(fields[i].getName()));
				fields[i].setAccessible(false);
			}  
		} 
		return  obj;
	}
 
	
	public Map<String,Object> bean2map(Object obj) throws IllegalArgumentException, IllegalAccessException
	{
		Map<String,Object> map = new HashMap<String,Object>();
		Class<? extends Object> clz = obj.getClass();
		Field[] fields = clz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			map.put(fields[i].getName(),fields[i].get(obj));
			fields[i].setAccessible(false);
		}
		return map;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException { 
		System.out.println("hello java");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("age",20);
		map.put("name","student");
		
		ReflectionExample re = new ReflectionExample();
		Student s = (Student)re.map2bean(map,"Models.Student");
		System.out.println(s.toString());
		
		Map<String,Object> map2 = re.bean2map(s); 
		for(Entry<String,Object> entry : map2.entrySet())
			System.out.println(entry.getKey() + ":" + entry.getValue());
	}

}
