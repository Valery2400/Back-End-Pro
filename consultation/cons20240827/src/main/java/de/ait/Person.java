package de.ait;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@ToString
@Builder
public class Person {
    private String fName;
    private String lName;
    private String mName;

    private int age;
    private String phone;
    private String gender;
    @Singular private List<Pet> pets;


}
