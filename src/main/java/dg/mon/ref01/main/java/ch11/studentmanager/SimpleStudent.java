package ch11.studentmanager;

public class SimpleStudent {
    private String name;
    private String loc;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLoc() {
        return loc;
    }
    public void setLoc(String loc) {
        this.loc = loc;
    }
    @Override
    public String toString() {
        return "SimpleUser [name=" + name + ", loc=" + loc + "]";
    }
    
    
}
