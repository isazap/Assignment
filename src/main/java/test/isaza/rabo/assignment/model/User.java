package nl.isaza.rabo.model;

import java.net.URL;

public class User {
    private Name name;
    private Gender gender;
    private DateOfBirth dob;
    private URL picture;

    public User(Name name, Gender gender, DateOfBirth dob, URL picture) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.picture = picture;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public DateOfBirth getDob() {
        return dob;
    }

    public void setDob(DateOfBirth dob) {
        this.dob = dob;
    }

    public URL getPicture() {
        return picture;
    }

    public void setPicture(URL picture) {
        this.picture = picture;
    }
}
