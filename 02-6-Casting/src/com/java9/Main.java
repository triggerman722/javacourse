package com.java9;

public class Main {

    public static void main(String[] args) {
        double radians = 0;
        int degrees = 0 ;
        Object blob = 0;

        //Un-comment the next line to see what happens.
        //degrees = radians * 180 / 3.141592653; // Error

        degrees = (int) (radians * 180 / 3.141592653);
        System.out.println("The result is: " + degrees);

        blob = radians * 180 / 3.141592653;
        System.out.println("The result is: " + blob);
    }
}
