package packt;

import java.util.Date;

final public class Header {
    private final String title;
    private final int version;
    private final Date date;

    public Date getDate() {
        return new Date(date.getTime());
    }

    public String getTitle() {
        return title;
    }

    public int getVersion() {
        return version;
    }
    
    public Header(String title, int version, Date date) {
        this.title = title;
        this.version = version;
        this.date = new Date(date.getTime());
    }
    
    public String toString() {
        return  "Title: " + this.title + "\n" +
                "Version: " + this.version + "\n" +
                "Date: " + this.date + "\n";
    }
}
