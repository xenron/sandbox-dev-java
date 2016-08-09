package com.oreilly.ajax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ProductAction extends Action
{
    
    static String productsDirectory = null;
    private String getFilePath() throws FileNotFoundException, IOException{
            String resourceFilepath = this.getServlet().getServletContext().getRealPath("/shopping.properties");
            Properties configs = new Properties();
            configs.load(new FileInputStream(resourceFilepath));
            return configs.getProperty("products.directory");
    }

    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws FileNotFoundException, IOException
    {
        ProductForm productForm = (ProductForm)form;
        String productName = productForm.getProductName();
        Product product = ProductManager.getProduct(productName);
        ProductManager.setImagePath(getFilePath());
        
        productForm.setDescription(product.getDescription());
        productForm.setFilename(product.getFilename());
        productForm.setPrice(product.getPrice());
        productForm.setImagePath(getFilePath()+"/"+product.getFilename());
        productForm.setProductId(product.getProductId());
            
            Properties properties = new Properties();
            FileInputStream in = null;

          String dir = properties.getProperty("products.directory");
          
        return mapping.findForward("success");
    }
}
