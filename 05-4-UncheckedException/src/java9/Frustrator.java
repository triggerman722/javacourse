package java9;

public class Frustrator {
    private int frustrationLevel = 0;
    public int poke(int input) {
        return 14/0;
    }
    public static void main(String[] args) {
        Frustrator frustrator = new Frustrator();
        try {
            frustrator.poke(0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
}


