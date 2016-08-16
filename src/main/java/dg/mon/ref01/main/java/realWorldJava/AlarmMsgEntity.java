package realWorldJava;

import java.io.Serializable;

public class AlarmMsgEntity implements Serializable {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 9999L;
	private String path;
	private String keyword;
	private String host;
	private String ip;
	private String index;
	private String message;
	private String timestamp;
	private String risk;
	private String busName;
	private String spark_receive_at;
	
	public String getRedisKey()
	{ 
		return "AlarmTransfer:" + busName + risk;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getRisk() {
		return risk;
	}
	public void setRisk(String risk) {
		this.risk = risk;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getSpark_receive_at() {
		return spark_receive_at;
	}
	public void setSpark_receive_at(String spark_receive_at) {
		this.spark_receive_at = spark_receive_at;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	 
}
