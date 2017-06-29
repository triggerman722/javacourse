package java9;

public class Main {

    public static void main(String[] args) {
        Beaver beaver = new Beaver();
        System.out.println(beaver.getName());
        Sparrow sparrow = new Sparrow();
        System.out.println(sparrow.getFursmoothness());
    }
}

class Animal {
    private String name = "";
    protected String furSmoothness = "";
    public String hoofSize = "";
    private String color = "";

    public String getColor() {
        return this.color;
    }
}

class Beaver {
    public String getName() {
        Animal animal = new Animal();
        String name = "";
        //name = animal.name; //this fails because name is declared as private only to the internal methods of the Animal class.
        return name;
    }

    public String getColor() {
        Animal animal = new Animal();
        String color = animal.getColor();
        return color;
    }

    public String getFurSmoothness() {
        Animal animal = new Animal();
        animal.furSmoothness = "4";
        return animal.furSmoothness;
    }

    public String getHoofSize() {
        Animal animal = new Animal();
        animal.hoofSize = "4";
        return animal.hoofSize;
    }
}

//Sparrow is a "sub-class" of Animal.
class Sparrow extends Animal {
    public String getName() {
        String sparrowName = "";
        //sparrowName = name; //this still fails, even though Sparrow is a sub class of Animal. "private" is NOT shared with any other class.
        return sparrowName;
    }

    public String getFursmoothness() {
        return furSmoothness; // this works because furSmoothness is declared as protected in the Animal class, and "protected" means sub classes can access it.
    }

    public String getHoofsize() {
        return hoofSize; // this works because hoofSize is declared as public in the Animal class.
    }
}