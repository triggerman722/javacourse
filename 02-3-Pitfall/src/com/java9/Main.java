package com.java9;

public class Main {

    public static void main(String[] args) {
        double f;
        f = 1 / 3;
        System.out.println("I expect 'f' will equal 0.33333, but it really equals: " + f);
        f = 1.0 / 3.0;
        System.out.println("I expect 'f' will equal 0.33333, and now it DOES really equal: " + f);
        f = 1f / 3f;
        System.out.println("I expect 'f' will equal 0.33333, but now it KINDA equals: " + f);
    }
}
