package com.qa;

import java.util.ArrayList;

public class Person {

    public static enum Gender {
        MALE {
            public String toString() {
                return "Male";
            }
        },
        FEMALE {
            public String toString() {
                return "Female";
            }
        };
    }

    private String name;
    private Gender gender;
    private Person spouse;
    private ArrayList<Person> parents = new ArrayList<>();
    private ArrayList<Person> children = new ArrayList<>();

    public Person() {


    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void addParent(Person parent) {
        this.parents.add(parent);

        if (this.parents.size() == 2) {
            this.parents.get(0).setSpouse(this.parents.get(1));
            this.parents.get(1).setSpouse(this.parents.get(0));
        }
    }

    public ArrayList<Person> getParents() {
        return this.parents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }



    public ArrayList<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }


    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
