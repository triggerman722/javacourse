package java9;

public class Frustrator {
    private int frustrationLevel = 0;
    public void poke(int input) throws OverheatedException {
        frustrationLevel++;
        if (frustrationLevel>=90) {
            throw new OverheatedException("I AM FRUSTRATED", 80.0);        
        }
    }
    public static void main(String[] args) {
        Frustrator frustrator = new Frustrator();
        int i=0;
        try {
            for (i=0;i<100;i++) {
                frustrator.poke(i);    
            }
            System.out.println("Hooray! There was no exception after " + i + " pokes.");
        } catch (OverheatedException e) {
            System.out.println("Error at i value of " + i + ". Overheated to a temp of: " + e.getTemperature() + " and with the message: " + e.getMessage());
            e.printStackTrace();
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

