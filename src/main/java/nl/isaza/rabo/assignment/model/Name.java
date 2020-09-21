package nl.isaza.rabo.assignment.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Name {
    private String title;
    private String first;
    private String surname;

    public Name(String title, String first, String surname) {
        this.title = title;
        this.first = first;
        this.surname = surname;
    }
}
