package nl.isaza.rabo.assignment.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DateOfBirth {
    private Date date;
    private Integer age;

    public DateOfBirth(Date date, Integer age) {
        this.date = date;
        this.age = age;
    }
}
