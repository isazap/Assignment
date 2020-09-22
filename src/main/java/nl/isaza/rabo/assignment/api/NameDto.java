package nl.isaza.rabo.assignment.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import nl.isaza.rabo.assignment.model.Name;

@Getter
public class NameDto {
    private final String title;
    private final String first;
    private final String surname;

    @JsonCreator
    public NameDto(
            String title,
            String first,
            String surname) {
        this.title = title;
        this.first = first;
        this.surname = surname;
    }

    public NameDto(Name name) {
        this.title = name.getTitle();
        this.first = name.getFirst();
        this.surname = name.getSurname();
    }
}
