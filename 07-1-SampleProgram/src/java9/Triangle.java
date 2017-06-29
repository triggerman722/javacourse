package java9;


import java.awt.*;

/**
 * Triangle class. The coordinates represent the circle’s center.
 */
class Triangle extends Figure {
    /**
     * Constructor: the first two parameters are the coordinates,
     * the third is the height.
     */
    public Triangle(int inX, int inY, int inDiam) {
        super(inX, inY);
        d = inDiam;
    }

    /**
     * Drawing method for Triangles.
     */
    public void draw(Graphics g) {
        g.drawLine(x, y, x+d, y);
        g.drawLine(x, y, x+(d/2), y-d);
        g.drawLine(x+(d/2), y-d, x+d, y);
    }

    private int d; // Triangle height
}