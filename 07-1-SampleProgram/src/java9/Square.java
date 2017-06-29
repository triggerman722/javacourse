package java9;

import java.awt.*;
/**
 * A square that can be drawn in a window. The coordinates represent the
 * upper left corner of the square.
 */
class Square extends Figure {
    /**
     * Constructor: first two parameters are the coordinates, the third is
     * the side.
     */
    public Square(int inX, int inY, int inSide) {
        super(inX, inY);
        side = inSide;
    }
    /**
     * Drawing method for squares.
     */
    public void draw(Graphics g) {
        g.drawRect(x, y, side, side);
    }
    private int side; // Square side
}