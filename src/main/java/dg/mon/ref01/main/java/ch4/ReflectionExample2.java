package ch4;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import Models.Student;

public class ReflectionExample2 {

	public <T extends Object > T map2bean(Map<String, Object> propertyMap, Class<T> clazz)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		
		T obj = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (propertyMap.containsKey(fields[i].getName())) {
				fields[i].setAccessible(true);
				fields[i].set(obj, propertyMap.get(fields[i].getName()));
				fields[i].setAccessible(false);
			}
		}
		return obj;
	}

	public <T>  Map<String, Object> bean2map(T obj)
			throws IllegalArgumentException, IllegalAccessException {
		Map<String, Object> map = new HashMap<String, Object>();
		Class<? extends Object> clz = obj.getClass();
		Field[] fields = clz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			map.put(fields[i].getName(), fields[i].get(obj));
			fields[i].setAccessible(false);
		}
		return map;
	}

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("age", 20);
		map.put("name", "student");

		ReflectionExample2 re = new ReflectionExample2();
		Student s = re.map2bean(map, Student.class);
		System.out.println(s.toString());

		Map<String, Object> map2 = re.bean2map(s);
		for (Entry<String, Object> entry : map2.entrySet())
			System.out.println(entry.getKey() + ":" + entry.getValue());
	}

}
