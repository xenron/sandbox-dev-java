package ch11.studentmanager;

public class Student {
    private int id;
    private String name;
    private int sex;
    private String location;

    public Student(){}
    
    public Student(String name, int sex, String location) {
        super();
        this.name = name;
        this.sex = sex;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", location=" + location + "]";
    }
    
    
}
