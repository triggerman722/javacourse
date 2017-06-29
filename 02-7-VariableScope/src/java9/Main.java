package java9;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal(0, 0);
        System.out.println(animal.getPreferredSeason("summer"));
    }
}

class Animal {
    private String soundMade = "oink"; //Instance variable.
    public Animal(int legs, int height) {
        //"legs" and "height" are "argument" variables.
    }
    public String getPreferredSeason(String currentSeason) {
        String autumn = "autumn"; //"local" variable
        String winter = "winter"; //"local" variable
        String spring = "spring"; //"local" variable
        String summer = "summer"; //"local" variable

        if (currentSeason.equalsIgnoreCase(summer)) { //currentSeason is an argument variable, but it is accessible to the if block because it too is being passed in as an argument (to the if block itself)
            String response = "This animal LOVES: "; // "local" variable, and it only exists within this if block.
            response += summer + "!! "; //"summer" is allowed to be passed into this if block because it was declared at a higher level.
            response += soundMade.toUpperCase() + ", " + soundMade.toUpperCase() + "! It says with glee!";
            return response;
        }
        //return response; // this will cause an error because "response" was only valid inside the if block.
        for (int i=0;i<6;i++) //"i" is declared with the scope of the "for" block.
        {
            System.out.println(i); //"i" can be referenced within the for block...
        }
        //i = i+1; //...but "i" is no longer valid outside of the for block.
        return autumn;
    }
}
