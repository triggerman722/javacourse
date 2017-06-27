package com.java9;

public class Main {

    public static void main(String[] args) {
        int n = 3;
        boolean b = true;

        if (n==3) {
            System.out.print("Hey its 3!!!!\n");
        }
        if(n!=3) {
            System.out.print("Hey its NOT 3!!!!\n");
        }
        if (n==3+14) {
            System.out.print("Hey they value is: " + n + "\n");
        } else {
            System.out.print("Oh I was hoping it was " + (3+14) + "\n");
        }
        if ((n==3) || (n<14)) {
            System.out.print("Hey its STILL 3!!!!\n");
        } else if ((n==4) && (n>=2)) {
            System.out.print("Hey its 4!!!!\n");
        } else {
            if (!b){
                System.out.print("Hey its a lof ot stuff!!!!\n");
            }else {
                System.out.print("Hey its a lof more of stuff!!!!\n");
            }
        }
    }
}
