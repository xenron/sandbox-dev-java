package ch6;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Utils.EncryptionUtil;

public class test {
	public static void main(String[] args) throws ParseException {
		String abc="abc | def ";
		String str1 = abc.split("\\|")[0];
		String str2 = abc.split("\\|")[1];
		System.out.println(str1);
		System.out.println(str2);
		
		try {
			String xxx = EncryptionUtil.md5("/home/student/abc def.log");
			System.out.println(xxx);
			System.out.println(xxx.length());
		} catch (NoSuchAlgorithmException e) { 
			e.printStackTrace();
		}
		
	}
	
	private static boolean checkValidDate(String _st,String _et) {
		boolean ret = false;
		try{
		    String st = _st;
		    Date time1 = new SimpleDateFormat("HH:mm").parse(st);
		    Calendar calendar1 = Calendar.getInstance();
		    calendar1.setTime(time1); 

		    String et = _et;
		    Date time2 = new SimpleDateFormat("HH:mm").parse(et);
		    Calendar calendar2 = Calendar.getInstance();
		    calendar2.setTime(time2); 
		    //calendar2.add(Calendar.DATE, 1);
		    
		    Calendar calendar3 = Calendar.getInstance();   
		    String currentTime = new SimpleDateFormat("HH:mm").format(new Date());
		    Date ct = new SimpleDateFormat("HH:mm").parse(currentTime);
		    calendar3.setTime(ct);
		    //calendar3.add(Calendar.DATE,1);
		    
		    
		    System.out.println(calendar1.getTime());
		    System.out.println(calendar2.getTime());
		    System.out.println(ct);
		    if (ct.after(calendar1.getTime()) && ct.before(calendar2.getTime())) { 
		        ret  = true;
		    } 
		 }
		 catch(ParseException pe)
		 {
			 pe.printStackTrace();
		 }
		return ret;
	}  
}
