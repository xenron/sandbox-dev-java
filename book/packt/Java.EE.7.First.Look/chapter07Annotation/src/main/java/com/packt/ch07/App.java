package com.packt.ch07;

import com.packt.ch07.annotations.Unfinished;


public class App {

    @Unfinished(message = "Make sure that this element is not null")
    String size;

    @Unfinished
    public static void main(String[] args) {
        System.out.println("Hello World annotation!");
    }
}
