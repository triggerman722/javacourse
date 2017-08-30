package java9;

/*
 The public keyword is used to declare that something
 can be accessed from other classes.
 */
public class Turtle2 {

    /*
     * The private declaration means that those attributes cannot be
     * accessed outside of the class. In general, attributes should
     * be kept private to prevent other classes from accessing them
     * directly.
     */
    private boolean isColdBlooded;

    /*
     * The protected keyword specifies that something can be accessed
     * from within the class and all its subclasses, but not from the
     * outside.
     */
    protected int x, y;

    // The "jumpTo" method accepts two integers - newX and newY,
    // which are referred to as "parameters".
    // When "jumpTo" is called, these two integer values must be provided
    // to this method by the caller.
    public void jumpTo(int newX, int newY) {
        x = newX;
        y = newY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

