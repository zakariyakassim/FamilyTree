package com.qa;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Family {

    private ArrayList<Person> family = new ArrayList<>();


    public boolean setParentOf(String childName, String parentName) {

        Person child = new Person(childName);
        Person parent = new Person(parentName);

        child.addParent(parent);
        parent.addChild(child);


        family.add(child);
        family.add(parent);



      /*  Person parent = family.stream()
                .filter(x -> childName.equals(x.getName()))
                .findAny().get(); */


      /*  family.stream()
                .filter(x -> childName.equals(x.getName()))
                .findAny().get().setParent(new Person(parentName)); */


        return true;
    }


    public Boolean male(String name) {

        for (int i = 0; i < this.family.size(); i++) {

            String result = this.family.get(i).getName();

            if (result.equalsIgnoreCase(name)) {

                this.family.get(i).setGender(Person.Gender.MALE);

                Person spouse = this.family.get(i).getSpouse();

                if (spouse != null) {

                    this.family.get(i).getSpouse().setGender(Person.Gender.FEMALE);

                }
            }

        }


        return true;
    }

    public Boolean female(String name) {

        this.family.stream()
                .filter(x -> name.equals(x.getName()))
                .findAny().get().setGender(Person.Gender.MALE);

        return true;
    }







    public ArrayList<String> getParents(String name) {

      /*  ArrayList<String> parents = family.stream()
                .filter(x -> name.equals(x.getName()))
                .findAny().get().getParents(); */

        return null;
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
                .findFirst().get().getChildren();

        ArrayList<String> childrenNames = new ArrayList<>();

        childrenNames.addAll(children.stream()
                .map(object -> Objects.toString(object, null))
                .collect(Collectors.toList()));

        return childrenNames;

    }

    public ArrayList<Person> getFamily() {
        return this.family;
    }

}
