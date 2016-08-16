package  realWorldJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

public class SSHExecUtil {
	protected static final Log logger = LogFactory.getLog(SSHExecUtil.class);
	private static SSHExecUtil instance = null; 
	private static final String LANG = "en_US.UTF-8";
	private static final String PTY_TYP = "VT100";
	private static final String CHAR_SET = "UTF-8";
	public  static final int DEFAULT_SSH_PORT = 22;
	private static final int TIMEOUT = 30000;
	private static final String CHANNEL_TYPE = "exec";
	
	private SSHExecUtil(){
		
	}
	
	public static SSHExecUtil getInstance() {
		if (instance == null) { 
			synchronized (SSHExecUtil.class) {
				if (instance == null) {
					instance = new SSHExecUtil();
				}
			}
		}
		return instance;
	}
	

	public Session getSession(String hostIp, String userName, String password) throws Exception {
		return this.getSession(hostIp, DEFAULT_SSH_PORT, userName, password);
	}

	public Session getSession(String hostIp, int port, String userName, String password) throws Exception {
		JSch jsch = new JSch();
		UserInfo userInfo = new CustomUserInfo(password);
		Session session = jsch.getSession(userName, hostIp, port);
		session.setUserInfo(userInfo);
		session.setPassword(password);
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		session.connect(TIMEOUT);
		return session;
	}
	
	public Session getSession2(String hostIp,String userName,String filePath) throws JSchException  
	{
		JSch jsch = new JSch();
		jsch.addIdentity(filePath,"passphrase");
	    Session session=jsch.getSession(userName, hostIp, 22);
	    UserInfo ui=new CustomUserInfo();
	    session.setUserInfo(ui);
	    session.connect();
	     
	    Channel channel=session.openChannel("shell");
	    channel.setInputStream(System.in);
	    channel.setOutputStream(System.out); 
	    channel.connect();
	    
	    
	    return session;
	}
	
	
	public ChannelExec getChannelExec(Session session) throws JSchException{
		Channel channel = session.openChannel(CHANNEL_TYPE);
		ChannelExec channelExec = (ChannelExec) channel;
		channelExec.setPtyType(PTY_TYP);
    	channelExec.setEnv("LANG", LANG);
		return channelExec;
	}
	 
    public String execCommand(ChannelExec channelExec, String command) {  
        StringBuffer result = new StringBuffer();  
        try {  
        	
        	if(!command.endsWith("\n")){
        		command+="\n";
        	}
        	
    		InputStream in = channelExec.getInputStream();
    		channelExec.setCommand(command);
    		channelExec.connect();
    		
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));  
              
            String line = "";  
            while ((line = reader.readLine()) != null) {  
                result.append(new String(line.getBytes(CHAR_SET), CHAR_SET)).append("\n");  
            } 
        } catch (JSchException | IOException e) {  
            logger.error(e);
        } finally{
            if (channelExec != null && !channelExec.isClosed()) {  
            	channelExec.disconnect();  
            }  
        }
        return result.toString();  
    }  
    
    public void closeChannelExec(ChannelExec channelExec) {
    	if (channelExec != null && !channelExec.isClosed()){
    		channelExec.disconnect();
		}
    } 
    
    public void closeSession(Session session){  
        if (session != null && session.isConnected()) {  
            session.disconnect();  
        }  
    }  
	
	public static class CustomUserInfo implements UserInfo, UIKeyboardInteractive {
		private String passphrase = "";  
	    public CustomUserInfo(String passphrase ){  
	        this.passphrase = passphrase;  
	    } 
	    
		public CustomUserInfo() { 
		}

		public String getPassphrase() {   
			return this.passphrase;
	    }

	    public String getPassword() {
	    	return this.passphrase;
	    }

	    public boolean promptPassphrase(String message) {
	        return false;
	    }

	    public boolean promptPassword(String message) {
	        return false;
	    }

	    public boolean promptYesNo(String message) {
	        return true;
	    }

	    public void showMessage(String message) {
	    }

	    public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt, boolean[] echo) {
	        return null;
	    }
	}

}
