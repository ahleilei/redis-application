package top.yning.redis.core;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
	
		System.out.println(method.getName());
		
		Object result = proxy.invokeSuper(obj, args);
		
		return result;
	}
	
	public static void main(String[] args) {
		
		CglibProxy cp = new CglibProxy();
		
		Enhancer eh = new Enhancer();
		eh.setSuperclass(RealSubject.class);
		eh.setCallback(cp);
		
		RealSubject subject = (RealSubject)eh.create();
		
		subject.say("hello");
		subject.listen();
	}

}
