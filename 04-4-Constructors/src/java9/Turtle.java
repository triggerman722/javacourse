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
        Turtle t;
        t = new Turtle();

        int a = t.getX();
        System.out.println(t.getX());

        t.jumpTo(300, 200);
        System.out.println(t.getX());

        t.jumpTo(108, 17);
        System.out.println(t.getX());

        Turtle t2;
        t2 = new Turtle(100, 200);

        a = t2.getX();
        System.out.println(t2.getX());

        t2.jumpTo(400, 200);
        System.out.println(t2.getX());

        t2.jumpTo(808, 17);
        System.out.println(t2.getX());
    }
}

