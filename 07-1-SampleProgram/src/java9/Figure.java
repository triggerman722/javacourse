package java9;

import java.awt.*;
/**
 * Simple abstract class for graphic figures that can be drawn in windows.
 */
abstract class Figure {
    /**
     * Constructor: takes two parameters, the X and Y coordinates.
     */
    public Figure(int inX, int inY) {
        x = inX;
        y = inY;
    }
    /**
     * Abstract method for drawing this thing.
     *
     * The g parameter is a ’pen’ that can be used to draw things
     * in the window.
     */
    public abstract void draw(Graphics g);
    /**
     * Move the figure to (newX, newY).
     */
    public void move(int newX, int newY) {
        x = newX;
        y = newY;
    }
    protected int x, y; // X and Y coordinates
}