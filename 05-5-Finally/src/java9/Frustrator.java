package java9;

public class Frustrator {
    private int frustrationLevel = 0;

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    private boolean isConnected = false;

    public void poke(int input) throws OverheatedException {
        frustrationLevel++;
        if (frustrationLevel>=90) {
            throw new OverheatedException("I AM FRUSTRATED", 80.0);        
        }
    }
    public static void main(String[] args) {
        Frustrator frustrator = new Frustrator();
        frustrator.setConnected(true);
        int i=0;
        try {
            for (i=0;i<100;i++) {
                frustrator.poke(i);    
            }
            System.out.println("Hooray! There was no exception after " + i + " pokes.");
        } catch (OverheatedException e) {
            System.out.println("True or false: Most people leave connections open after an exception: " + frustrator.isConnected());
        } finally {
            frustrator.setConnected(false);
            System.out.println("True or false: Most people leave connections open after an exception: " + frustrator.isConnected());
        }
    }
}

class OverheatedException extends Exception {
    public OverheatedException(String s, double temp) {
        super(s);
        myTemperature = temp;
    }
    public double getTemperature() {
        return myTemperature;
    }
    private double myTemperature;
}

