package com.oreilly.ajax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class UploadAction extends Action
{
  
static String productsDirectory = null;

private String getFilePath() throws FileNotFoundException, IOException{
        String resourceFilepath = this.getServlet().getServletContext().getRealPath("/shopping.properties");
        Properties configs = new Properties();
        configs.load(new FileInputStream(resourceFilepath));
        String dir = this.getServlet().getServletContext().getRealPath("")+"/"+configs.getProperty("products.directory");
        return dir;
}
    
  public ActionForward execute(
      ActionMapping mapping,
      ActionForm form,
      HttpServletRequest request,
      HttpServletResponse response) throws Exception
  {
    UploadForm myForm = (UploadForm)form;
    int productId = myForm.getProductId();
    
    // Process the FormFile
    FormFile myFile = myForm.getUploadFile();
    String fileName = myFile.getFileName();
    byte[] fileData = myFile.getFileData();

    FileOutputStream out = new FileOutputStream(getFilePath()+"/"+fileName);

    out.write(fileData);
    out.close();
    ProductManager.updateProductById(productId,"FILENAME",fileName);

    return mapping.findForward("success");
  }
}