package com.java9;

public class Main {

    public static void main(String[] args) {
        int n = 3;
        boolean b = true;

        if (n==3) {
            System.out.println("Hey its 3!!!!");
        }
        if(n!=3) {
            System.out.println("Hey its NOT 3!!!!");
        }
        if (n==3+14) {
            System.out.println("Hey they value is: " + n);
        } else {
            System.out.println("Oh I was hoping it was " + (3+14));
        }
        if ((n==3) || (n<14)) {
            System.out.println("Hey its STILL 3!!!!");
        } else if ((n==4) && (n>=2)) {
            System.out.println("Hey its 4!!!!");
        } else {
            if (!b){
                System.out.println("Hey its a lof ot stuff!!!!");
            }else {
                System.out.println("Hey its a lof more of stuff!!!!");
            }
        }

        int x=0, y=0;

        if ((x <= 9 || y > 3) && !b) {
            b = true;
        }
    }
}
