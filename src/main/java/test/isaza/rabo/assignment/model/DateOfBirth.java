package nl.isaza.rabo.model;

import java.util.Date;

public class DateOfBirth {
    private Date date;
    private Integer age;

    public DateOfBirth(Date date, Integer age) {
        this.date = date;
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
