package java9;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[4];
        animals[0] = new Fish();
        animals[1] = new Spider();
        animals[2] = new Bird();
        animals[3] = new Hare();
        for (int i = 0; i < animals.length; i++) {
            animals[i].move();
        }
    }
}
class Animal {
    public void move() {
        System.out.println("The animal is moving");
    }
}
class Bird extends Animal {
    public void move() {
        System.out.println("The bird is flying");
    }
}
class Fish extends Animal {
    public void move() {
        System.out.println("The fish is swimming");
    }
}
class Spider extends Animal {
    public void move() {
        System.out.println("The spider is crawling");
    }
}
class Hare extends Animal {
    public void move() {
        System.out.println("The hare is running");
    }
}