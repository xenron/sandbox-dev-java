package ch4;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.core.NamingPolicy;
import net.sf.cglib.core.Predicate;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import Models.Student;

@SuppressWarnings("unused")
public class CglibTest2 {

	//map2bean use cglib 
	private <T> T generateBean(Map<String, Object> propertyMap,Class<T> beanClass) throws InstantiationException, IllegalAccessException {
		//use this method, the class must has get and setter method
		BeanMap bm = BeanMap.create(beanClass.newInstance());
 		bm.putAll(propertyMap);
		return beanClass.cast(bm.getBean());
	}
	
	public Object map2Bean(Map<String,Object> map) throws IllegalAccessException, InvocationTargetException 
	{
		BeanGenerator bg = new BeanGenerator();
//		bg.setNamingPolicy(new NamingPolicy(){ 
//			@Override
//			public String getClassName(String prefix, String source, Object key,
//					Predicate arg3) { 
//				return "Models.Student";
//			}
//		});
		
		bg.setSuperclass(Object.class);
		for(Map.Entry<String, Object> entry : map.entrySet())
		{
			bg.addProperty(entry.getKey(), entry.getValue().getClass());
		}
		Object obj = bg.create();
		
//		for(Map.Entry<String, Object> entry : map.entrySet())
//		{
//		  BeanUtils.setProperty(obj, entry.getKey(), entry.getValue());
//		}
		BeanMap bm = BeanMap.create(obj);
		bm.putAll(map);
		
		return obj;
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		CglibTest2 test2 = new CglibTest2();
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("age", 20);
		map.put("name", "student");
		
		Student st = test2.generateBean(map, Student.class);
		System.out.println(ReflectionToStringBuilder.toString(st,ToStringStyle.MULTI_LINE_STYLE));
		
		Object obj = test2.map2Bean(map);
		System.out.println(ReflectionToStringBuilder.toString(obj,ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(obj.toString());
	}

}
