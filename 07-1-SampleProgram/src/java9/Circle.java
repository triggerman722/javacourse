package java9;

import java.awt.*;
/**
 * Circle class. The coordinates represent the circle’s center.
 */
class Circle extends Figure {
    /**
     * Constructor: the first two parameters are the coordinates,
     * the third is the diameter.
     */
    public Circle(int inX, int inY, int inDiam) {
        super(inX, inY);
        d = inDiam;
    }
    /**
     * Drawing method for circles.
     */
    public void draw(Graphics g) {
        g.drawOval(x, y, d, d);
    }
    private int d; // Circle diameter
}