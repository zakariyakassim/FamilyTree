package com.qa;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Family {

    private ArrayList<Person> family = new ArrayList<>();

    public Boolean setParentOf() {
        return true;
    }

    public Boolean male(String name) {
        return true;
    }

    public Boolean female(String name) {
        return true;
    }

    public boolean setParent(String childName, String parentName) {

        Person parent = family.stream()
                .filter(x -> childName.equals(x.getName()))
                .findAny().get();


        family.stream()
                .filter(x -> childName.equals(x.getName()))
                .findAny().get().setParent(parent);


        return true;
    }


    public ArrayList<String> getParents(String name) {

        ArrayList<String> parents = family.stream()
                .filter(x -> name.equals(x.getName()))
                .findAny().get().getParents();

        return parents;
    }

   /* public ArrayList<Person> getChildren(String name) {
        Person result = null;
        for (Person person : family) {
            if (name.equals(person.getName())) {
                result = person;
            }
        }
        return result.getChildren();
    } */

    public ArrayList<String> getChildren(String name) {


        ArrayList<Person> children = family.stream()
                .filter(x -> name.equals(x.getName()))
                .findAny().get().getChildren();

        ArrayList<String> childrenNames = new ArrayList<>();

        childrenNames.addAll(children.stream()
                .map(object -> Objects.toString(object, null))
                .collect(Collectors.toList()));

        return childrenNames;

    }

}
