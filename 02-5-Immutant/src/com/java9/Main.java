package com.java9;

public class Main {

    public static void main(String[] args) {
        final String Mutant = "Mutant";
        System.out.print(Mutant + "\n");

        //Un-comment the following line to see what happens.
        //Mutant = "Sally";
        System.out.print(Mutant + "\n");

        //Un-comment the following line to see what happens.
        //Mutant = "Gunther";
        System.out.print(Mutant + "\n");

        final String NewMutant = Mutant + " is a fun guy!";
        System.out.print(NewMutant + "\n");

        String AnotherMutant = NewMutant + " Very Nice";
        System.out.print(AnotherMutant + "\n");

        AnotherMutant = "Whoops, all gone.";
        System.out.print(AnotherMutant + "\n");
    }
}
