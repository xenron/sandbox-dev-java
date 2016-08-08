package com.sheeom.worrking_with_interceptor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class CustomInterceptor extends EmptyInterceptor {

	/* Line 3 */ public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		System.out.println("On Save");
		System.out.println("entity: " + entity);
		System.out.println("id: " + id);
		System.out.println("state: " + Arrays.toString(state));
		System.out.println("propertyNames: " + Arrays.toString(propertyNames));
		System.out.println("types: " + Arrays.toString(types));
		return false;
	}

	/* Line 13 */ public void preFlush(Iterator iterator) {
		System.out.println("\n\nPre flush");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	/* Line 20 */ public void postFlush(Iterator iterator) {
		System.out.println("\n\nPost flush");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
