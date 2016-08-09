package packt;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Locale.Builder;

public class HandlingLocalesAndTheLocaleBuilderClassInJava7 {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setWeekDate(2012, 16, 3);

        Builder builder = new Builder();
        builder.setLanguage("hy");
        builder.setScript("Latn");
        builder.setRegion("IT");
        builder.setVariant("arevela");

        Locale locale = builder.build();
        Locale.setDefault(locale);

        System.out.println(DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.LONG).format(calendar.getTime()));
        System.out.println("" + locale.getDisplayLanguage());

        
        builder.setLanguage("zh");
        builder.setScript("Hans");
        builder.setRegion("CN");

        locale = builder.build();
        Locale.setDefault(locale);

        System.out.println(DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.LONG).format(calendar.getTime()));
        System.out.println("" + locale.getDisplayLanguage());  
        
        // Using the Locale.Category enumeration to display 
        // information using two different locales
//        Locale locale = Locale.getDefault();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setWeekDate(2012, 16, 3);
//        
//        System.out.println(DateFormat.getDateTimeInstance(
//            DateFormat.LONG, DateFormat.LONG).format(calendar.getTime()));
//        System.out.println("" + locale.getDisplayLanguage());
//        
//        Locale.setDefault(Locale.Category.FORMAT, Locale.JAPANESE);
//        Locale.setDefault(Locale.Category.DISPLAY, Locale.GERMAN);
// 
//        System.out.println(DateFormat.getDateTimeInstance(
//            DateFormat.LONG, DateFormat.LONG).format(calendar.getTime()));   
//        System.out.println("" + locale.getDisplayLanguage());
        
    }
}
