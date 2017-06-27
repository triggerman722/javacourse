package java9;

/*
 The public keyword is used to declare that something
 can be accessed from other classes.
 */
public class Turtle {

    /*
     * The private declaration means that those attributes cannot be
     * accessed outside of the class. In general, attributes should
     * be kept private to prevent other classes from accessing them
     * directly.
     */
    private boolean penDown;

    /*
     * The protected keyword specifies that something can be accessed
     * from within the class and all its subclasses, but not from the
     * outside.
     */
    protected int x, y;
}

