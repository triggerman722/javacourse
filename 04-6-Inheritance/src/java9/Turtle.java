package java9;

public class Turtle {

    private boolean penDown;

    protected int x, y;

    public Turtle(int initX, int initY) {
        x = initX;
        y = initY;
        penDown = false;
    }
    public Turtle() {
    }

    public void jumpTo(int newX, int newY) {
        x = newX;
        y = newY;
    }
    public int getX() {
        return x;
    }

    public static void main(String[] args) {

        NinjaTurtle ninjaTurtle = new NinjaTurtle(100, 300, "Bart the ninja");
        System.out.println(ninjaTurtle.getX());
        ninjaTurtle.jumpTo(400, 900);
        System.out.println(ninjaTurtle.getX());
        System.out.println(ninjaTurtle.getName());
    }
}

class NinjaTurtle extends Turtle {
    private String ninjaName;
    public NinjaTurtle (int initX, int initY, String name) {
        super(initX, initY);
        ninjaName = name;
    }
    public String getName() {
        return ninjaName;
    }
}
