package java9;

import java.util.ArrayList;
import java.util.List;

interface MouseListener {
    void processMouseClick(int x, int y);
}
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

        NinjaTurtle ninjaTurtle = new NinjaTurtle(100, 300, "Bart the ninja");
        WindowSystem windowSystem = new WindowSystem();
        windowSystem.addMouseListener(ninjaTurtle);
        windowSystem.click(45, 22);
    }
}

class NinjaTurtle extends Turtle implements MouseListener{
    private String ninjaName;
    public NinjaTurtle (int initX, int initY, String name) {
        super(initX, initY);
        ninjaName = name;
    }
    public String getName() {
        return ninjaName;
    }

    @Override
    public void processMouseClick(int x, int y) {
        System.out.println("I didn't really get called directly...");
    }
}

class WindowSystem {
    private List<MouseListener> mouseListenerList = new ArrayList<>();

    public void addMouseListener(MouseListener m) {
        mouseListenerList.add(m);
    }
    public void click(int x, int y) {
        for (MouseListener mouse : mouseListenerList) {
            mouse.processMouseClick(x, y);
        }
    }
}