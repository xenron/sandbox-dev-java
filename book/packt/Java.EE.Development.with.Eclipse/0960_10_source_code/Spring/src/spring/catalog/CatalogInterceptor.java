package spring.catalog;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CatalogInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation inv) throws Throwable {

		System.out.println("Intercepted method - "
				+ inv.getMethod().getDeclaringClass()

				+ " - " + inv.getMethod().getName());

		return null;
}}
