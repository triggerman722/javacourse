package com.java9;

public class Main {

    public static void main(String[] args) {
        final String Mutant = "Mutant";
        System.out.println(Mutant);

        //Un-comment the following line to see what happens.
        //Mutant = "Sally";
        System.out.println(Mutant);

        //Un-comment the following line to see what happens.
        //Mutant = "Gunther";
        System.out.println(Mutant);

        final String NewMutant = Mutant + " is a fun guy!";
        System.out.println(NewMutant);

        String AnotherMutant = NewMutant + " Very Nice";
        System.out.println(AnotherMutant);

        AnotherMutant = "Whoops, all gone.";
        System.out.println(AnotherMutant);
    }
}
