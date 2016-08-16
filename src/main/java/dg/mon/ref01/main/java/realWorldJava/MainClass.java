package realWorldJava;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import Utils.*;

public class MainClass {

	
	private String utc2LocalDate(String utcDate){
		final SimpleDateFormat utc = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		utc.setTimeZone(TimeZone.getTimeZone("GMT"));
		final SimpleDateFormat local = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		try {
			return local.format(utc.parse(utcDate));
		} catch (ParseException e) { 
			 e.printStackTrace();
		}
		return "";
	}

	private String getMsg(AlarmMsgEntity entity) {
		FreemarkerUtil fu = FreemarkerUtil.getInstance("/ftl");
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("busName", entity.getBusName());
		root.put("host", entity.getHost());
		root.put("ip", entity.getIp());
		root.put("filePath", entity.getPath());
		root.put("keyWord", entity.getKeyword());
		root.put("timestamp", utc2LocalDate(entity.getTimestamp()));
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		fu.streamprint(root, "sms.ftl", bout);
		
		return bout.toString();
	}

	public static void main(String[] args) throws Exception {
		final String filepath = "/home/student/git/learningJava/src/main/resources/jsons.txt";
		String str = FileUtils.readFileToString(new File(filepath), "UTF-8");
		// System.out.println(str);
		AlarmMsgEntity entity = JsonUtil.getInstance().json2Obj(str,
				AlarmMsgEntity.class);
		System.out.println(ReflectionToStringBuilder.toString(entity,
				ToStringStyle.MULTI_LINE_STYLE));
		MainClass mc = new MainClass();
		System.out.println(mc.getMsg(entity));
	}
	
}
