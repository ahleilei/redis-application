package top.yning.redis.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

	private Object object;
		
	
	public ProxyHandler(Object object) {
		super();
		this.object = object;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println(proxy.getClass().getName());
		
		System.out.println(method.getName());
		
		method.invoke(object, args);
		
		System.out.println(args);
		
		return null;
	}

	
	public static void main(String[] args) {
		
		Subject subject = new RealSubject();
		
		ProxyHandler handler = new ProxyHandler(subject);
		
		Subject s = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
	
		s.say("hello");
		
		s.listen();
		
	}
}
