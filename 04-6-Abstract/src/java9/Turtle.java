package java9;

public abstract class Turtle {

    private boolean penDown;

    protected int x, y;

    public Turtle(int initX, int initY) {
        x = initX;
        y = initY;
        penDown = false;
    }
    public Turtle() {
    }

    public abstract void jumpTo(int newX, int newY);

    public int getX() {
        return x;
    }

    public static void main(String[] args) {
        NinjaTurtle ninjaTurtle = new NinjaTurtle(300, 600, "Mary the ninjess");
        System.out.println(ninjaTurtle.getX());
        ninjaTurtle.jumpTo(401, 960);
        System.out.println(ninjaTurtle.getX());
        System.out.println(ninjaTurtle.getName());

        Turtle t = new Turtle() {
            @Override
            public void jumpTo(int newX, int newY) {
                System.out.println("Ohhhhh, man this is dangerous...");
            }
        };
        t.jumpTo(566, 46);
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

    @Override
    public void jumpTo(int newX, int newY) {
        x = x + newX;
        y+=newY; //different syntax, same mathematical operation
    }
}
