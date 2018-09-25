package com.qa;

import java.util.Scanner;

public class Main {

    Scanner input = new Scanner(System.in);

    public void run() {

        Family fam = new Family();

        fam.setParentOf("Frank", "Morgan"); // true
        fam.setParentOf("Frank", "Alice"); // true
        fam.male("Morgan");
        fam.male("Frank");

        fam.getFamily().forEach(person -> {
            System.out.print(person.getName() + "  " + person.getGender().toString());
            System.out.println();
        });

    }


    public static void main(String[] args) {

        new Main().run();

    }
}
