package java9;

import java.io.IOException;

public class MyNumber {

    public int getNatural(int input) throws IOException {

        while (true) {
            input--;
            if (input < 0 || input > 9) {
                throw new IOException("bad natural number: " + input);
            }
        }
    }

    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();
        int m, n;

        try {
            n = myNumber.getNatural(9);
            m = n * 2;
            System.out.println("Hooray! There was no exception getting " + n + ". The value of m is now: " + m);
        } catch (IOException e) {
            n=1;
            e.printStackTrace();
        }
    }
}

