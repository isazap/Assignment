package nl.isaza.rabo.assignment.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DateOfBirth {
    private LocalDate date;
    private Integer age;

    public DateOfBirth(LocalDate date, Integer age) {
        this.date = date;
        this.age = age;
    }
}
