package realWorldJava;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.redis.core.RedisTemplate;

import Utils.SpringUtils;

public class TestJson {

	public static void main(String[] args) throws IOException {
		final String filepath = "/home/student/git/learningJava/src/main/resources/jsons.txt";
		String str = FileUtils.readFileToString(new File(filepath), "UTF-8");
		// System.out.println(str);
		AlarmMsgEntity entity = JsonUtil.getInstance().json2Obj(str,
				AlarmMsgEntity.class);
		System.out.println(ReflectionToStringBuilder.toString(entity,
				ToStringStyle.MULTI_LINE_STYLE));
		// save json string to list to redis
		String listName = "Alert_Msg_List";
		@SuppressWarnings({ "unchecked" })
		RedisTemplate<String, String> jedisTemplate = (RedisTemplate<String, String>) SpringUtils
				.getBean("jedisTemplate");
		for (int i = 0; i < 10; i++)
			jedisTemplate.opsForList().leftPush(listName, str);
	}
}
