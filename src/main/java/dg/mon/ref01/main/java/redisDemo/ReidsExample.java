package redisDemo;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

import Utils.SpringUtils;

public class ReidsExample {

	public static void main(String[] args) throws MalformedURLException {

		@SuppressWarnings("unchecked")
		RedisTemplate<String, String> jedisTemplate = (RedisTemplate<String, String>) SpringUtils
				.getBean("jedisTemplate");
		jedisTemplate.opsForValue().set("jedis_test", "hello world");

		jedisTemplate.expire("jedis_test", 1, TimeUnit.MINUTES);
		// Test push data to list and then get data
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 100; i++)
			list.add("listitem : + " + i);
		jedisTemplate.opsForList().leftPushAll("jedis_list_test", list);
		jedisTemplate.opsForList()
				.leftPush("jedis_list_test", "listitem : 100");
		// lrange jedis_list_test 0 100

		Map<String, String> hm = new HashMap<String, String>();
		hm.put("key1", "value1");
		hm.put("key2", "value2");
		hm.put("key3", "value3");
		hm.put("key4", "value4");

		jedisTemplate.opsForHash().putAll("jedis_hash_test", hm);
		jedisTemplate.expire("jedis_hash_test", 5, TimeUnit.MINUTES);
		if (jedisTemplate.opsForHash().hasKey("jedis_hash_test", "key1"))
			System.out.println("hash key");
		
		
		jedisTemplate.opsForValue().set("/home/我的桌面/abc def.log","100");
		 
	}
}
