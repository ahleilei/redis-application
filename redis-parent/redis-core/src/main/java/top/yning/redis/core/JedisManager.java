package top.yning.redis.core;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisManager extends Jedis{
	
	private static JedisManager jedisManager = null;
	
	private static JedisPool jedisPool = null;
	
	private  JedisManager() {
		//私有构造
		System.out.println("create");
	}
	
	static {
		
		jedisManager = new JedisManager();
		
		jedisPool = new JedisPool(new GenericObjectPoolConfig(), "192.144.204.127");
	}
	
	public Jedis borrow() {
		
		return jedisPool.getResource();
	}
	
	public void close(Jedis jedis) {
		
		jedis.close();
	}
	
	public static JedisManager getInstance() {
		
		return jedisManager;
	}
	
	public static void main(String[] args) {
		
		Jedis jedis = JedisManager.getInstance().borrow();
		
		for(int i=0;i<10;i++) {
			System.out.println(jedis.set("key"+i, "value"+i));
		}
		
		JedisManager.getInstance().close(jedis);
	}
}
