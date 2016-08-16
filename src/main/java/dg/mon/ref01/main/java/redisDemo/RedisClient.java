package redisDemo;

import java.util.HashSet;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster; 
 
public class RedisClient { 
  
   static HashSet<HostAndPort> jedisClusterNodes = new java.util.HashSet<HostAndPort>();
     
   static {
	   
   jedisClusterNodes.add(new HostAndPort("127.0.0.1",7000));
   jedisClusterNodes.add(new HostAndPort("127.0.0.1",7001));
   jedisClusterNodes.add(new HostAndPort("127.0.0.1",7002));
   jedisClusterNodes.add(new HostAndPort("127.0.0.1",7003));
   jedisClusterNodes.add(new HostAndPort("127.0.0.1",7004));
   jedisClusterNodes.add(new HostAndPort("127.0.0.1",7005));
   
   }
  public static JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
  
}
