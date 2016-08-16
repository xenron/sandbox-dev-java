package SpringJdbc;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import Models.AlarmSenderEntity;
import Utils.SpringUtils;

public class jdbcExample {
 
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtils.getBean("jdbcTemplate");
		RedisTemplate<String, String> jedisTemplate = (RedisTemplate<String, String>) SpringUtils
				.getBean("jedisTemplate");
		jedisTemplate.setValueSerializer(new StringRedisSerializer());

		
 		List<AlarmSenderEntity> list = jdbcTemplate.query(
				"SELECT * FROM t_alarm_sender;",
				new BeanPropertyRowMapper<AlarmSenderEntity>(AlarmSenderEntity.class));
 		HashMap<String, AlarmSenderEntity> hm = new HashMap<String, AlarmSenderEntity>();
 
 		for (int i = 0; i < list.size(); i++) {
			System.out.println(ReflectionToStringBuilder.toString(list.get(i),ToStringStyle.MULTI_LINE_STYLE));
			String key = "AlarmTransfer:" + list.get(i).getBusName() + list.get(i).getAlarmLevel();
			System.out.println(key);
			hm.put(key, list.get(i));
		}
 		if (!jedisTemplate.hasKey("Sender_Rules_HashMap")) {
			jedisTemplate.opsForHash().putAll("Sender_Rules_HashMap", hm); 
 		}
 		else
 			System.out.println("has key for Sender_Rules_HashMap");
 		//check for some keys in the Sender_Rules_HashMap
 		if ( jedisTemplate.opsForHash().hasKey("Sender_Rules_HashMap","AlarmTransfer:hadoop高") )
 			System.out.println("find key ");
	}
}
