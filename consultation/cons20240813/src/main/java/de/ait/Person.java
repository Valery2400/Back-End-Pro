package de.ait;

import java.util.List;

public class Person {
    private String name;
    private List<String> word;

    public Person(String name, List<String> word) {
        this.name = name;
        this.word = word;
    }

    public String getName() {
        return name;
    }


    public List<String> getWord() {
        return word;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", word=" + word +
                '}';
    }

}
