package packt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Customer {

    private String emailAddress;

    public Customer(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

}
