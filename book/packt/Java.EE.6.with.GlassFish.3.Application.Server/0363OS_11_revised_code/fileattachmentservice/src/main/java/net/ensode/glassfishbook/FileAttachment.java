package net.ensode.glassfishbook;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class FileAttachment {

  @WebMethod
  public void attachFile(DataHandler dataHandler) {
    FileOutputStream fileOutputStream;
    try {

      // substitute "/tmp/attachment.gif" with
      // a valid path, if necessary.
      fileOutputStream = new FileOutputStream(
          "/tmp/attachment.gif");

      dataHandler.writeTo(fileOutputStream);

      fileOutputStream.flush();
      fileOutputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
