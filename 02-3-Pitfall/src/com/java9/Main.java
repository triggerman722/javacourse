package com.java9;

public class Main {

    public static void main(String[] args) {
        double f;
        f = 1 / 3;
        System.out.print("I expect 'f' will equal 0.33333, but it really equals: " + f + "\n");
        f = 1.0 / 3.0;
        System.out.print("I expect 'f' will equal 0.33333, and now it DOES really equal: " + f + "\n");
        f = 1f / 3f;
        System.out.print("I expect 'f' will equal 0.33333, but now it KINDA equals: " + f + "\n");
    }
}
