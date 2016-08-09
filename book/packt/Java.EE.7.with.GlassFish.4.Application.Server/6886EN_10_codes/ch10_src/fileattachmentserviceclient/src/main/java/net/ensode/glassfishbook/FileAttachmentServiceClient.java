package net.ensode.glassfishbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.xml.ws.WebServiceRef;

public class FileAttachmentServiceClient {

  @WebServiceRef(wsdlLocation = "http://localhost:8080/fileattachmentservice/"
  + "FileAttachmentService?wsdl")
  private static FileAttachmentService fileAttachmentService;

  public static void main(String[] args) {
    FileAttachment fileAttachment = fileAttachmentService.
        getFileAttachmentPort();
    File fileToAttach = new File("src/main/resources/logo.gif");

    byte[] fileBytes = fileToByteArray(fileToAttach);

    fileAttachment.attachFile(fileBytes);
    System.out.println("Successfully sent attachment.");
  }

  static byte[] fileToByteArray(File file) {
    byte[] fileBytes = null;

    try {
      FileInputStream fileInputStream;
      fileInputStream = new FileInputStream(file);

      FileChannel fileChannel = fileInputStream.getChannel();
      fileBytes = new byte[(int) fileChannel.size()];
      ByteBuffer byteBuffer = ByteBuffer.wrap(fileBytes);
      fileChannel.read(byteBuffer);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return fileBytes;
  }
}
