package dg.mon.hw;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String sizeFormat(long length) {
        long kb;
        if (length < 1024)
        {
            return String.valueOf(length);
        }
        else if ((kb = length / 1024) < 1024)
        {
            return (String.valueOf(kb) + "kb");
        }
        else
        {
            return (String.valueOf(length / 1024 / 1024) + "kb");
        }
    }

    public static String getSimpleDateString(long date) {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date(date));
    }
}
