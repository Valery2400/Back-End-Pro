package de.ait;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        List<String> list = List.of("jack","ann", "lena","klaus");

        List<String> list1 = list.stream()
                .filter(s -> s.length() > 3)
                .toList();

        System.out.println(list1);

        System.out.println(list.stream()
                .filter(s -> s.length() > 3)
                .map(s -> s.toUpperCase())
                .toList());

        List<Person> people = List.of(
                new Person("jack", List.of("qwe", "qwa", "qwo")),
                new Person("jack1", List.of("das", "der", "die")),
                new Person("jack2", List.of("the", "a", "who"))
                );
        List <String> list2 = people.stream()
                .flatMap( p -> p.getWord().stream())
                .toList();
        System.out.println(list2);


    }
}
