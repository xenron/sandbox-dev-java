package packt;

import java.util.Properties;

public class ConnectionProperties {
    private String user;
    private String password;
    Properties properties = new Properties();

    public ConnectionProperties user(String user) {
        this.user = user;
        properties.setProperty("user", this.user);
        return this;
    }

    public ConnectionProperties password(String password) {
        this.password = password;
        properties.setProperty("password", this.password);
        return this;
    }

    public Properties properties() {
        return properties;
    }
}
