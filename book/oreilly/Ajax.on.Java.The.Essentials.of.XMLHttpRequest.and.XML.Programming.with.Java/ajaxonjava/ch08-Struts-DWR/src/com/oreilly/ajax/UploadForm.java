package com.oreilly.ajax;

import org.apache.struts.action.*;
import org.apache.struts.upload.FormFile;

public class UploadForm extends ActionForm
{
    private FormFile uploadFile;

    private int productId;

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public FormFile getUploadFile()
    {
        return uploadFile;
    }

    public void setUploadFile(FormFile uploadFile)
    {
        this.uploadFile = uploadFile;
    }
}