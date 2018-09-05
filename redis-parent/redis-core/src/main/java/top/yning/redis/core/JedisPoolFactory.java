package top.yning.redis.core;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisPoolFactory {
	
	
	public static void main(String[] args) throws Exception {
		
		
//		JedisPool pool = new JedisPool(new GenericObjectPoolConfig(),"192.144.204.127");
//		
//		System.out.println(pool.getResource().info());
//		
//		pool.close();
		
		Jedis jedis = new Jedis("192.144.204.127",6379,60000);
		
		jedis.set("key", "value");
	
		jedis.close();
	}
}
