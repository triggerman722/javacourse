package java9;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int score = new Random().nextInt(100);
        switch (score) {
            case 100:
                System.out.println("Perfect score! " + score );
                break;
            case 99:
            case 98:
            case 97:
            case 96:
            case 95:
            case 94:
            case 93:
            case 92:
            case 91:
            case 90:
                System.out.println("You got an A+! " + score );
                break;
            case 0:
                System.out.println("You suck! " + score);
                break;
            default:
                System.out.println("You are not awesome: " + score);
        }

    }
}
