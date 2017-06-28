package java9;

public class Turtle {

    private boolean penDown;

    protected int x, y;

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
    }
}

