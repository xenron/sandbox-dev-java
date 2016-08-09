package com.ensode.glassfishbook.jaxrsclient;

/**
 *
 * @author heffel
 */
public class Main1 {

    public static void main(String[] args) {
        NewJerseyClient newJerseyClient = new NewJerseyClient();

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
        + "<customer>"
        + "<customerId>2</customerId>"
        + "<email>jjones@example.com</email>"
        + "<firstName>John</firstName>"
        + "<lastName>Jones</lastName>"
        + "<middleName>Jason</middleName>"
        + "</customer>";
        newJerseyClient.create_XML(xml);

        newJerseyClient.close();
    }
}
