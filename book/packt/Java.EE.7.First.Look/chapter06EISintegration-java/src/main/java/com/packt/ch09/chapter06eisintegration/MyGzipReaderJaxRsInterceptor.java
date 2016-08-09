/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch09.chapter06eisintegration;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

/**
 *
 * @author Administrator
 */
public class MyGzipReaderJaxRsInterceptor implements ReaderInterceptor {

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException {           
        try (InputStream inputStream = context.getInputStream();) {
            context.setInputStream(new GZIPInputStream(inputStream));
            return context.proceed();            
        }       
    }    
}
