package top.yning.redis.core;

public class RealSubject implements Subject {

	@Override
	public void say(String call) {
		
		System.out.println("say:"+call);
	}

	@Override
	public void listen() {
		
		System.out.println("listen");
	}

}
