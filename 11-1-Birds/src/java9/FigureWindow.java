package java9;

import java.awt.*;

/**
 * A simple window to display graphic figures in. The window is a subclass
 * of the Java ’Frame’ class, which describes graphic windows. The window
 * keeps its figures in an array.
 * <p>
 * The Java window system (AWT) automatically calls the paint method in
 * the Frame class whenever the window’s contents need to be redrawn. A
 * new implementation of paint is provided in FigureWindow to handle the
 * drawing.
 */
class FigureWindow extends Frame {
    /**
     * Constructor: the parameter indicates the maximal number of figures.
     */
    public FigureWindow(int max) {
        super("Fabulous Figures"); // Window title
        figures = new Figure[max];
        nbrOfFigures = 0;
    }

    /**
     * Add the figure f to the window. If the maximal number of figures has
     * been reached, nothing happens.
     */
    public void addFigure(Figure f) {
        if (nbrOfFigures < figures.length) {
            figures[nbrOfFigures] = f;
            nbrOfFigures++;
        }
    }

    /**
     * This method is called automatically by the system. Draws the
     * raphic figures associated with the window.
     * <p>
     * The g parameter is a drawing ’pen’ provided by the system.
     */
    public void paint(Graphics g) {
        int i;
        for (i = 0; i < nbrOfFigures; i++) {
            figures[i].draw(g);
        }
    }

    // Array of graphic figures
    private Figure[] figures;
    // Current number of figures
    private int nbrOfFigures;

    /**
     * Main method: creates a FigureWindow and a few figures inside it.
     */
    public static void main(String[] args) {
        FigureWindow w = new FigureWindow(10);
        w.setSize(800, 600);
        w.addFigure(new Square(50, 50, 200));
        w.addFigure(new Circle(200, 100, 150));
        w.addFigure(new Circle(300, 200, 200));

        //TODO: Add and draw a triangle.

        w.show();
    }
}