/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.servlet.nonblockingio;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

/**
 *
 * @author Administrator
 */
public class ReadListenerImpl implements ReadListener {

    AsyncContext context;
    ServletInputStream input;

    public ReadListenerImpl(AsyncContext c, ServletInputStream i) {
        this.context = c;
        this.input = i;
    }

    @Override
    public void onDataAvailable() throws IOException {
        int data;
        byte b[] = new byte[3072];
        while (input.isReady()
                && (data = input.read(b)) != -1) {
            //...
        }
    }

    @Override
    public void onAllDataRead() throws IOException {
        System.out.println("onAllDataRead");
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("onError : " + t.getMessage());
    }
}
