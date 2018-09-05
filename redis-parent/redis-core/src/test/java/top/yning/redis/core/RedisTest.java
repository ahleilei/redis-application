package top.yning.redis.core;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisTest {

	@Test
	public void test() {
		
		Jedis jedis = new Jedis("192.144.204.127",6379);
        System.out.println("连接成功");

		String key = "jedis";
		
		System.out.println(jedis.set(key, "redis"));
		
		System.out.println(jedis.keys("*"));
        
		System.out.println(jedis.info());
		
        jedis.close();
	}

}
