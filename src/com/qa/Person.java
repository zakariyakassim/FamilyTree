package com.qa;

import java.util.ArrayList;

public class Person {

    public static enum Gender {
        MALE,
        FEMALE;
    }

    private String name;
    private Gender gender;
    private Person father;
    private Person mother;
    private ArrayList<Person> children;

    public String getName() {
        return name;
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

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setParent(Person parent){
        if (parent.getGender() == Gender.MALE){
            this.father = parent;
        }
        if (parent.getGender() == Gender.FEMALE){
            this.mother = parent;
        }
    }
    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Person> children) {
        this.children = children;
    }

    public ArrayList<String> getParents(){
        ArrayList<String> parents = new ArrayList<>();
        parents.add(this.father.getName());
        parents.add(this.mother.getName());
        return parents;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
