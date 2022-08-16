package com.example.utils;

public class Utilidades {

    public static void waitInMs(Integer milliseconds)  {
        try {
           Thread.sleep(milliseconds);
        } catch (Exception e) {}
    }

}
