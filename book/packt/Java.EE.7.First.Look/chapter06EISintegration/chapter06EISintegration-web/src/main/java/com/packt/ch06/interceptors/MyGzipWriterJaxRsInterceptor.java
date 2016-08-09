/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06.interceptors;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

/**
 *
 * @author Administrator
 */
@ZipResult
@Provider
public class MyGzipWriterJaxRsInterceptor implements WriterInterceptor{  
    
    @Override
    public void aroundWriteTo(WriterInterceptorContext wic) throws IOException {        
        try (GZIPOutputStream gzipStream = new GZIPOutputStream(wic.getOutputStream());) {
            wic.setOutputStream(gzipStream);   
            wic.proceed();
        }        
    }
}
