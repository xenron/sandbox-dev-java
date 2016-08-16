package realWorldJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import Models.AlarmSenderEntity;
import Utils.SpringUtils;

@SuppressWarnings("unchecked")
public class ExecuteShell {
	private static final String MsgListName = "Alert_Msg_List";
	private static Logger logger = Logger.getLogger(ExecuteShell.class);

	public void TestRedis() {
		RedisTemplate<String, String> jedisTemplate = (RedisTemplate<String, String>) SpringUtils
				.getBean("jedisTemplate");
		jedisTemplate.setValueSerializer(new StringRedisSerializer());
		Long size = jedisTemplate.opsForList().size(MsgListName);

		if (0L == size)
			return;
//		// show the Hashmap 's value
		Map<Object, Object> hm = jedisTemplate.opsForHash().entries(
				"Sender_Rules_HashMap");
		for (Entry<Object, Object> entry : hm.entrySet()) {
			 System.out.println(entry.getKey());
		}
		for (int i = 0; i < 1; i++) {
			String json = jedisTemplate.opsForList().rightPop(MsgListName);
			AlarmMsgEntity entity = JsonUtil.getInstance().json2Obj(json,
					AlarmMsgEntity.class);
			// if has key then wait next time to alarm
			if (jedisTemplate.hasKey(entity.getRedisKey()))
				continue;
			System.out.println(entity.getRedisKey());

			if (jedisTemplate.opsForHash().hasKey("Sender_Rules_HashMap",
					entity.getRedisKey())) {
				System.out.println("find one .................");
				AlarmSenderEntity ae = (AlarmSenderEntity) jedisTemplate.opsForHash().get(
						"Sender_Rules_HashMap", entity.getRedisKey());
				if (ae.getSendType().equals("短信")) { 
					System.out.println("sends messages for alarm!");
					jedisTemplate.expire(entity.getRedisKey(), 5,
							TimeUnit.MINUTES);
				}
			}
		}

	}

	public static void main(String[] args) {
//		ExecuteShell es = new ExecuteShell();
//		es.TestRedis();
		String basepath = ExecuteShell.class.getResource("/").getPath();
		System.out.println(basepath);
		try {
			logger.info(executeShell(new String[] {"sh",basepath + "/sendMsg.sh","abc","def ght dsf"} ));
		} catch (IOException e) {
			logger.debug("something wrong with execute the command", e);
		} catch (InterruptedException e) {
			logger.debug("something wrong with the execute the command", e);
		}
	}

	public static String executeShell(String[] cmds) throws IOException,
			InterruptedException {
		final Process p = Runtime.getRuntime().exec(cmds);
		int exitValue = p.waitFor();
		String line = "";
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		if (0 != exitValue) {
			br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		}
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();

		return sb.toString();
	}
}
