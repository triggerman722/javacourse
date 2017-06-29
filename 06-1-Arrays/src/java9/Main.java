package java9;

public class Main {

    public static void main(String[] args) {

        int [] someInts;
        Turtle [] turtleFarm;

        someInts = new int[30];
        turtleFarm = new Turtle[100];

        int i;
        for (i = 0; i < someInts.length; i = i + 1) {
            someInts[i] = i * i;
            System.out.println(someInts[i]);
        }
    }
}
