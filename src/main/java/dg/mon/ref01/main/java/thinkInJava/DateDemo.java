package thinkInJava;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateDemo {
	  private static final String DATEFORMAT ="yyyy-MM-dd'T'HH:mm:ss'Z'";
	  
	  public static void main(String[] args)
	  {
		 final String dt = GetUTCdatetimeAsString();
System.out.println(dt);
	  }
	  
	  public static String GetUTCdatetimeAsString()
	  {
	      final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
	      sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
	      final String utcTime = sdf.format(new Date());

	      return utcTime;
	  }
}
