package java9;

import java.io.IOException;

public class MyNumber {

    public int getNatural(int i) throws IOException {
        return 140/i;
    }

    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();
        int m, n;

        try {
            n = myNumber.getNatural(22);
            m = n * 2;
            System.out.println("Hooray! There was no exception getting " + n + ". The value of m is now: " + m);
        } catch (IOException e) {
            n=1;
            e.printStackTrace();
        }
        try {
            n = myNumber.getNatural(0);
            m = n * 2;
            System.out.println("Hooray! There was no exception getting " + n + ". The value of m is now: " + m);
        } catch (IOException e) {
            n=1;
            e.printStackTrace();
        }
    }
}

